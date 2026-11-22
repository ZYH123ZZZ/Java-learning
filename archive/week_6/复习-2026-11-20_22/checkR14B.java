// 加练 · File 只是路径，建/改文件靠「打开」（待复习清单第 11 条，11-21）
// 目标 15 分钟。闭卷。禁用：Files.*（只能 File + 字节流）。

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class checkR14B {

    // 【1】ensure(String path, int size) —— 保证 path 上正好是一个 size 字节的文件，返回「我动过没有」
    //     ★ 下面四条是【输出要求】：说的是 path 上的文件最后长成什么样，不是「调哪个 API 一步搞定」
    //     不存在            → 最后是 size 字节、内容全 0 的文件，返回 true
    //     已存在、长度正好 size → 一个字节都不许碰（内容原样保留），返回 false
    //     已存在、长度不对    → 改写成 size 字节、内容全 0，返回 true
    //     是目录            → 返回 false，不许崩
    //
    //     ★ 先记住这句：createNewFile() 只造 0 字节空文件，它不会把文件弄到 size 字节；
    //       要 size 字节要么往里写字节，要么把长度撑到 size。
    //
    //     教材：E:\dsh\java\第五周练习.md:399 exists()
    //           :408 / :456 length()（对目录无效）
    //           :409 isFile() / isDirectory()
    //           :478「以为 new File("a.txt") 会建文件 → 不会」
    //
    //     ensure(p, 5) 且 p 不存在 → true，p 变成 5 个 0
    //     ensure(p, 5) 且 p 已经是 5 字节 "aaaaa" → false，"aaaaa" 一个字都不变
    static boolean ensure(String path, int size) {
        if (new File(path).isDirectory()) {
            return false;
        }

        if (!new File(path).exists()) {
            try (FileOutputStream out = new FileOutputStream(path)) {
                for (int i = 0; i < size; i++) {
                    out.write(0);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
        }

        if (new File(path).length() == size) {
            return false;
        } else {
            try (FileOutputStream out = new FileOutputStream(path)) {
                for (int i = 0; i < size; i++) {
                    out.write(0);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
    }

    static String readText(String path) throws IOException {
        File f = new File(path);
        byte[] all = new byte[(int) f.length()];
        int off = 0;
        try (FileInputStream in = new FileInputStream(path)) {
            int n;
            while (off < all.length && (n = in.read(all, off, all.length - off)) != -1) {
                off += n;
            }
        }
        java.util.Arrays.fill(all, off, all.length, (byte) 0);
        return new String(all, "UTF-8");
    }

    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("java.io.tmpdir") + "r14bcheck";
        new File(dir).mkdirs();

        // 判据 1：不存在 → 建出 5 个 0，返回 true
        String p1 = dir + "\\n1.bin";
        new File(p1).delete();
        System.out.println("判据1 返回值 " + ensure(p1, 5) + "   期望 true");
        System.out.println("判据1 长度   " + new File(p1).length() + "   期望 5");

        // 判据 2：已经是 5 字节 "aaaaa" → 返回 false，内容一个字都不许变
        String p2 = dir + "\\n2.bin";
        try (FileOutputStream o = new FileOutputStream(p2)) {
            o.write("aaaaa".getBytes("UTF-8"));
        }
        System.out.println("判据2 返回值 " + ensure(p2, 5) + "   期望 false");
        System.out.println("判据2 内容   " + readText(p2) + "   期望 aaaaa（不是全 0）");

        // 判据 3：3 字节 → 长度不对，改写成 5 个 0，返回 true
        String p3 = dir + "\\n3.bin";
        try (FileOutputStream o = new FileOutputStream(p3)) {
            o.write("abc".getBytes("UTF-8"));
        }
        System.out.println("判据3 返回值 " + ensure(p3, 5) + "   期望 true");
        System.out.println("判据3 长度   " + new File(p3).length() + "   期望 5");

        // 判据 4：传进来的是目录 → false，不许崩
        System.out.println("判据4 返回值 " + ensure(dir, 5) + "   期望 false");
        System.out.println("判据4 目录还在 " + new File(dir).isDirectory() + "   期望 true");

        // 判据 5：同一个路径连调两次 → true 然后 false，长度还是 5
        String p5 = dir + "\\n5.bin";
        new File(p5).delete();
        System.out.println("判据5 第一次 " + ensure(p5, 5) + "   期望 true");
        System.out.println("判据5 第二次 " + ensure(p5, 5) + "   期望 false");
        System.out.println("判据5 长度   " + new File(p5).length() + "   期望 5");
    }
}
