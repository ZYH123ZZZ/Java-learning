// 复习 12 · 字节流 copy（待复习清单第 12 条，C 档，11-22）
// 目标 20 分钟。闭卷。禁用：Files.* 、readAllBytes（这题就是考你自己开流搬字节）。
//
// 这条当年没自己写过：buf / n / while / write 四行是我从零讲的，你填进去就对了。
// 所以这次从零写一遍，判据只有一条硬标准 —— 复制完两个文件的内容一模一样。
// 要用的两样（教材 第五周练习.md）：
//   读：FileInputStream.read(byte[]) 返回「这次到底读到几个字节」，读完返回 -1（:609、:618）
//   写：FileOutputStream.write(byte[], int off, int len)（:609）
//   资源：try (流1; 流2) { ... }，括号里的东西出块自动关（:1018 一带）

import java.io.*;
import java.nio.file.Files;

public class checkR12 {

    // 【1】copy(String from, String to) —— 把 from 的内容整份复制到 to
    //
    //     规则：
    //       · to 不存在就新建；已存在就整个覆盖（不能留下来原来的尾巴）
    //       · 源是 0 字节 → 目标也要建出来，长度 0
    //       · 用完的流必须关，写在 try(...) 的括号里
    //       · 不许用 Files.copy / readAllBytes，必须自己 read/write
    //
    //     copy(10 字节的小文件, 目标)      → 目标 10 字节，内容一致
    //     copy(3000 字节的文件, 目标)      → 目标 3000 字节，内容一致
    //     copy(0 字节的文件, 目标)         → 目标存在，0 字节
    //     copy(10 字节, 一个原来 5000 字节的目标) → 目标变成 10 字节，不残留
    static void copy(String from, String to) {
        try (FileInputStream in = new FileInputStream(from);
             FileOutputStream out = new FileOutputStream(to)) {
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) != -1) {
                out.write(buf, 0, n);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 你写
    }

    public static void main(String[] args) throws IOException {
        String base = System.getProperty("java.io.tmpdir") + "r12";

        String s1 = base + "\\small.txt";
        write(s1, 10, 'a');
        String t1 = base + "\\t1.bin";
        copy(s1, t1);
        show("判据1 10 字节", t1, 10, same(s1, t1));

        String s2 = base + "\\big.bin";
        writePattern(s2, 3000);
        String t2 = base + "\\t2.bin";
        copy(s2, t2);
        show("判据2 3000 字节（跨 3 块）", t2, 3000, same(s2, t2));

        String s3 = base + "\\empty.bin";
        write(s3, 0, 'a');
        String t3 = base + "\\t3.bin";
        copy(s3, t3);
        show("判据3 0 字节的源", t3, 0, same(s3, t3));

        String s4 = base + "\\ten.txt";
        write(s4, 10, 'a');
        String t4 = base + "\\t4.bin";
        write(t4, 5000, 'z');          // 目标原来就有东西，而且比源长
        copy(s4, t4);
        show("判据4 目标原来 5000 字节", t4, 10, same(s4, t4));
    }

    static void show(String tag, String target, long wantLen, boolean sameContent) {
        File f = new File(target);
        String len = f.exists() ? String.valueOf(f.length()) : "文件没建出来";
        System.out.println(tag + " → 目标 " + len + " 字节，内容"
                + (sameContent ? "一致" : "不一致") + "   期望 " + wantLen + " 字节，内容一致");
    }

    // ---- 下面是脚手架，不用改 ----
    // 脚手架里用了 Files.readAllBytes 只是为了比内容，你的 copy 里不许用。

    static boolean same(String a, String b) {
        try {
            byte[] x = Files.readAllBytes(new File(a).toPath());
            byte[] y = Files.readAllBytes(new File(b).toPath());
            if (x.length != y.length) {
                return false;
            }
            for (int i = 0; i < x.length; i++) {
                if (x[i] != y[i]) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    static void write(String path, int bytes, char c) throws IOException {
        new File(path).getParentFile().mkdirs();
        byte[] data = new byte[bytes];
        for (int i = 0; i < bytes; i++) {
            data[i] = (byte) c;
        }
        try (FileOutputStream out = new FileOutputStream(path)) {
            out.write(data);
        }
    }

    static void writePattern(String path, int bytes) throws IOException {
        new File(path).getParentFile().mkdirs();
        byte[] data = new byte[bytes];
        for (int i = 0; i < bytes; i++) {
            data[i] = (byte) ('a' + i % 26);
        }
        try (FileOutputStream out = new FileOutputStream(path)) {
            out.write(data);
        }
    }
}
