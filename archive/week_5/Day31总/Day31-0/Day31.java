import java.io.File;
import java.io.IOException;

public class Day31 {
    public static void main(String[] args) throws IOException {
        File dir = new File("C:/Users/Administrator/Desktop/test/src");

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("文件夹非法或者文件夹为空");
            return;
        }
        if (files != null) {
            for (File x : files) {
                if (x.getName().endsWith(".java")) {
                    System.out.println(x.getName() + " " + x.length() + " 字节");
                }
            }
        }
        File data = new File("C:/Users/Administrator/Desktop/test/data");
        if (!data.exists()) {
            boolean ok = data.mkdir();
            System.out.println("创建文件夹" + ok);
        }
        File note = new File(data,"note.txt");
        if (!note.exists()) {
            boolean ok = note.createNewFile();
            System.out.println("创建文档" + ok);
        }
        System.out.println(note.getAbsolutePath());
        System.out.println(note.length());

        File a = new File("C:/Users/Administrator/Desktop/test/src");
        File[] a1 = a.listFiles();//文件夹如果无法打开会报错 需要if掉
        if (a1 == null) {
            System.out.println("文件夹错误");
            return;
        }
        int numj = 0;
        for (File x : a1) {
            if (x.getName().endsWith(".java")) {
                numj++;
            }
        }
        System.out.println(numj);
        if (note.exists()) {
            if (note.delete()) {
                System.out.println("note删除成功");
            } else {
                System.out.println("删除失败");
            }
        } else {
            System.out.println("没有找到note");
        }
    }
}
