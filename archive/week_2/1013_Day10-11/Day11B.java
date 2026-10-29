import java.util.Scanner;

public class Day11B {
    public static int countString(String sentence, String word) {

        String s = sentence.toLowerCase();
        String w = word.toLowerCase();
        int count = 0;
        int pos = s.indexOf(w);

        while (pos != -1) {
            count++;
            pos = s.indexOf(w, pos + 1);
        }
        return count;
    }

    public static int findFirst(String sentence, String word) {
        return sentence.indexOf(word);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一句话：");
        String sentence = sc.nextLine();
        sentence = sentence.toLowerCase();

        System.out.println("要查什么：");
        String word = sc.nextLine();
        word = word.toLowerCase();

        System.out.println("出现次数： " + countString(sentence, word));
        System.out.println("第一次出现在： " + (findFirst(sentence, word) + 1));

    }
}
