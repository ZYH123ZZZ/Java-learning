import java.io.*;
import java.util.*;

public class checkD37_A {

    // 只有一个参数、void、自己打印
    static void scan(String dirPath) throws IOException {
        File dir1 = new File(dirPath);
        if (!(dir1.isDirectory())) {
            System.out.println("路径不对");
            return;
        }
        String[] dir1name = dir1.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (!name.endsWith(".txt")) {
                    return false;
                }
                return true;
            }
        });
        if (dir1name == null) {
            System.out.println("读不了");
            return;
        }
        int count = 0;
        for (String x : dir1name) {
            if (x.endsWith("txt")) {
                count++;
                continue;
            }
        }
        if (count == 0) {
            System.out.println("没有txt");
            return;
        }
        File[] dir1file = dir1.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (!name.endsWith("txt")) {
                    return false;
                }
                return true;
            }
        });
        Arrays.sort(dir1file, new Comparator<File>() {
            @Override
            public int compare(File a, File b) {
                if (a.length() == b.length()) {
                    return a.getName().compareTo(b.getName());
                }
                return (int) (b.length() - a.length());
            }
        });

        long countByte = 0;
        for (File x : dir1file) {
            countByte += x.length();
            System.out.println(x.getName() + " 字节数 " + x.length());
        }
        System.out.println("共 " + dir1file.length + " 个，共 " + countByte + " 字节");
    }



    static void put(String p, int n) throws IOException {
        try (FileOutputStream out = new FileOutputStream(p)) {
            for (int i = 0; i < n; i++) out.write('x');
        }
    }

    static void prepare() throws IOException {
        new File("data/d37/sub").mkdirs();
        put("data/d37/a.txt", 5);
        put("data/d37/longname.txt", 3);
        put("data/d37/b.log", 2);
        put("data/d37/c.txt", 0);
    }

    public static void main(String[] args) throws IOException {
        prepare();
        System.out.println("--- g1 data/d37 ---");
        scan("data/d37");
        System.out.println("--- g2 不存在 ---");
        scan("data/d37/nothing");
        System.out.println("--- g3 是文件 ---");
        scan("data/d37/a.txt");
        System.out.println("--- g4 空目录 ---");
        scan("data/d37/sub");
        System.out.println("--- g5 加了 d.txt(7) 之后重扫 ---");
        put("data/d37/d.txt", 7);
        scan("data/d37");
    }
}
