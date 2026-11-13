import java.io.*;

public class checkD32_C {
    public static void method1(String[] paths, String outPath) {
        try (FileOutputStream out = new FileOutputStream(outPath)) {
            for (String x : paths) {
                try (FileInputStream in = new FileInputStream(x);){
                    byte[] buf = new byte[1024];
                    int n = in.read(buf);
                    while (n != -1) {
                        out.write(buf, 0, n);
                        n = in.read(buf);
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
