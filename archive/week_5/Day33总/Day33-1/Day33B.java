import java.io.*;
import java.nio.charset.StandardCharsets;

public class Day33B {
    public static void clean(String fromPath,String toPath) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader
                (new FileInputStream(fromPath), StandardCharsets.UTF_8));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
                     (new FileOutputStream(toPath),StandardCharsets.UTF_8))){
            String line;
            int n = 0;
            int emp = 0;
            int wri = 0;
            while ((line = br.readLine()) != null) {//这点不太熟练 看了Day33才写出来
                line = line.strip();
                n++;
                if (line.isEmpty()) {//continue不会用 trim查了才知道
                    emp++;
                    continue;
                }
                bw.write(line);
                bw.newLine();
//                System.out.println(n + "." + line + " -> " + " OK");
                wri++;
            }
            System.out.println("原文 " + n + " 行");
            System.out.println("清掉空行 " + emp + " 行");
            System.out.println("写出 " + wri + " 行");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
//                (new FileOutputStream(toPath),StandardCharsets.UTF_8))){
//            bw.write();
        }

    public static void main(String[] args) throws IOException {

            clean("data/dirty.txt", "data/clean.txt");

    }
    }

