// 复习 9 · 递归跨层状态（待复习清单第 9 条，C 档，11-20）
// 目标 20 分钟。闭卷。禁用：类级 static 集合（这题就是考跨层怎么传）。
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class checkR9 {

    // 【1】find(String path, String keyWord) —— 递归扫这个路径底下所有层
    //     把「文件名含 keyWord」的文件的【绝对路径】收集起来，返回 List<String>
    //     path 可能是目录，也可能就是一个文件
    //     path 不存在、或目录进不去 → 返回空 List，不许抛异常
    //     结果只能靠返回值往上传，不许用类级 static 集合攒
    //     教材：递归 E:\dsh\java\第四周练习.md:688（出口 :721）
    //           listFiles() 第五周练习.md:452（返回 null 要先判 :462）
    //           getAbsolutePath() 第五周练习.md:407
    //
    //     find("...\r9check", "java") → 3 条，三条都是 .java 的绝对路径
    //     find("...\r9check\a.txt", "java") → 0 条
    static List<String> find(String path, String keyWord) {
        List<String> abp = new ArrayList<>();
        File f1 = new File(path);
        if (f1.isFile()) {
            if (f1.getName().contains(keyWord)) {
                abp.add(f1.getAbsolutePath());
            }
        }

        if (f1.isDirectory()) {
            File[] f2 = f1.listFiles();
            if (f2 == null) {
                return abp;
            }
            for (File x : f2) {
                List<String> child = find(x.getPath(), keyWord);
                for (String s : child) {
                    abp.add(s);
                }
            }
        }
        // 你写（下面这行是占位，写完删掉）
        return abp;
    }

    public static void main(String[] args) throws Exception {
        // ── 造测试树，放系统临时目录，不碰你的 data ──
        File root = new File(System.getProperty("java.io.tmpdir"), "r9check");
        File sub = new File(root, "sub");
        File deep = new File(sub, "deep");
        File kwDir = new File(root, "java目录");
        deep.mkdirs();
        kwDir.mkdirs();

        File java1 = new File(root, "java1.java");
        File txt = new File(root, "a.txt");
        File bJava = new File(sub, "b.java");
        File java2 = new File(deep, "java2.java");
        new FileOutputStream(java1).close();
        new FileOutputStream(txt).close();
        new FileOutputStream(bJava).close();
        new FileOutputStream(java2).close();

        // 判据 1：目录进 → 条数 = 树里文件名含 java 的文件数，都是绝对路径
        List<String> r1 = find(root.getAbsolutePath(), "java");
        System.out.println("判据1 目录: " + (r1 == null ? "null" : r1.size() + " 条"));
        if (r1 != null) {
            for (String s : r1) {
                System.out.println("        " + s + "   存在=" + new File(s).exists()
                        + "  是绝对路径=" + new File(s).isAbsolute());
            }
        }

        // 判据 2：传单个文件 → 文件名含关键词给 1 条，不含给 0 条
        List<String> r2 = find(java2.getAbsolutePath(), "java");
        List<String> r3 = find(txt.getAbsolutePath(), "java");
        System.out.println("判据2 单个 java2.java: " + (r2 == null ? "null" : r2.size() + " 条"));
        System.out.println("判据2 单个 a.txt: " + (r3 == null ? "null" : r3.size() + " 条"));

        // 判据 3：连调两次，第二次换空目录 → 第二次必须 0 条，不许带上次的残留
        File empty = new File(System.getProperty("java.io.tmpdir"), "r9check_empty");
        empty.mkdirs();
        find(root.getAbsolutePath(), "java");
        List<String> r4 = find(empty.getAbsolutePath(), "java");
        System.out.println("判据3 第二次(空目录): " + (r4 == null ? "null" : r4.size() + " 条") + "   必须 0");
    }
}
