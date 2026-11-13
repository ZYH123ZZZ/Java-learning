import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class checkD32 {
    public static void copy(String from, String to) {
        try (FileInputStream in = new FileInputStream(from);
             FileOutputStream out = new FileOutputStream(to)) {
            byte[] buf = new byte[1024];
            int n = in.read(buf);
            while (n != -1) {
                out.write(buf, 0, n);
                n = in.read(buf);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
