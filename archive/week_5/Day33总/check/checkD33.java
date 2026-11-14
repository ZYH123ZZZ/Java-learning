import java.io.*;
import java.nio.charset.StandardCharsets;

public class checkD33 {
    public static int countLines(String path) {
        File test = new File(path);
        if (!test.exists()) {
            throw new RuntimeException("文件不存在");
        }
        int countLinesinMethod = 0;
        try (BufferedReader bfr1 = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {//wrong
            String line;//wrong
            while ((line = bfr1.readLine()) != null) {//new wrong
                    countLinesinMethod++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countLinesinMethod;
    }

    public static void appendLine(String path, String s) {
        File f = new File(path);
        try (BufferedWriter bfw1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path,true), StandardCharsets.UTF_8))) {
            if (f.length() > 0 && !endsWithNewLine(f)) {
                bfw1.newLine();//new wrong
            }
            bfw1.write(s);
            bfw1.newLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean endsWithNewLine(File f) {
        try (FileInputStream fin1 = new FileInputStream(f);) {
//            byte[] buf = new byte[(int) f.length()];
//            while (fin1.read(buf) != -1) {
//            }
//            return buf[buf.length - 1] == '\n';
            byte[] buf = new byte[1024];
            int n;
            byte last = 0;
            while ((n = fin1.read(buf)) != -1) {//wrong
                last = buf[n - 1];
            }
            return last == '\n';
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
