import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day20A {

    public static String[] cutSe(String sen) {
        return sen.split("");
    }

    public static String charOut(HashSet<String> word, String sen, ArrayList<Integer> num) {
        String[] c1 = cutSe(sen);
        int j = 0;
        ArrayList<String> pos = new ArrayList<>();
        for (String x : c1) {
            if (!word.contains(x)) {
                word.add(x);
                pos.add(x);
                num.add(j);
            }
            j++;
        }
        String result = new String();
        for (int i = 0; i < pos.size(); i++) {
            result = result + pos.get(i) + "@" + num.get(i);
            if (i != pos.size() - 1) {
                result = result + " / ";
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> word = new HashSet<>();
        ArrayList<Integer> num = new ArrayList<>();

        String sen = sc.nextLine();
        String charOut1 = charOut(word, sen, num);
        System.out.println(cutSe(sen).length);
        System.out.println(charOut1);
        System.out.println(word.size());
    }
}

