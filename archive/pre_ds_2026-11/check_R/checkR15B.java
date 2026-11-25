// 复习 15-B · 字符流语义（针对 checkR15 那两处错的加练，2026-11-22）
// 目标 25 分钟。闭卷。禁用：Files.* / Files.readAllLines / readAllBytes。
// 只做这一道。不考 countLines、不考 endsWithNewLine（那两个你已经零提示写对了）。
//
// 上一题错在哪，这题专打这两处：
//   ① `buf[nsave-1] == '\n'` 条件写反了 —— 这题要你别靠猜"该不该补"，先把整份读进内存再说
//   ② 分支里写一次、分支外又写一次 —— 这题有"超出范围就不许动文件"这一路，
//      写成"if (...) 改；然后无论如何都写回"就会把文件冲掉
//   ③ 写回时必须用**覆盖**模式（教材 :725），给 true 会在尾部留下旧内容
//
// 教材：E:\dsh\java\第五周练习.md:677 读、:709 写、:714 newLine、:725 覆盖、:729 追加
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.DataTruncation;
import java.util.ArrayList;
import java.util.List;

public class checkR15B {

    // replaceLine(String path, int lineNo, String newLine) —— 把第 lineNo 行换成 newLine
    //   lineNo 从 1 开始数
    //   返回：替换之后文件里一共有几行
    //   文件不存在           → 抛 RuntimeException("文件不存在")
    //   lineNo < 1 或超过总行数 → **一个字节都不许改**，返回原来的行数
    //   写回时每一行后面都补一个换行（最后一行也补）
    //   必须用覆盖模式写回（不许用追加）
    //
    //   replaceLine("三行.txt", 2, "new")  → 返回 3，文件变成 r1 / new / r3
    static int replaceLine(String path, int lineNo, String newLine) {
        int count = 0;
        List<String> lines = new ArrayList<>();
        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            int lineNocount = lineNo;
            String line1;
            while ((line1 = br1.readLine()) != null) {
                count++;
                lines.add(line1);
            }

            if (lineNo < 1 || count < lineNo) {

                return count;
            }

            lines.set(lineNo - 1, newLine);

            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8))) {
                for (String l : lines) {
                    bw.write(l);
                    bw.newLine();
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 你写
        return count;
    }

    // ===== 下面是测试脚手架，不要改 =====

    static void putRaw(String path, String content) {
        try (BufferedWriter w = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8))) {
            w.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String readAll(String path) {
        if (!new File(path).exists()) {
            return "<文件没建出来>";
        }
        StringBuilder sb = new StringBuilder();
        try (BufferedReader r = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            int c;
            while ((c = r.read()) != -1) {
                sb.append((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    static int countNl(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\n') {
                n++;
            }
        }
        return n;
    }

    static String show(String s) {
        return "[" + s.replace("\r", "\\r").replace("\n", "\\n") + "]";
    }

    public static void main(String[] args) throws IOException {
        String base = System.getProperty("java.io.tmpdir") + "r15b";
        new File(base).mkdirs();

        // 判据 1：普通 3 行文件，替换第 2 行
        String f1 = base + "\\f1.txt";
        putRaw(f1, "r1\nr2\nr3\n");
        int n1 = replaceLine(f1, 2, "new");
        System.out.println("判据1 三行改第2行 → 返回 " + n1 + "  内容 " + show(readAll(f1))
                + "   期望 返回 3，[r1\\r\\nnew\\r\\nr3\\r\\n]");

        // 判据 2：末尾没有换行的 2 行文件，替换最后一行（这一格考的就是"文件现在是什么状态"）
        String f2 = base + "\\f2.txt";
        putRaw(f2, "a\nb");
        int n2 = replaceLine(f2, 2, "bbb");
        System.out.println("判据2 末尾无换行 → 返回 " + n2 + "  内容 " + show(readAll(f2))
                + "   期望 返回 2，[a\\r\\nbbb\\r\\n]");

        // 判据 3：行号超出范围，文件必须一个字节都没动
        String f3 = base + "\\f3.txt";
        putRaw(f3, "x\ny\nz");
        int n3 = replaceLine(f3, 9, "不会写进去");
        System.out.println("判据3 行号超范围 → 返回 " + n3 + "  内容 " + show(readAll(f3))
                + "   期望 返回 3，[x\\ny\\nz]（内容一个字没动）");

        // 判据 4：空文件
        String f4 = base + "\\f4.txt";
        putRaw(f4, "");
        int n4 = replaceLine(f4, 1, "hello");
        System.out.println("判据4 空文件     → 返回 " + n4 + "  内容 " + show(readAll(f4))
                + "   期望 返回 0，[]");

        // 判据 5：新行比原来短，用追加模式会在尾部留旧内容
        String f5 = base + "\\f5.txt";
        putRaw(f5, "aaaa\nbbbb\ncccc\n");
        int n5 = replaceLine(f5, 1, "x");
        System.out.println("判据5 换成更短   → 返回 " + n5 + "  内容 " + show(readAll(f5))
                + "   期望 返回 3，[x\\r\\nbbbb\\r\\ncccc\\r\\n]");
    }
}
