import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Day19 {
    public static String[] allWords(String sentence) {
        return sentence.split(" ");            //不知道可以直接赋值 不用使用循环一个一个替换
    }

    public static HashMap<String,Integer> countWord(HashMap<String, Integer> sentenceHash,
    String sentence) {
        String[] word = allWords(sentence);
        for (int i = 0; i < word.length; i++) {
            sentenceHash.put(word[i],
                    sentenceHash.getOrDefault(word[i], 0) + 1);  //不太熟悉
        }
        return sentenceHash;
    }

//    public static String[] arrCW(HashMap<String, Integer> sentenceHash, String sentence) {
//        ArrayList<Integer> arr = new ArrayList<>(countWord(sentenceHash,sentence).values());
//        Collections.sort(arr);
//
//    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();
        HashMap<String, Integer> sentenceHash = new HashMap<>();

        countWord(sentenceHash, sentence);
        for (String key : sentenceHash.keySet()) {
            System.out.println(key + " " + sentenceHash.get(key));  // 这里不熟悉
        }
    }
}
