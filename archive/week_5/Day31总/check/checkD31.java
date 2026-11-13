import java.io.File;

public class checkD31 {
    public static void info(String path) {
        File f1 = new File(path);
        if (!f1.exists()) {
            System.out.println("没有找到 " + path);
            return;
        }

        System.out.println("名字 " + f1.getName());

        if (f1.isFile()) {
            System.out.println("是文件 ->" + f1.length());
        }

        if (f1.isDirectory()) {
            File[] f2 = f1.listFiles();
            System.out.println("是目录 子项：" + (f2 == null ? 0 : f2.length) + " 个");
            if (f2 != null) {
                for (File x : f2) {
                    System.out.println(x.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        info("C:\\Users\\Administrator\\Desktop\\test\\src");
        info("C:\\Users\\Administrator\\Desktop\\test\\src\\checkD31.java");
    }
}
