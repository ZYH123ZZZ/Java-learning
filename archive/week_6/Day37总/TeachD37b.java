import java.io.*;
import java.util.Arrays;

public class TeachD37b {

    static void put(String p, int n) throws IOException {
        try (FileOutputStream out = new FileOutputStream(p)) {
            for (int i = 0; i < n; i++) out.write('x');
        }
    }

    public static void main(String[] args) throws IOException {
        new File("data/d37b").mkdirs();
        put("data/d37b/a.txt", 5);
        put("data/d37b/longname.txt", 3);
        put("data/d37b/b.log", 2);
        put("data/d37b/c.txt", 0);

        File d = new File("data/d37b");

        // ① 不带过滤器：目录里有什么名字全给你
        System.out.println("① list() 不过滤   " + Arrays.toString(d.list()));

        // ② 过滤器：.txt 留下，别的丢掉
        String[] onlyTxt = d.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        System.out.println("② 只要 .txt       " + Arrays.toString(onlyTxt));

        // ③ 同一个接口，换一个条件：名字长于 5
        String[] longName = d.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.length() > 5;
            }
        });
        System.out.println("③ 名字长于 5      " + Arrays.toString(longName));
    }
}
