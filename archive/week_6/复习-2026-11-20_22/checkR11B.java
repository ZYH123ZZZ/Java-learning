// 复习 11B · File 返回值语义（待复习清单第 11 条加练，B 档，11-21）
// 目标 20 分钟。闭卷。禁 Files.*、Files.walk。
// 这题跟 A 版同一个知识点，但换了一个方法：不是求和，是「按身份分类计数」。
import java.io.*;

public class checkR11B {

    // 【1】census(String path) —— 数一数这棵树下有多少个普通文件、多少个目录、多少个 0 字节文件
    //
    //     返回一个长度 3 的 int[]，含义固定：
    //         [0] = 普通文件个数
    //         [1] = 目录个数（**不含 path 自己**，只数它下面的）
    //         [2] = 其中 0 字节的普通文件个数
    //
    //     路径不存在        → 返回 {-1, -1, -1}
    //     路径是一个普通文件 → 返回 {1, 0, (它自己是不是 0 字节 ? 1 : 0)}
    //     路径是一个目录    → 递归统计它下面所有层
    //
    //     教材：exists() :399   isFile() / isDirectory() :409
    //           length() :408（对目录没意义）   listFiles() :452，可能 null :462
    //
    //     census(下面那种三层目录) → [4, 3, 1]
    //     census(空目录)           → [0, 0, 0]
    //     census(不存在的路径)     → [-1, -1, -1]
    static int[] census(String path) {
        int[] n = new int[3];
        File f1 = new File(path);
        if (!f1.exists()) {
            return new int[]{-1, -1, -1};
        }

        if (f1.isFile()) {
            n[0] = 1;
            n[1] = 0;
            if (f1.length() == 0) {
                n[2] = 1;
            } else {
                n[2] = 0;
            }
        }

        if (f1.isDirectory()) {
            File[] f2 = f1.listFiles();
            //为什么把n[1] = 1放到这里不行
            for (File f : f2) {
                if (f.isFile()) {//递归里面慎重赋值 会覆盖
                    n[0]++;
                    if (f.length() == 0) {
                        n[2]++;
                    }
                }

                if (f.isDirectory()) {
                    n[1]++;
                    n[1] += census(f.getPath())[1];
                    n[0] += census(f.getPath())[0];
                    n[2] += census(f.getPath())[2];
                }
            }
        }
        return n;
        // 你写
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

    static String show(int[] r) {
        if (r == null) {
            return "null（返回了 null，判据按挂处理）";
        }
        if (r.length != 3) {
            return "长度是 " + r.length + "，不是 3";
        }
        return "文件 " + r[0] + " / 目录 " + r[1] + " / 空文件 " + r[2];
    }

    public static void main(String[] args) throws IOException {
        String base = System.getProperty("java.io.tmpdir") + "r11bcheck";
        new File(base).mkdirs();

        // 判据 1：4 个文件（5、0、7、11 字节）+ 3 个目录（sub、deep、emptyDir）
        new File(base + "\\d1\\sub\\deep").mkdirs();
        new File(base + "\\d1\\emptyDir").mkdirs();
        write(base + "\\d1\\a.txt", 5);
        write(base + "\\d1\\zero.txt", 0);
        write(base + "\\d1\\sub\\c.txt", 7);
        write(base + "\\d1\\sub\\deep\\d.txt", 11);
        System.out.println("判据1 三层目录     → " + show(census(base + "\\d1")) + "   期望 文件 4 / 目录 3 / 空文件 1");

        // 判据 2：空目录
        new File(base + "\\empty").mkdirs();
        System.out.println("判据2 空目录       → " + show(census(base + "\\empty")) + "   期望 文件 0 / 目录 0 / 空文件 0");

        // 判据 3：不存在的路径
        System.out.println("判据3 不存在的路径 → " + show(census(base + "\\ghost")) + "   期望 -1 / -1 / -1");

        // 判据 4：直接传一个 5 字节的普通文件
        System.out.println("判据4 单个 5 字节文件 → " + show(census(base + "\\d1\\a.txt")) + "   期望 文件 1 / 目录 0 / 空文件 0");
    }
}
