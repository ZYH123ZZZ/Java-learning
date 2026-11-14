import java.io.IOException;
import java.io.*;

public class checkD31_F2 {
    public static void report(String path) {
         long countByte = 0;
         int countDir = 0;
         int countFile = 0;
         long maxByte = 0;
         String maxName = "无";
        File f1 = new File(path);
        if (!f1.exists()) {
            System.out.println("没有这个路径");
            return;
        }
        if (f1.isFile()) {
            System.out.println("是文件：" + f1.getName() + " " + f1.length() + " 字节");
            return;
        }
        if (f1.isDirectory()) {
            File[] f11 = f1.listFiles();
            if (f11 == null) {
                System.out.println("读不了");
                return;
            }
            for (File x : f11) {
                if (x.isFile()) {
//                    System.out.println("是文件：" + x.getName() + " " + x.length() + " 字节");
                    countFile++;
                    countByte = countByte + x.length();
                    if (maxByte < x.length()) {
                        maxByte = x.length();
                        maxName = x.getName();
                    }
                }
                if (x.isDirectory()) {
                    countDir++;
                }
            }
            System.out.println("子项 " + (countDir + countFile) + " 个(目录 " + countDir + "个，文件 " + countFile + " 个)");
            System.out.println("文件共 " + countByte + " 字节");
            if (countFile == 0) {
                System.out.println("最大的：无");
                return;
            }
            System.out.println("最大的: " + maxName + " " + maxByte +" 字节");
        }
    }
    public static void main(String[] args) throws IOException {
        prepare();
        report("data/f31");
        report("data/f31/nothing");
        report("data/f31/a.txt");
        report("data/f31/sub");
        report("data/f31/sub/second");
    }

    static void prepare() throws IOException {
        File d = new File("data/f31");
        d.mkdirs();
        put(new File(d, "a.txt"), 5);
        put(new File(d, "b.log"), 2);
        put(new File(d, "c.txt"), 8);
        File sub = new File(d, "sub");
        sub.mkdirs();
        put(new File(sub, "d.txt"), 3);
        new File("data/f31/sub/second").mkdirs();
    }

    static void put(File f, int n) throws IOException {
        try (FileOutputStream out = new FileOutputStream(f)) {
            for (int i = 0; i < n; i++) out.write('x');
        }
    }
}

