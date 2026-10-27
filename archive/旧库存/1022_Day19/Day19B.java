import java.util.HashMap;
import java.util.Scanner;

public class Day19B {
    public static String[] cutSentence(String sentence) {
        return sentence.split(" ");
    }

    public static String wordMax(HashMap<String, Integer> wordHash, String sentence) {
        String[] word = cutSentence(sentence);
        for (int i = 0; i < cutSentence(sentence).length; i++) {
            wordHash.put(word[i], wordHash.getOrDefault(word[i], 0) + 1);
        }
        int max = wordHash.get(word[0]);
        String best = word[0];
        for (String key : wordHash.keySet()) {
            if (wordHash.get(key) > max) {
                max = wordHash.get(key);
                best = key;
            }
        }
        return best;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();

        HashMap<String, Integer> wordHash = new HashMap<>();
        String max = wordMax(wordHash, sentence);

        System.out.println(max + " " + wordHash.get(max));
    }

}
