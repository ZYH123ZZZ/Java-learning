// 复习 15 · 字符流语义（待复习清单第 15 条，B 档，11-22 第 1 次复习）
// 目标 35 分钟。闭卷。禁用：Files.* / Files.readAllLines / readAllBytes / 用 String.split("\n") 数行。
//
// 这是原题重写：archive\week_5\Day33总\check\checkD33.java（Day33 那道）
// 当年两个坑：endsWithNewLine 里 read 的返回值没接住；FileWriter 打开即截断没意识到。
// 教材：E:\dsh\java\第五周练习.md:649（Day33 字符流）、:677 读、:709 写、:725 默认覆盖、:729 追加
import java.io.*;
import java.nio.charset.StandardCharsets;

public class checkR15 {

    // 【1】countLines(String path) —— 返回这个文件有多少行
    //     一行 = readLine() 读到的一个 String（末尾没换行的最后一行也算一行）
    //     文件不存在 → 抛 RuntimeException("文件不存在")
    //     空文件 → 0
    //
    //     countLines("5行.txt") → 5      countLines("空.txt") → 0
    static int countLines(String path) {
        int countLine = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                countLine++;
            }

        } catch (Exception e) {
            throw new RuntimeException("文件不存在");
        }
        // 你写
        return countLine;
    }

    // 【2】endsWithNewLine(File f) —— 文件的最后一个字节是不是换行符 '\n'
    //     空文件 → false；不存在 → false（不用抛异常）
    //     提示：最后一个字节的意思是"读完之后，buf 里最后一个有效字节"
    //     教材 第五周练习.md:618（n 是实际读到的字节数，不是 1024）
    //
    //     endsWithNewLine(以换行结尾的文件) → true
    static boolean endsWithNewLine(File f) {
        if (!f.exists()) {
            return false;
        }

        if (f.length() == 0) {
            return false;
        }

        try (FileInputStream in = new FileInputStream(f.getAbsolutePath())) {
            byte[] buf = new byte[1024];
            int n;
            int nsave = 0;
            while ((n = in.read(buf)) != -1) {
                nsave = n;
            }
            return buf[nsave - 1] == '\n';
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 你写
    }

    // 【3】appendLine(String path, String s) —— 在文件末尾追加一行 s
    //     规则：文件不存在 → 建出来只写这一行
    //           文件非空、且末尾不是换行 → 先补一个换行，再写 s（否则会跟上一行粘在一起）
    //           写完 s 要再补一个换行
    //     必须用追加模式（教材 :729 第二个参数 true），不许先读出来再整个覆盖写
    //
    //     appendLine("末尾没换行的.txt", "第二行") → 文件变成两行，第一行还是原来那句
    static void appendLine(String path, String s) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8));
             FileInputStream in = new FileInputStream(path);) {

            byte[] buf = new byte[1024];
            int n;

            File f = new File(path);
            if (f.length() == 0) {
                bw.write(s);
            } else {
                int nsave = 0;
                while ((n = in.read(buf)) != -1) {
                    nsave = n;
                }
                if (buf[nsave - 1] != '\n') {
                    bw.newLine();
                }
            }

            if (f.length() != 0) {
                bw.write(s);
            }
            bw.newLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 你写
    }

    // ===== 下面是测试脚手架，不要改 =====

    // 用 UTF-8 写一个文件，内容原样存（不做任何换行处理）
    static void putRaw(String path, String content) {
        try (BufferedWriter w = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8))) {
            w.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 读回整个文件（用 UTF-8），用来核对 appendLine 的结果
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

    // 数一个字符串里有几个 '\n'
    static int countNl(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\n') {
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        String base = System.getProperty("java.io.tmpdir") + "r15";
        new File(base).mkdirs();
        // 让判据 4/5/6 每次都从干净状态开始（上一轮留下的文件先清掉）
        new File(base + "\\a1.txt").delete();
        new File(base + "\\a2.txt").delete();

        String five = base + "\\five.txt";
        putRaw(five, "l1\nl2\nl3\nl4\nl5\n");

        String noLastNl = base + "\\noLastNl.txt";
        putRaw(noLastNl, "l1\nl2\nl3\nl4\nl5");          // 最后一行没有换行

        String empty = base + "\\empty.txt";
        putRaw(empty, "");

        String cn = base + "\\cn.txt";
        putRaw(cn, "第一行\n第二行\n第三行\n");

        // 判据 1：5 行
        System.out.println("判据1  countLines(5行)     → " + countLines(five) + "   期望 5");

        // 判据 2：空文件
        System.out.println("判据2  countLines(空文件)   → " + countLines(empty) + "   期望 0");

        // 判据 3：不存在要抛 RuntimeException("文件不存在")
        String msg;
        try {
            countLines(base + "\\nothing.txt");
            msg = "没抛异常";
        } catch (RuntimeException e) {
            msg = e.getMessage();
        }
        System.out.println("判据3  countLines(不存在)   → " + msg + "   期望 文件不存在");

        // 判据 4：末尾没换行的文件，appendLine 之后必须是两行、不能粘
        String a1 = base + "\\a1.txt";
        putRaw(a1, "第一句");
        appendLine(a1, "第二句");
        String r1 = readAll(a1);
        System.out.println("判据4  appendLine(末尾无换行) → 换行数 " + countNl(r1)
                + "  内容 [" + r1.replace("\n", "\\n").replace("\r", "\\r") + "]   期望 换行数 2，两行分开");

        // 判据 5 / 6：空文件追加一次只有 1 行；再追加一次变 2 行
        String a2 = base + "\\a2.txt";
        appendLine(a2, "只一行");
        String r2 = readAll(a2);
        System.out.println("判据5  appendLine(空文件)    → 换行数 " + countNl(r2)
                + "  内容 [" + r2.replace("\n", "\\n").replace("\r", "\\r") + "]   期望 换行数 1，前面没有空行");

        appendLine(a2, "加第二行");
        String r3 = readAll(a2);
        System.out.println("判据6  再追加一次           → 换行数 " + countNl(r3)
                + "  内容 [" + r3.replace("\n", "\\n").replace("\r", "\\r") + "]   期望 换行数 2");

        // 判据 7：endsWithNewLine 三种情况
        System.out.println("判据7  endsWithNewLine(以换行结尾) → " + endsWithNewLine(new File(five))
                + "   期望 true   ／ (末尾无换行) → " + endsWithNewLine(new File(noLastNl))
                + "   期望 false  ／ (空文件) → " + endsWithNewLine(new File(empty)) + "   期望 false");

        // 判据 8：中文文件行数（编码对了才不出错）
        System.out.println("判据8  countLines(中文3行)  → " + countLines(cn) + "   期望 3");
    }
}
