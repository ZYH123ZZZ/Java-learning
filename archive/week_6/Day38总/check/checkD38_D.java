import java.util.*;

public class checkD38_D {

    // 你只写这个：一个参数、void、自己打印
    static void board(List<String> words) {
        if (words.isEmpty()) {
            System.out.println("没有单词");
            return;
        }

        ArrayList<String> words1 = new ArrayList<>();
        for (String x : words) {
            if (!(words1.contains(x))) {
                words1.add(x);
            }
        }

        Collections.sort(words1, Comparator.comparingInt(String::length).reversed());//看check了

        int count = 0;
        for (String x : words1) {
            count++ ;
            System.out.println(count + ". " + x + "(" + x.length() + ")");
        }

        int countByte = 0;
        for (String x : words1) {
            countByte += x.length();
        }
        double aveCount = countByte / (double) count;
        System.out.printf("%s%d%s%.1f%s%n","共 ",count," 个,平均 ",aveCount," 个字");

        int maxLength = words1.getFirst().length();
        int countMax = 0;
        for (String x : words1) {
            if (maxLength < x.length()) {
                maxLength = x.length();
            }
        }
        for (String x : words1) {
            if (maxLength == x.length()) {
                countMax++;
            }
        }
        System.out.println("最长 " + maxLength + " 个字，有 " + countMax + " 个");
















    }

    public static void main(String[] args) {
        System.out.println("--- w1 ---");
        board(new ArrayList<>(List.of("pear", "banana", "apple", "pear", "fig", "banana")));
        System.out.println("--- w2 空表 ---");
        board(new ArrayList<>());
        System.out.println("--- w3 ---");
        board(new ArrayList<>(List.of("cat", "dog", "bird")));
        System.out.println("--- w4 全一样长 ---");
        board(new ArrayList<>(List.of("aa", "bb", "cc")));
    }
}
