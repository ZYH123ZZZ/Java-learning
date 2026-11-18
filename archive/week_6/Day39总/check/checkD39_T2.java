import java.util.*;
import java.util.stream.*;

/**
 * 查漏训练 T2 · Day39 Stream（中档 · 13 题 · 10 个知识点）
 *
 * T1 的平行卷：知识点一模一样，数据和参数换了，隔一两天做这份。
 * 只填空方法体，方法名 / 参数 / main 一律别动。
 * 判法：只看打印出来的值对不对 —— Map 和 List 里元素的先后、空格、标点都不算错。
 */
public class checkD39_T2 {

    // 1 · distinct：把每个词换成长度，去重，打印
    //   期望：[5, 2, 6, 3, 4]
    static void q1(List<String> words) {
        System.out.println(words.stream()
                .map(String::length)
                .distinct()
                .collect(Collectors.toList()));
        // 你写
    }

    // 2 · skip + limit：先按长度从短到长排，跳过前 2 个，再取 3 个，打印
    //   期望：[kiwi, pear, plum]
    static void q2(List<String> words) {
        System.out.println(words.stream()
                .sorted((a, b) -> a.length() - b.length())
                .skip(2)
                .limit(3)
                .collect(Collectors.toList()));
        // 你写
    }

    // 3 · peek：只留长度 >= 5 的词，每留一个先打印一行 "过: 词"，最后打印收集结果
    //   期望：过: apple / 过: banana / 过: grape / 过: melon / [apple, banana, grape, melon]
    static void q3(List<String> words) {
        List<String> words1 = words.stream()
                .filter(x -> x.length() >= 5)
                .peek(x -> System.out.println("过: " + x))
                .collect(Collectors.toList());
        System.out.println(words1);
        // 你写
    }

    // 4 · map 和 peek 的区别：先 peek 把每个词的长度打印出来，再 map 成长度、收集、打印
    //   期望：先 9 行数字（5 2 6 3 5 4 4 4 5），最后一行 [5, 2, 6, 3, 5, 4, 4, 4, 5]
    static void q4(List<String> words) {
        List<Integer> words1 = words.stream()
                .peek(x -> System.out.println(x.length()))
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(words1);
        // 你写
    }

    // 5 · reduce：所有词的长度加起来，打印总和
    //   期望：38
    static void q5(List<String> words) {                                                       //reduce后面啥都不用写(轻度)
        System.out.println(words.stream()
                .map(String::length)
                .reduce(0, (a, b) -> a + b));
        // 你写
    }

    // 6 · joining 三个参数：取前 4 个词，用 "-" 连起来，外面套 < >
    //   期望：<apple-ox-banana-fig>
    static void q6(List<String> words) {
        System.out.println(words.stream()
                .limit(4)
                .collect(Collectors.joining("-", "<", ">")));
        // 你写
    }

    // 7 · partitioningBy：按"长度 >= 5"分成两组，直接打印这个 Map
    //   期望：false 那组 5 个 [ox, fig, kiwi, pear, plum]，true 那组 4 个 [apple, banana, grape, melon]
    static void q7(List<String> words) {
        System.out.println(words.stream()
                .collect(Collectors.partitioningBy(x -> x.length() >= 5)));
        // 你写
    }

    // 8 · forEach ①：把每个词换成长度，一个一个打印出来（每行一个数）
    //   期望：9 行，5 2 6 3 5 4 4 4 5
    static void q8(List<String> words) {
        words.stream()
                .map(String::length)
                .forEach(System.out::println);

        // 你写
    }

    // 9 · forEach ②：先打印一行 "共 N 个"，再把每个词单独打印一行
    //   期望：共 9 个，然后 apple / ox / banana / fig / grape / kiwi / pear / plum / melon 各一行
    static void q9(List<String> words) {
        System.out.println("共 " + words.stream()
                .count() + " 个");
        words.stream()
                .forEach(System.out::println);
        // 你写
    }

    // 10 · findFirst ①：按原来顺序，找第一个长度 >= 6 的词，把它打印出来
    //   期望：banana
    static void q10(List<String> words) {                                       //"findFirst"这个方法名字记成getFirst(轻度)
        System.out.println(words.stream()
                .filter(x -> x.length() >= 6)
                .findFirst()
                .get());
        // 你写
    }

    // 11 · findFirst ②：按字母序排完之后取第一个词，打印
    //   期望：apple
    static void q11(List<String> words) {
        System.out.println(words.stream()
                .sorted((a, b) -> a.compareTo(b))
                .findFirst()
                .get());
        // 你写
    }

    // 12 · groupingBy + counting ①：按长度分组，数每组的个数，打印这个 Map
    //   期望：{2=1, 3=1, 4=3, 5=3, 6=1}                                                                   //不会(非常严重)
    static void q12(List<String> words) {
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(String::length,Collectors.counting())));
        // 你写
    }

    // 13 · groupingBy + counting ②：只留长度 >= 4 的词，按"首字母"分组，数每组的个数，打印
    //   期望：6 个键（a / b / g / k / m 各 1，p 是 2）
    static void q13(List<String> words) {
        System.out.println(words.stream()
                .filter(x -> x.length() >= 4)
                .collect(Collectors.groupingBy(x -> x.substring(0, 1), Collectors.counting())));
        // 你写
    }

    public static void main(String[] args) {
        List<String> w = List.of("apple", "ox", "banana", "fig", "grape", "kiwi", "pear", "plum", "melon");

        System.out.println("--- 1 distinct ---");            q1(w);
        System.out.println("--- 2 skip+limit ---");          q2(w);
        System.out.println("--- 3 peek ---");                q3(w);
        System.out.println("--- 4 map 和 peek ---");         q4(w);
        System.out.println("--- 5 reduce ---");              q5(w);
        System.out.println("--- 6 joining ---");             q6(w);
        System.out.println("--- 7 partitioningBy ---");      q7(w);
        System.out.println("--- 8 forEach ① ---");           q8(w);
        System.out.println("--- 9 forEach ② ---");           q9(w);
        System.out.println("--- 10 findFirst ① ---");        q10(w);
        System.out.println("--- 11 findFirst ② ---");        q11(w);
        System.out.println("--- 12 groupingBy+counting ① ---"); q12(w);
        System.out.println("--- 13 groupingBy+counting ② ---"); q13(w);
    }
}
