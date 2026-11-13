import java.io.File;

public class checkD31_D {
    static int dirCount = 0;
    static int fileCount = 0;
    static long byteCount = 0;
    public static void printAllFiles(String path, int depth) {
        File f1 = new File(path);
        String pad = "";
        for (int k = 0; k < depth; k++) {
            pad += "  ";
        }
        if (!f1.exists()) {
            System.out.println("路径下面没有文件");
            return;
        }
        if (f1.isFile()) {
            System.out.println(pad + f1.getName() + " (" + f1.length() + " 字节)");
            fileCount++;
            byteCount += f1.length();
            return;
        }
        if (f1.isDirectory()) {
            if (depth == 0) {
                System.out.println(f1.getName());
            } else {
                System.out.println(pad + f1.getName() + "/");//第一个总目录不知道怎么单独去打 因为有递归
                dirCount++;
            }
            File[] dr1 = f1.listFiles();
            for (File x : dr1) {
                printAllFiles(x.getAbsolutePath(), depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        printAllFiles("C:\\Users\\Administrator\\Desktop\\test\\archive\\week_4\\Day26总", 0);
        System.out.println("  共 " + dirCount + " 个目录, " + fileCount + " 个文件, 合计 " + byteCount + " 字节");
    }
}
