import java.util.HashMap;
import java.util.Scanner;

public class Day19_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> seH = new HashMap<>();

        String ses = sc.nextLine();
        String[] seS = ses.split(" ");
//        for (int i = 0; i < seS.length; i++) {
//            seH.put(seS[i], i + 1);              //不知道是put 以为是add
//        }
        for (int i = 0; i < seS.length; i++) {
            seH.put(seS[i], seH.getOrDefault(seS[i], 0) + 1);   //这里0和1的位置弄反
        }
        for (String key : seH.keySet()) {           // 不会
            System.out.println(key + " " + seH.get(key));     //不知道咋输出
        }
    }
}