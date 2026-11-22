// 复习 11D · File 返回值语义（待复习清单第 11 条，B 档，11-22）
// 目标 25 分钟。闭卷。禁用：Files.*、Files.walk、Stream（这题就是考手写递归）。
//
// 出这题的原因（检查 R11C 时暴露的四件事）：
//   1. 「还没有候选人」和「候选人是 0」要分开 —— max 不能拿目录自己去当起点
//   2. 「收下第一个」和「跟它比」是二选一，不是先后两句
//   3. 一个空子目录不能把整棵树的结果作废
//   4. 目录也有 length()，那个 0 没意义（教材 第五周练习.md:408、:409）
// 这题要同时维护「最小」和「最大」两个状态，上面四条一条都躲不掉。

import java.io.*;

public class checkR11D {

    // 【1】extremes(String path) —— 返回 { 最小文件的绝对路径, 最大文件的绝对路径 }
    //
    //     规则：
    //       · 只看普通文件，目录不参与（目录的 length() 恒为 0，没意义）//
    //       · path 不存在                    → 返回 null（整个数组是 null）//
    //       · path 存在但树里一个普通文件都没有 → 返回 { null, null }//
    //       · 两个文件一样大 → 最小/最大各取其中一个都算对（不考遍历顺序）
    //       · path 本身就是一个文件          → 返回 { 它自己, 它自己 }//
    //
    //     教材：exists :399、isFile/isDirectory :409、length :408、
    //           listFiles :452、listFiles 返回 null 的两种情况 :462
    //
    //     extremes(三层目录) → { "...\\zero.log", "...\\d.bin" }   0 字节 / 400 字节
    //     extremes(空目录)   → { null, null }
    //     extremes(不存在)   → null
    static String[] extremes(String path) {
        File f1 = new File(path);
        File max = null;//还是不会定义
        File min = null;
        if (!f1.exists()) {
            return null;
        }

        //这里看旧文件了
        if (f1.isFile()) {
            return new String[]{f1.getAbsolutePath(), f1.getAbsolutePath()};
        }

        if (f1.isDirectory()) {
            File[] f2 = f1.listFiles();
            if (f2 == null) {//这里不会把空目录拦下来吗
                return new String[]{null, null};
            }
            for (File f : f2) {
                if (f.isFile()) {
                    if (max == null || max.length() < f.length()) {
                        max = f;
                    }
                    if (min == null || min.length() > f.length()) {
                        min = f;
                    }
                }
                if (f.isDirectory()) {
                    String[] path2 = extremes(f.getPath());
                    if (path2[0] == null && path2[1] == null) {
                        continue;
                    }
                    if (max == null || max.length() < new File(path2[1]).length()) {
                        max = new File(path2[1]);
                    }
                    if (min == null || min.length() > new File(path2[0]).length()) {
                        min = new File(path2[0]);
                    }
                }
            }

        }
        // 你写
        if (min != null && max != null) {//这里是防谁？
            return new String[]{min.getAbsolutePath(), max.getAbsolutePath()};
        }
        return new String[]{null, null};
    }

    public static void main(String[] args) throws IOException {
        String base = System.getProperty("java.io.tmpdir") + "r11d";
        String d1 = base + "\\d1";
        new File(d1 + "\\sub\\deep").mkdirs();
        new File(base + "\\empty").mkdirs();
        write(d1 + "\\a.txt", 5);
        write(d1 + "\\big.bin", 100);
        write(d1 + "\\zero.log", 0);
        write(d1 + "\\sub\\c.dat", 7);
        write(d1 + "\\sub\\deep\\d.bin", 400);

        show("判据1 三层目录", extremes(d1), "zero.log 0 字节 / d.bin 400 字节");
        show("判据2 空目录", extremes(base + "\\empty"), "null / null");
        String[] r3 = extremes(base + "\\nope");
        System.out.println("判据3 不存在的路径 → " + (r3 == null ? "null" : "不是 null！")
                + "   期望 null");
        show("判据4 传一个文件本身", extremes(d1 + "\\a.txt"), "a.txt / a.txt");
    }

    static void show(String tag, String[] r, String want) {
        if (r == null) {
            System.out.println(tag + " → null   期望 " + want);
            return;
        }
        System.out.println(tag + " → [" + describe(r[0]) + ", " + describe(r[1]) + "]   期望 " + want);
    }

    static String describe(String p) {
        if (p == null) {
            return "null";
        }
        File f = new File(p);
        return f.getName() + " " + f.length() + " 字节"
                + (f.isFile() ? "" : "（不是普通文件！）");
    }

    // ---- 下面是脚手架，不用改 ----

    static void write(String path, int bytes) throws IOException {
        byte[] data = new byte[bytes];
        for (int i = 0; i < bytes; i++) {
            data[i] = (byte) 'a';
        }
        try (FileOutputStream out = new FileOutputStream(path)) {
            out.write(data);
        }
    }
}
