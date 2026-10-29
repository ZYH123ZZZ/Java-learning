import java.util.ArrayList;
import java.util.Scanner;

public class Day18A {
    public static int countWord(String[] word) {
        return word.length;
    }

    public static String tostringWord(String[] word) {
        String result = word[0];
        for (int i = 1; i < word.length; i++) {
                result = result + " / " + word[i];
        }
        return result;
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
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] word = sentence.split(" ");

        System.out.println(countWord(word));
        System.out.println(tostringWord(word));
        System.out.println(wordcountMax(word));
        System.out.println(countaWord(word));
    }
}
