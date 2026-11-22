// 复习 23 · read 返回值与缓冲区残留（待复习清单第 23 条，B 档，11-21）
// 目标 15 分钟。闭卷。禁用：Files.*、readAllBytes（必须自己用 byte[1024] 一块块读）。
import java.io.*;
import java.util.Collections;

public class checkR23A {

    // 【1】sumBytes(String path) —— 把文件里每个字节的值加起来，返回总和
    //     文件里的内容全是 ASCII 可见字符（'a'..'z'、'A'、'0'..'9'），不用担心 byte 负数
    //     空文件 → 返回 0
    //
    //     教材：while ((n = in.read(buf)) != -1)  E:\dsh\java\第五周练习.md:603-608
    //           「n 是实际读到的字节数，不是 1024」:618
    //
    //     sumBytes("0123456789") → 525        （'0'=48 … '9'=57，加起来 525）
    //     sumBytes(1024 个 'A')  → 66560      （65 × 1024）
    static long sumBytes(String path) {
        File f1 = new File(path);

        if (!f1.exists()) {
            return 0;
        }

        long sumBytes = 0;

        try (FileInputStream in = new FileInputStream(path)) {
            int n;
            byte[] buf = new byte[1024];
            while ((n = in.read(buf)) != -1) {
                for (int i = 0; i < n; i++) {
                    sumBytes += buf[i];
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return sumBytes;
        // 你写
    }

    // ---- 下面是脚手架，不用改 ----

    static void writeBytes(String path, byte[] data) throws IOException {
        try (FileOutputStream o = new FileOutputStream(path)) {
            o.write(data);
        }
    }

    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("java.io.tmpdir") + "r23check";
        new File(dir).mkdirs();

        // 判据 1：10 个字符，一块都读不满
        String p1 = dir + "\\d1.bin";
        writeBytes(p1, "0123456789".getBytes("UTF-8"));
        System.out.println("判据1 十位数字   → " + sumBytes(p1) + "   期望 525");

        // 判据 2：正好 1024 字节，最后一块是满的
        String p2 = dir + "\\d2.bin";
        byte[] a1024 = new byte[1024];
        long exp2 = 0;
        for (int i = 0; i < a1024.length; i++) {
            a1024[i] = (byte) 'A';
            exp2 += a1024[i];
        }
        writeBytes(p2, a1024);
        System.out.println("判据2 1024 个 A → " + sumBytes(p2) + "   期望 " + exp2);

        // 判据3：3000 字节，最后一块只有 952 字节
        String p3 = dir + "\\d3.bin";
        byte[] big = new byte[3000];
        long exp3 = 0;
        for (int i = 0; i < big.length; i++) {
            big[i] = (byte) ('a' + i % 26);
            exp3 += big[i];
        }
        writeBytes(p3, big);
        System.out.println("判据3 3000 字节 → " + sumBytes(p3) + "   期望 " + exp3);

        // 判据 4：空文件
        String p4 = dir + "\\d4.bin";
        writeBytes(p4, new byte[0]);
        System.out.println("判据4 空文件     → " + sumBytes(p4) + "   期望 0");
    }
}
