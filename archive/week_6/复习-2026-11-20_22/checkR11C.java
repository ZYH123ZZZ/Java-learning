// 复习 11C · File 返回值语义（待复习清单第 11 条加练三，B 档，11-21）
// 目标 20 分钟。闭卷。禁 Files.*、Files.walk、Stream。
// 这题跟 A 版（求和）、B 版（分类计数）是同一个知识点，但换第三种方法：
// 不累加、不计数，而是「从整棵树里挑出最大的那一个」—— 递归要把一个结果往上传。
import java.io.*;

public class checkR11C {

    // 【1】largest(String path) —— 返回这棵树下最大的普通文件的绝对路径
    //
    //     返回：最大那个文件的 getAbsolutePath()；树里一个普通文件都没有 → null
    //     路径不存在        → null
    //     path 本身是普通文件 → 返回它自己（哪怕它是 0 字节）
    //
    //     三条要小心：
    //       · 目录也有 length()，但它不是文件，不能当候选
    //       · 0 字节的普通文件是合法候选（它可能就是整棵树里最大的那个）
    //       · listFiles() 可能返回 null，别直接 for
    //
    //     教材：exists() :399   isFile() / isDirectory() :409   length() :408
    //           getAbsolutePath() :407   listFiles() :452，可能 null :462
    //           递归与返回值：第四周练习.md:688、:784
    //
    //     largest(下面那棵树)  → "...\\d1\\sub\\deep\\d.bin"（400 字节那个，在最深一层）
    //     largest(空目录)      → null
    //     largest(不存在的路径) → null
    static String largest(String path) {
        File f1 = new File(path);
        File max = null;
        String pathf;

        if (!f1.exists()) {
            return null;
        }

        if (f1.isFile()) {
            return f1.getAbsolutePath();
        }

        if (f1.isDirectory()) {
            File[] f2 = f1.listFiles();
            if (f2.length == 0) {//不是目录/不存在才是null
                return null;
            }

            for (File f : f2) {
                if (f.isFile()) {

                    if (max.length() < f.length() || max == null) {

                        max = f;
                    }
                        max = f;

                }
                if (f.isDirectory()) {
                    pathf = largest(f.getPath());//不知道咋写
                    if (pathf == null) {
                        return null;
                    }
                    File f3 = new File(pathf);
                    if (f3.length() > max.length()) {
                        max = f3;
                    }
                }
            }
        }
        // 你写
        if (max == null) {
            return null;
        }
        return max.getAbsolutePath();
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

    static String show(String p) {
        if (p == null) {
            return "null";
        }
        File f = new File(p);
        String flag = f.isAbsolute() ? "" : "   ← 不是绝对路径";
        return f.getName() + "  " + f.length() + " 字节" + flag;
    }

    public static void main(String[] args) throws IOException {
        String base = System.getProperty("java.io.tmpdir") + "r11ccheck";
        String d1 = base + "\\d1";
        new File(d1 + "\\sub\\deep").mkdirs();
        new File(base + "\\empty").mkdirs();
        write(d1 + "\\a.txt", 5);
        write(d1 + "\\big.bin", 100);
        write(d1 + "\\zero.log", 0);
        write(d1 + "\\sub\\c.dat", 7);
        write(d1 + "\\sub\\deep\\d.bin", 400);

        System.out.println("判据1 三层目录     → " + show(largest(d1)) + "   期望 d.bin 400 字节");
        System.out.println("判据2 空目录       → " + show(largest(base + "\\empty")) + "   期望 null");
        System.out.println("判据3 不存在的路径 → " + show(largest(base + "\\ghost")) + "   期望 null");
        System.out.println("判据4 0 字节文件本身 → " + show(largest(d1 + "\\zero.log")) + "   期望 zero.log 0 字节");
    }
}
