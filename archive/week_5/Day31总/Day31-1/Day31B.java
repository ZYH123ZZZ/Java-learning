import java.io.File;

public class Day31B {
    public static void listDir(String pathText) {
        System.out.println("--- " + pathText + " ---");
        File n = new File(pathText);
        if (!n.exists()) {
            System.out.println("路径不存在");
            return;
        } else if (!n.isDirectory()) {
            System.out.println("不是目录");
            return;
        }
        File[] n1 = n.listFiles();
        if (n1 == null) {//copy
            System.out.println("目录打不开");
            return;
        }
        int File1 = 0;
        int Dire1 = 0;
        for (File x : n1) {
            System.out.print("名字: " + x.getName());
            if (x.isFile()) {
                System.out.print(" 类型: 文件");
                System.out.println(" 大小: " + x.length());
                File1++;
            } else if (x.isDirectory()){
                System.out.print(" 类型: 目录");
                System.out.println(" 大小: -");
                Dire1++;
            }
        }
        System.out.println("共 " + n1.length + " 项,其中文件 " + File1 + " 个,目录 " + Dire1 + " 个");
    }
    public static void main(String[] args) {
        listDir("C:/Users/Administrator/Desktop/test/src");
        listDir("C:/Users/Administrator/Desktop/test/nosuch");   // 不存在
        listDir("C:/Users/Administrator/Desktop/test/data");     // 空目录
        listDir("C:/Users/Administrator/Desktop/test");          // 根目录：里面是 src 和 data 两个子目录
        listDir("C:/Users/Administrator/Desktop/test/src/Day31B.java");  // 传文件：测"不是目录"
    }
}
