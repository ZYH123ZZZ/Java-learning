import java.util.*;

public class checkD38_C {

    // 你只写这个：一个参数、void、自己打印
    static void rank(List<String> words) {
//        List<String> word = (List<String>) Comparator.comparingInt(String::length).reversed();
        Collections.sort(words,Comparator.comparingInt(String::length).reversed());
        for (String x : words) {
            System.out.println(x + "(" + x.length() + ")");
        }
        int max = words.getFirst().length();
        int count = 0;
        String maxname = words.getFirst();
        for (String x : words) {
            if (max < x.length()) {
                max = x.length();
                maxname = x;
            }
            count += 1;
        }
        System.out.println("最长 " + maxname + " " + max + " 个字，共 " + count + " 个");
    }

    public static void main(String[] args) {
        System.out.println("--- c1 ---");
        rank(new ArrayList<>(List.of("pear", "apple", "fig", "banana", "kiwi")));
        System.out.println("--- c2 两个一样长 ---");
        rank(new ArrayList<>(List.of("dog", "cat", "bird")));
    }
}
