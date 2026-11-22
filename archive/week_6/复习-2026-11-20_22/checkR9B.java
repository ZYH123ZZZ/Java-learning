// 复习 9-B · 递归跨层状态（同知识点换骨架：这次是求和，不是收集）
// 目标 20 分钟。闭卷。禁用：类级 static 变量（这题就是考跨层怎么传）。
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;

public class checkR9B {

    // 【1】totalSize(String path) —— 递归算这棵树里所有文件加起来一共多少字节
    //     传目录：它底下所有层、所有文件的 length() 加起来（目录自己不算）
    //     传文件：就它自己那么多字节
    //     路径不存在 / 目录进不去 / 空目录 → 返回 0，不许抛异常
    //     结果只能靠返回值往上带，不许用类级 static 累加
    //     教材：递归 E:\dsh\java\第四周练习.md:688（出口 :721）
    //           listFiles() 第五周练习.md:452（返回 null 要先判 :462）
    //           File.length() 第五周练习.md:456（★对目录无效，不能拿目录的 length() 当总和）
    //
    //     totalSize("...\r9size") → 26
    //     totalSize("...\r9size\a.txt") → 3
    static long totalSize(String path) {
        long countByte = 0;

        File f1 = new File(path);
        if (f1.isFile()) {
            countByte += f1.length();
        }

        if (f1.isDirectory()) {
            File[] f2 = f1.listFiles();

            for (File x : f2) {
                long childc = totalSize(x.getPath());
                countByte += childc;
            }
        }
        // 你写（下面这行是占位，写完删掉）
        return countByte;
    }

    public static void main(String[] args) throws Exception {
        // ── 造测试树，放系统临时目录，不碰你的 data ──
        File root = new File(System.getProperty("java.io.tmpdir"), "r9size");
        File sub = new File(root, "sub");
        File deep = new File(sub, "deep");
        File emptyDir = new File(root, "空目录");
        deep.mkdirs();
        emptyDir.mkdirs();

        File java1 = new File(root, "java1.java");
        File txt = new File(root, "a.txt");
        File bJava = new File(sub, "b.java");
        File java2 = new File(deep, "java2.java");

        File[] fs = {java1, txt, bJava, java2};
        String[] data = {"aaaaa", "bbb", "bbbbbbb", "bbbbbbbbbbb"};   // 5 + 3 + 7 + 11 = 26
        for (int i = 0; i < fs.length; i++) {
            FileOutputStream out = new FileOutputStream(fs[i]);
            out.write(data[i].getBytes());
            out.close();
        }

        // 判据 1：传目录 → 底下所有层、所有文件的字节数之和
        System.out.println("判据1 目录总计: " + totalSize(root.getAbsolutePath()) + "   期望 26");

        // 判据 2：传单个文件 → 就它自己那么多
        System.out.println("判据2 单个 java2.java: " + totalSize(java2.getAbsolutePath()) + "   期望 11");
        System.out.println("判据2 单个 a.txt: " + totalSize(txt.getAbsolutePath()) + "   期望 3");

        // 判据 3：边界 → 空目录、不存在的路径，都是 0 且不抛异常
        System.out.println("判据3 空目录: " + totalSize(emptyDir.getAbsolutePath()) + "   期望 0");
        System.out.println("判据3 不存在的路径: " + totalSize("Z:\\nope\\nothing") + "   期望 0");

        // 判据 4：连调两次，第二次换空目录 → 第二次必须 0，不许带上次的残留
        totalSize(root.getAbsolutePath());
        System.out.println("判据4 第二次(空目录): " + totalSize(emptyDir.getAbsolutePath()) + "   必须 0");
    }
}
