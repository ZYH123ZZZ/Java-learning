import java.io.*;
import java.util.*;

public class checkD37_A {

    // 只有一个参数、void、自己打印
    static void scan(String dirPath) throws IOException {
        // 你写
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
        System.out.println("--- g1 data/d37 ---");
        prepare();
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
