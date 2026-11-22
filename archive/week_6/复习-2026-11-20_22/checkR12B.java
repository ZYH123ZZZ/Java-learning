// 复习 12B · 字节流（待复习清单第 12 条，C 档，11-22）
// 目标 20 分钟。闭卷。禁用：Files.* 、readAllBytes、RandomAccessFile.skip。
//
// 换了个方向：R12 是「整份搬完」，这道是「搬前面一段就停」——
// 循环不再是「一直到文件结束」，而是「还没搬够 n 个就继续」，两个条件都得看着。
// 你要自己算「这一次最多能要几个字节」，不能想当然地把 n 直接塞进 read。

import java.io.*;

public class checkR12B {

    // 【1】copyHead(String from, String to, int n) —— 只把 from 的前 n 个字节搬到 to
    //
    //     规则：
    //       · 返回实际写出去的字节数
    //       · n 比文件还大，就把文件整个搬完，返回文件真实长度
    //       · n 是 0 → 目标文件要建出来，长度 0，返回 0
    //       · 目标已存在就整个覆盖
    //       · 一次 read 最多读 1024 个字节，所以「这一次要几个」得自己算，
    //         不能把 n 直接当长度塞进 read/write（n 可能是 3000）
    //
    //     教材：read(byte[]) 返回这次读到几个、读完 -1（第五周练习.md:609、:618）
    //           write(byte[], off, len)（:609）
    //           自己求最小值那种写法（第二周练习.md:529 的 findMin 骨架）
    //
    //     copyHead(3000 字节的文件, 目标, 1500) → 目标 1500 字节，返回 1500
    //     copyHead(3000 字节的文件, 目标, 9999) → 目标 3000 字节，返回 3000
    static int copyHead(String from, String to, int n) {
        try (FileInputStream in = new FileInputStream(from);
             FileOutputStream out = new FileOutputStream(to)) {
            byte[] buf = new byte[1024];
            int n1;
            int written = 0;
            while (written < n) {
                int want = n - written;
                if (want > buf.length) {
                    want = buf.length;
                }
                int got = in.read(buf, 0, want);
                if (got == -1) {
                    break;
                }
                out.write(buf, 0, got);
                written += got;
            }
//            while ((n1 = in.read(buf)) != -1) {
//                if (n > buf.length) {
//                    out.write(buf, 0, n1);
//                    n -= 1024;//n 变化的情况下要小心
//                }else if (n <= buf.length) {//二选一
//                    out.write(buf, 0, n);
//                    break;
//                }
//            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 你写
        File To = new File(to);
        return Math.toIntExact(To.length());
    }

    public static void main(String[] args) throws IOException {
        String base = System.getProperty("java.io.tmpdir") + "r12b";

        String s1 = base + "\\ten.bin";      // 0123456789
        writePattern(s1, 10);

        String t1 = base + "\\t1.bin";
        int r1 = copyHead(s1, t1, 4);
        show("判据1 源 10 字节、要前 4 个", t1, 4, r1, 4, sameHead(s1, t1, 4));

        String s2 = base + "\\big.bin";      // 3000 字节，跨 3 块
        writePattern(s2, 3000);

        String t2 = base + "\\t2.bin";
        int r2 = copyHead(s2, t2, 1500);
        show("判据2 源 3000 字节、要前 1500", t2, 1500, r2, 1500, sameHead(s2, t2, 1500));

        String t3 = base + "\\t3.bin";
        int r3 = copyHead(s2, t3, 9999);
        show("判据3 要 9999 个（比文件大）", t3, 3000, r3, 3000, sameHead(s2, t3, 3000));

        String t4 = base + "\\t4.bin";
        int r4 = copyHead(s2, t4, 0);
        show("判据4 要 0 个", t4, 0, r4, 0, true);
    }

    static void show(String tag, String target, long wantLen, int gotRet, int wantRet, boolean sameHead) {
        File f = new File(target);
        String len = f.exists() ? String.valueOf(f.length()) : "文件没建出来";
        System.out.println(tag + " → 目标 " + len + " 字节，前言"
                + (sameHead ? "一致" : "不一致") + "，返回 " + gotRet
                + "   期望 " + wantLen + " 字节，前言一致，返回 " + wantRet);
    }

    // ---- 下面是脚手架，不用改 ----

    static boolean sameHead(String a, String b, int n) {
        try {
            byte[] x = java.nio.file.Files.readAllBytes(new File(a).toPath());
            byte[] y = java.nio.file.Files.readAllBytes(new File(b).toPath());
            if (y.length != n) {
                return false;
            }
            for (int i = 0; i < n; i++) {
                if (x[i] != y[i]) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            return false;
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
