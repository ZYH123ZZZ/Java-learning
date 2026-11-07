import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Day34 {
    public static void M1(String from, String to) {

        try (BufferedReader br1 = new BufferedReader(new InputStreamReader
                (new FileInputStream(from), StandardCharsets.UTF_8));
             BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter
                     (new FileOutputStream(to), StandardCharsets.UTF_8))) {

            String line;
            String[] arline;
            int wordNum = 0;
            String maxWL = "";
            HashMap<String, Integer> hm1 = new HashMap<>();
//            ArrayList<Integer> a1 = new ArrayList<>();

            while ((line = br1.readLine()) != null) {
                arline = line.toLowerCase().split(" +");//忘打空格了你个傻逼

                wordNum = wordNum + arline.length;

                for (String x3 : arline) {
                    if (maxWL.length() < x3.length()) {
                        maxWL = x3;
                    }
                }

                for (String x : arline) {
                    hm1.put(x, hm1.getOrDefault(x, 0) + 1);
                }
            }
//            for (String x4 : hm1.keySet()) {
//                a1.add(hm1.get(x4));
//            }

//            Collections.sort(a1);//思路不正确

//            for (int i = 0; i < hm1.size(); i++) {
//                a1s.add(String.valueOf(hm1.get(i)));//hashmap的get只能写key
//            }

            ArrayList<String> a1s = new ArrayList<>(hm1.keySet());//老毛病又犯了 直接把这个放在重建hm1之前了
            Collections.sort(a1s,(a,b) -> hm1.get(b) - hm1.get(a));
            bw1.write("=== 词频统计 ===");
            bw1.newLine();
            for (String x1 : a1s) {
                bw1.write(x1 + " " + hm1.get(x1) + " 次");
                bw1.newLine();
            }
//            for (int i = 0; i < hm1.size(); i++) {
//                bw1.write(a1.get(i) + " " + a1s.get(i) + " 次");
//            }

            bw1.write("=== 总计 ===");
            bw1.newLine();
            bw1.write("单词总数: " + wordNum);
            bw1.newLine();
            bw1.write("不同单词: " + hm1.size());
            bw1.newLine();
            bw1.write("最长单词: " + maxWL);
            bw1.newLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//    public static void M2() {
//
//    }
    public static void main(String[] args) {

    M1("data/archive.txt","data/report.txt");
    }
}
