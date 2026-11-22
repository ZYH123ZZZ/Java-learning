// 复习 14C · 多流 try(...) 套哪层（待复习清单第 14 条加练，11-21）
// 目标 20 分钟。闭卷。禁用：Files.copy / Files.readAllBytes / RandomAccessFile（必须自己用 byte[1024] 搬）。
import java.io.*;
import java.util.Arrays;

public class checkR14C {

    // 【1】interleave(String pathA, String pathB, String outPath)
    //     把 A、B 两个文件「轮流各搬一块」拼进 outPath，每块最多 1024 字节：
    //         第 1 轮：先搬 A 的一块，再搬 B 的一块
    //         第 2 轮：再搬 A 的一块，再搬 B 的一块
    //         一直轮下去，直到 A、B 都搬完
    //     哪个先搬完，后面的轮次就只搬另一个（不是立刻结束）
    //     outPath 里是「这一次」的结果，不是接着上次往后加
    //
    //     教材：try(...) 写法 E:\dsh\java\第五周练习.md:582-591
    //           标准搬运 while ((n = in.read(buf)) != -1) :603-608
    //           out.write(buf, 0, n) 只写实际读到的那 n 个 :609 / :617
    //           「n 是实际读到的字节数，不是 1024」:618
    //
    //     interleave(t1, t2, out)，t1 = "aaaaa"、t2 = "bbbbbbb"
    //         → out 里是 "aaaaabbbbbbb"，长度 12
    static void interleave(String pathA, String pathB, String outPath) {

        try (FileOutputStream out = new FileOutputStream(outPath);
             FileInputStream A = new FileInputStream(pathA);
             FileInputStream B = new FileInputStream(pathB)) {
            int na;
            int nb;
            byte[] bufa = new byte[1024];
            byte[] bufb = new byte[1024];

            do {
                na = A.read(bufa);
                nb = B.read(bufb);

                if (na != -1) {
                    for (int i = 0; i < na; i++) {
                        out.write(bufa[i]);
                    }
                }

                if (nb != -1) {
                    for (int i = 0; i < nb; i++) {
                        out.write(bufb[i]);
                    }
                }
            } while (na != -1 || nb != -1);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 你写
    }

    // ---- 下面是脚手架，不用改 ----

    static byte[] readBytes(String path) throws IOException {
        File f = new File(path);
        byte[] all = new byte[(int) f.length()];
        int off = 0;
        try (FileInputStream in = new FileInputStream(path)) {
            int n;
            while (off < all.length && (n = in.read(all, off, all.length - off)) != -1) {
                off += n;
            }
        }
        return all;
    }

    static void writeBytes(String path, byte[] data) throws IOException {
        try (FileOutputStream o = new FileOutputStream(path)) {
            o.write(data);
        }
    }

    static byte[] repeat(char c, int len) {
        byte[] a = new byte[len];
        Arrays.fill(a, (byte) c);
        return a;
    }

    static boolean allIs(byte[] a, int from, int to, byte v) {
        for (int i = from; i < to; i++) {
            if (a[i] != v) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("java.io.tmpdir") + "r14ccheck";
        new File(dir).mkdirs();

        String t1 = dir + "\\t1.bin";
        String t2 = dir + "\\t2.bin";
        String bigA = dir + "\\bigA.bin";
        String bigB = dir + "\\bigB.bin";
        String empty = dir + "\\empty.bin";
        String five = dir + "\\five.bin";

        writeBytes(t1, "aaaaa".getBytes("UTF-8"));
        writeBytes(t2, "bbbbbbb".getBytes("UTF-8"));
        writeBytes(bigA, repeat('a', 1024));
        writeBytes(bigB, repeat('b', 1024));
        writeBytes(empty, new byte[0]);
        writeBytes(five, "bbbbb".getBytes("UTF-8"));

        // 判据 1：小文件轮流搬 → 长度 12，内容是 a 的全部再 b 的全部
        String out1 = dir + "\\out1.bin";
        interleave(t1, t2, out1);
        byte[] r1 = readBytes(out1);
        System.out.println("判据1 长度 " + r1.length + "   期望 12");
        System.out.println("判据1 内容 " + new String(r1, "UTF-8") + "   期望 aaaaabbbbbbb");

        // 判据 2：各 1024 字节 → 长度 2048，前 1024 全 a、后 1024 全 b
        String out2 = dir + "\\out2.bin";
        interleave(bigA, bigB, out2);
        byte[] r2 = readBytes(out2);
        System.out.println("判据2 长度 " + r2.length + "   期望 2048");
        if (r2.length == 2048) {
            System.out.println("判据2 前1024全a " + allIs(r2, 0, 1024, (byte) 'a') + "   期望 true");
            System.out.println("判据2 后1024全b " + allIs(r2, 1024, 2048, (byte) 'b') + "   期望 true");
        } else {
            System.out.println("判据2 长度不对，前后半段没法比");
        }

        // 判据 3：A 是 0 字节空文件、B 5 字节 → 长度 5，内容 bbbbb（A 一次都没读到，不许崩）
        String out3 = dir + "\\out3.bin";
        interleave(empty, five, out3);
        byte[] r3 = readBytes(out3);
        System.out.println("判据3 长度 " + r3.length + "   期望 5");
        System.out.println("判据3 内容 " + new String(r3, "UTF-8") + "   期望 bbbbb");

        // 判据 4：两个都空 → out 是 0 字节文件
        String out4 = dir + "\\out4.bin";
        interleave(empty, empty, out4);
        System.out.println("判据4 长度 " + new File(out4).length() + "   期望 0");
    }
}
