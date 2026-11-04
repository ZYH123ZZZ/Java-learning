import java.io.*;
import java.nio.charset.StandardCharsets;

public class Day33 {
    public static void main(String[] args) {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(
//                new FileInputStream("data/cn.txt"), StandardCharsets.UTF_8))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            System.out.println("读取失败 " + e.getMessage());
//        }
//
//        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
//                (new FileOutputStream("data/out.txt"), StandardCharsets.UTF_8))) {
//            bw.write("第一行");
//            bw.newLine();
//            bw.write("第二行");
//        } catch (IOException e) {
//            System.out.println("写入失败 " + e.getMessage());
//        }
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream("data/cn.txt"), StandardCharsets.UTF_8))) {
            bw.write("我真的特别爱你 ");
            bw.newLine();
            bw.write("为什么你会落泪");
            bw.newLine();
            bw.write("呵呵呵呵呵呵呵");
            bw.newLine();
            System.out.println("写入成功");
        } catch (IOException e) {
            System.out.println("写入失败 " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader
                (new FileInputStream("data/cn.txt"), StandardCharsets.UTF_8))){
            String line;
            int n = 1;
            while ((line = br.readLine()) != null) {//这个还是看了上面才会写
                System.out.println(n + "." + line);
                n++;
            }
        } catch (IOException e) {
            System.out.println("读取失败 " + e.getMessage());
        }

        try (FileInputStream f = new FileInputStream("data/cn.txt")) {
//            byte[] b = new byte[1024];//复制才能多字符读取 输出不能
            int n;
            while ((n = f.read()) != -1) {//看了Day32才补上f.read括号里面的b 错误！！！
                System.out.print((char) n);
            }
        } catch (Exception e) {
            System.out.println("读取失败 " + e.getMessage());
        }
    }
}
