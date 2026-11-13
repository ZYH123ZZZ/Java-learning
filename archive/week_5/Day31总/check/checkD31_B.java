import java.io.File;

public class checkD31_B {
    public static int countFiles(String dirPath, String suffix) {
        int count = 0;
        File dir1 = new File(dirPath);
        if (!dir1.exists()) {
            return 0;
        }
        if (!dir1.isDirectory()) {
            if (dir1.getName().endsWith(suffix)) {
                return 1;
            }
            return 0;
        }
        File[] dir1A = dir1.listFiles();//
        if (dir1A == null) {//
            return 0;
        }
        for (int i = 0; i < dir1A.length; i++) {
            //我原先想在这里检测文件夹内是否还套有文件夹 用if然后写相同格式 但是我想到 如果一直套文件夹需要用多个if 于是我把if删掉想问问是否有更简便的方法检测
            if (dir1A[i].isDirectory()) {
                count = count + countFiles(dir1A[i].getAbsolutePath(), suffix);//
            }else if (dir1A[i].getName().endsWith(suffix)) {//
                System.out.println(dir1A[i].getAbsolutePath());
                count++;
                //写成int怎么每个匹配的文件打印一次？
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countFiles("C:\\Users\\Administrator\\Desktop\\test\\archive", ".java"));
    }
}
