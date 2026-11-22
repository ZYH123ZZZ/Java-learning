// 复习 14 · 多流 try(...) 套哪层（待复习清单第 14 条，B 档，11-20）
// 目标 20 分钟。闭卷。禁用：Files.copy / Files.readAllBytes（必须自己用 byte[1024] 搬）。
import java.io.*;
import java.util.Arrays;

public class checkR14 {

    // 【1】merge(String[] paths, String outPath) —— 把 paths 里每个文件的内容按顺序拼进 outPath
    //     outPath 里是「这一次」的结果，不是接着上次往后加
    //     paths 是空数组时，要建出一个 0 字节的 outPath（不是不建）
    //     输出流只开一次；每搬一个文件，输入流各开一次，用完就关
    //     教材：try(...) 写法 E:\dsh\java\第五周练习.md:582-591
    //           标准搬运 while ((n = in.read(buf)) != -1) :603-608
    //           「n 是实际读到的字节数，不是 1024」:618
    //
    //     merge({"a.txt", "b.txt"}, "out.bin") → out.bin 里先是 a 的全部内容，再是 b 的全部内容
    static void merge(String[] paths, String outPath) {
        byte[] buf = new byte[1024];

        try (FileOutputStream out = new FileOutputStream(outPath)) {
            for (String x : paths) {
                try (FileInputStream in = new FileInputStream(x)) {
                    int n;
                    while ((n = in.read(buf)) != -1) {
                        for (int i = 0; i < n; i++) {
                            out.write(buf[i]);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 你写
    }

    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("java.io.tmpdir") + "r14check";
        new File(dir).mkdirs();

        byte[] five = "aaaaa".getBytes("UTF-8");
        byte[] seven = "bbbbbbb".getBytes("UTF-8");
        byte[] big = new byte[3000];
        for (int i = 0; i < big.length; i++) {
            big[i] = (byte) (i % 251);
        }
        try (FileOutputStream o1 = new FileOutputStream(dir + "\\t1.bin");
             FileOutputStream o2 = new FileOutputStream(dir + "\\t2.bin");
             FileOutputStream o3 = new FileOutputStream(dir + "\\big.bin")) {
            o1.write(five);
            o2.write(seven);
            o3.write(big);
        }

        // 判据 1：两个文件拼起来，长度 = 12，内容是前 + 后
        String out = dir + "\\out.bin";
        merge(new String[]{dir + "\\t1.bin", dir + "\\t2.bin"}, out);
        System.out.println("判据1 长度 " + new File(out).length() + "   期望 12");
        System.out.println("判据1 内容 " + readText(out) + "   期望 aaaaabbbbbbb");

        // 判据 2：空数组 → 0 字节的文件，不许崩
        String out2 = dir + "\\out2.bin";
        merge(new String[]{}, out2);
        System.out.println("判据2 长度 " + new File(out2).length() + "   期望 0");

        // 判据 3：一个 3000 字节的文件（跨三块）→ 输出也是 3000 字节
        String out3 = dir + "\\out3.bin";
        merge(new String[]{dir + "\\big.bin"}, out3);
        System.out.println("判据3 长度 " + new File(out3).length() + "   期望 3000");

        // 判据 4：同一个 outPath 再拼一次，覆盖而不是追加
        merge(new String[]{dir + "\\t2.bin"}, out);
        System.out.println("判据4 长度 " + new File(out).length() + "   期望 7（覆盖，不是 19）");
        System.out.println("判据4 内容 " + readText(out) + "   期望 bbbbbbb");
    }

    // 把文件整个读出来当字符串（只给 main 用，别改）
    static String readText(String path) throws IOException {
        byte[] all = new byte[(int) new File(path).length()];
        try (FileInputStream in = new FileInputStream(path)) {
            int off = 0;
            int n;
            while (off < all.length && (n = in.read(all, off, all.length - off)) != -1) {
                off += n;
            }
        }
        return new String(all, "UTF-8");
    }
}
