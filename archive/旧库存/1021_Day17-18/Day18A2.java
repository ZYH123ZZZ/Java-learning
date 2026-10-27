import java.util.ArrayList;
import java.util.Scanner;

public class Day18A2 {
    public static int countWord(String[] word) {
        return word.length;
    }

    public static String wordcountMax(String[] word) {
        int max = word[0].length();
        int maxi = 0;
        for (int i = 0; i < word.length; i++) {
            if (max < word[i].length()) {
                max = word[i].length();
                maxi = i;
            }
        }
        return word[maxi];
    }

    public static int countaWord(String[] word) {
        int count = 0;
        for (int i = 0; i < word.length; i++) {
            if (word[i].contains("o")) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<String> wd = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String[] word = sc.nextLine().split(" ");

        System.out.println(countWord(word));

        for (int i = 0; i < word.length; i++) {
            wd.add(word[i]);                          //没写出来
        }

        boolean first = true;
        for (String x : word) {
            if (!first) {
                System.out.print(" / ");
            }
            first = false;
            System.out.print(x);
        }
        System.out.println();
        System.out.println(wordcountMax(word));
        System.out.println(countaWord(word));
    }
}
