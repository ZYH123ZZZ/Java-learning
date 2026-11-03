import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day32 {
    public static void copy(String from, String to) throws IOException {
        try (FileInputStream in = new FileInputStream(from);
             FileOutputStream out = new FileOutputStream(to)) {
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) != -1) {
                out.write(buf, 0, n);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        FileOutputStream out = new FileOutputStream("data/out.bin");
        out.write(65);
        out.write(new byte[]{66, 67, 68});
        out.close();


        FileInputStream in = new FileInputStream("data/out.bin");
        int b;
        while ((b = in.read()) != -1) {
            System.out.println((char) b);
        }
        in.close();

        try (FileOutputStream out1 = new FileOutputStream("data/out1.bin",true)) {
            out1.write(65);
            out1.write(new byte[]{66, 67, 68});
        } catch (IOException e) {
            System.out.println("写失败了: " + e.getMessage());
        }

//        copy("测试文件夹/1","测试文件夹/2");
        copy("C:\\Users\\Administrator\\Desktop\\测试文件夹\\1\\乌托邦P - 反乌托邦.flac",
                "C:\\Users\\Administrator\\Desktop\\测试文件夹\\2\\乌托邦P - 反乌托邦.flac");
    }
}
