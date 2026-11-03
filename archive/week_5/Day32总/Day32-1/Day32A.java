import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day32A {
    public static void backup(String fromDir,String toDir,String suffix)throws IOException {
        System.out.println("--- 备份 " + fromDir + " -> " + toDir + " ---");
        File fromDir1 = new File(fromDir);
        File toDir1 = new File(toDir);
        if (!toDir1.exists()) {//看了Day31才写出来
            boolean ok = toDir1.mkdir();
            if (ok) {
                System.out.println("没有找到文件夹 已重新创建文件夹");
            } else {
                System.out.println("没有找到文件夹 创建失败");
            }
        }

        File[] fromDir2 = fromDir1.listFiles();//看Day31才写出来
        int falsenum = 0;
        int falsenamenum = 0;
        int Filenum = 0;
        long bytesum = 0;
        for (File x : fromDir2) {
            if (x.isFile() && x.getName().endsWith(suffix)) {//看了File速查才写出来

                try (FileInputStream in = new FileInputStream(x);//只能打开文件 不能打开文件夹 in out都是
                     FileOutputStream out = new FileOutputStream(new File(toDir, x.getName()))) {//看了Day32java才写出来
                    byte[] buf = new byte[2048];
                    int n;
                    while ((n = in.read(buf)) != -1) {
                        out.write(buf, 0, n);//复制文件是看day32相当于抄的 还是不熟悉 没背会
                    }
                    Filenum++;//因为while是分为好几块读取的 所以计数器不能放while里面
                    bytesum = bytesum + x.length();//放while里面容易造成多余计数
                }

            } else if (x.isDirectory()) {
                falsenum++;
            } else if (!x.getName().endsWith(suffix)) {
                falsenamenum++;
            }
            System.out.print(x.getName() + " " + x.length() + " 字节 -> " + new File(toDir,x.getName()).length() + " 字节");
            if (new File(toDir, x.getName()).exists()) {//思路是抄的
                System.out.println(" OK");
            } else {
                System.out.println(" False");
            }
        }
        System.out.println("跳过 " + (falsenum + falsenamenum) + " 项" + "(子目录 " + falsenum + " 个,后缀不符 " + falsenamenum + " 个)");
        //falsenum + falsenamenum这样会把两个数拼到一起 所以要带括号 以后能带括号都带 防止不必要的错误
        System.out.println("完成: 共 " + Filenum + " 个文件, " + bytesum + " 字节");
    }

    public static void main(String[] args) {
        try {
            backup("data/test_in", "data/backup", ".txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
