import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day21 {
    public static String[] senS(String sen) {
        return sen.split(" ");
    }

    public static ArrayList<String> senA(String sen) {
        ArrayList<String> senA2 = new ArrayList<>();
        for (String x : senS(sen)) {
            if (!senA2.contains(x)) {
                senA2.add(x);
            }
        }
        return senA2;
    }

    public static int countWord(String sen) {
        return senS(sen).length;
    }

    public static int countnewWord(HashSet<String> senHS,String sen) {
        for (String x : senS(sen)) {
            senHS.add(x);
        }
        return senHS.size();
    }

    public static HashMap<String, Integer> numWord(HashMap<String, Integer> senHM, String sen) {
        String[] S = senS(sen);
        for (String s : S) {
            senHM.put(s, senHM.getOrDefault(s, 0) + 1);
        }
        return senHM;
    }

    public static int maxWord(HashMap<String, Integer> senHM, String sen) {
        int max = 0;
        for (String s : senA(sen)) {
            if (max < senHM.get(s)) {
                max = senHM.get(s);
            }
        }
        return max;
    }

    public static String maxWordS(HashMap<String, Integer> senHM, String sen) {
        int max = 0;
        String max1 = "";
        for (String s : senA(sen)) {
            if (max < senHM.get(s)) {
                max = senHM.get(s);
                max1 = s;
            }
        }
        return max1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sen = sc.nextLine();
        HashSet<String> senHS = new HashSet<>();
        HashMap<String, Integer> senHM = new HashMap<>();
        numWord(senHM, sen);           //必须要有这个
        ArrayList<String> senAa = senA(sen);
        int countNewWord = countnewWord(senHS, sen);

        System.out.println(countWord(sen));
        System.out.println(countNewWord);
        int max1 = maxWord(senHM, sen);
        String max2 = maxWordS(senHM, sen);
        for (int i = 0; i < countNewWord; i++) {
            System.out.println(senAa.get(i) + " : " + senHM.get(senAa.get(i)));  //senHM wrong(已解决)
        }
        System.out.println(max2 + " : " + max1);
    }
}
