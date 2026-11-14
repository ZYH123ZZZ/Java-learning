import java.io.*;
import java.nio.charset.StandardCharsets;

public class checkD33_B {
    static void put(String p, String content) {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(p))) {
            if (!content.isEmpty()) {
                String[] ls = content.split("\n", -1);
                for (String l : ls) { w.write(l); w.newLine(); }
            }
        } catch (IOException e) { throw new RuntimeException(e); }
    }

    static void prepare() {
        new File("data/b33").mkdirs();
        put("data/b33/src.txt", "复习Day33\n写copy方法\n整理笔记\n读第五周总结\n早睡");
        put("data/b33/empty.txt", "");
        put("data/b33/out2.txt", "旧的1\n旧的2\n旧的3");
        put("data/b33/out5.txt", "旧的1\n旧的2\n旧的3");
    }
    public static void annotate(String from, String to) {
        int count = 0;
        int countLine = 0;
        File fromF = new File(from);
        File toF = new File(to);
        if (!fromF.exists()) {
            System.out.println("源文件不存在");
            return;
        }
        if (fromF.isDirectory()) {
            System.out.println("源是个目录");
            return;
        }
        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(from), StandardCharsets.UTF_8));
             BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(to), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br1.readLine()) != null) {
                countLine++;
                bw1.write(countLine + ". " + line);
                bw1.newLine();
                count++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("共 " + count + " 行");
    }
    public static void main(String[] args) throws IOException {
        prepare();
        annotate("data/b33/src.txt",     "data/b33/out1.txt");   // 组1
        annotate("data/b33/src.txt",     "data/b33/out2.txt");   // 组2
        annotate("data/b33/nothing.txt", "data/b33/out3.txt");   // 组3
        annotate("data/b33",             "data/b33/out4.txt");   // 组4
        annotate("data/b33/empty.txt",   "data/b33/out5.txt");   // 组5
    }
}
