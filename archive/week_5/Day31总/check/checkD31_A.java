import java.io.File;
import java.io.IOException;

public class checkD31_A {
    public static void makeAndclean(String base) throws IOException {
        File bs1 = new File(base);
        File lab1 = new File(base, "lab1");//这样会自动创建吗 如果不是 咋创建文件夹
        lab1.mkdirs();
        File a = new File(lab1, "a.txt");
        System.out.println("建文件 " + a.getName() + ": " + a.createNewFile() + " 路径: " + a.getAbsolutePath());
        File b = new File(lab1, "b.txt");
        System.out.println("建文件 " + b.getName() + ": " + b.createNewFile() + " 路径: " + b.getAbsolutePath());
        File c = new File(lab1, "c.txt");
        System.out.println("建文件 " + c.getName() + ": " + c.createNewFile() + " 路径: " + c.getAbsolutePath());
        System.out.println("删除 " + b.getName() + ": " + b.delete());
        if (b.exists()) {
            System.out.println("b.txt 还在");
        } else {
            System.out.println("b.txt 不在");
        }
        File[] ls = lab1.listFiles();
        System.out.println("lab1 现在 " + (ls == null ? 0 : ls.length) + " 项");
    }
    public static void main(String[] args) throws IOException {
        makeAndclean("C:\\Users\\Administrator\\Desktop\\test\\data");
    }
}
