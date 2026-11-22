// 复习 11 · File 返回值语义（待复习清单第 11 条，B 档，11-21）
// 目标 20 分钟。闭卷。禁用：Files.*、Files.walk、File.length() 之外的第三方统计。
// 这一题的关键不在算法，在于你**先判断这是个什么东西，再做对应的事**。
import java.io.*;

public class checkR11A {

    // 【1】dirSize(String path) —— 按路径的「身份」分三种情况返回
    //
    //     路径不存在            → 返回 -1
    //     路径是一个普通文件    → 返回它自己的大小
    //     路径是一个目录        → 返回它下面【所有层】普通文件大小之和（子目录要递归进去）
    //                             空目录 → 返回 0（注意：不是 -1）
    //
    //     教材：exists()  E:\dsh\java\第五周练习.md:399
    //           isFile() / isDirectory()  :409
    //           length()  :408（对目录没意义）
    //           listFiles()  :452，可能返回 null，必须先判空 :462
    //           递归三动作 E:\dsh\java\第四周练习.md:784
    //
    //     dirSize(上面那种三层目录) → 26
    //     dirSize(一个 5 字节的文件) → 5
    //     dirSize(空目录)            → 0
    //     dirSize(不存在的路径)      → -1

    static long dirSize(String path) {
        long sum = 0;//不会

        File f1 = new File(path);

        if (!f1.exists()) {
            return -1;
        }

        if (f1.isFile()) {
            return f1.length();
        }


        if (f1.isDirectory()) {

            File[] f2 = f1.listFiles();
            for (File f : f2) {
                if (f.isFile()) {
                    sum += f.length();
                }
                if (f.isDirectory()) {
                    sum += dirSize(f.getPath());
                }
            }
        }
        // 你写
        return sum;
    }

    // ---- 下面是脚手架，不用改 ----

    static void write(String path, int bytes) throws IOException {
        byte[] data = new byte[bytes];
        for (int i = 0; i < bytes; i++) {
            data[i] = (byte) 'a';
        }
        try (FileOutputStream o = new FileOutputStream(path)) {
            o.write(data);
        }
    }

    public static void main(String[] args) throws IOException {
        String base = System.getProperty("java.io.tmpdir") + "r11check";
        File root = new File(base);
        root.mkdirs();

        // 判据 1：三层目录，5 + 3 + 7 + 11 = 26
        File d1 = new File(base + "\\d1");
        d1.mkdirs();
        new File(base + "\\d1\\sub").mkdirs();
        new File(base + "\\d1\\sub\\deep").mkdirs();
        write(base + "\\d1\\a.txt", 5);
        write(base + "\\d1\\b.txt", 3);
        write(base + "\\d1\\sub\\c.txt", 7);
        write(base + "\\d1\\sub\\deep\\d.txt", 11);
        System.out.println("判据1 三层目录        → " + dirSize(base + "\\d1") + "   期望 26");

        // 判据 2：空目录（里面一个文件都没有）
        new File(base + "\\empty").mkdirs();
        System.out.println("判据2 空目录          → " + dirSize(base + "\\empty") + "   期望 0");

        // 判据 3：根本不存在的路径
        System.out.println("判据3 不存在的路径    → " + dirSize(base + "\\ghost") + "   期望 -1");

        // 判据 4：直接传一个普通文件
        System.out.println("判据4 一个 5 字节文件 → " + dirSize(base + "\\d1\\a.txt") + "   期望 5");
    }
}
