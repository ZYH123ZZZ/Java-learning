import java.awt.print.Book;
import java.util.*;
import java.util.stream.*;

public class checkD39_S2 {

    // 1 · count ：长度 > 3 的词有几个，直接打印这个数字
    static void howMany(List<String> words) {
        long cou = words.stream()
                .map(String::length)
                .filter(x -> x > 3)
                .count();
        System.out.println(cou);
        // 你写
    }

    // 2 · collect ：把每个词的首字母收集成 List 打印                                             //我当时没有分清map和peek的区别
    static void initials(List<String> words) {
        List<String> wordsFirst = words.stream()
                .map(x -> x.substring(0,1))
                .collect(Collectors.toList());
        System.out.println(wordsFirst);
        // 你写
    }

    // 3 · forEach ：每个词打印一行，形状  词(长度)                                                   //不知道不用返回值
    static void each(List<String> words) {
        words.stream()
                .forEach(x-> System.out.println(x + "(" + x.length() + ")"));//不会
        // 你写
    }

    // 4 · anyMatch ：有没有长度 > 7 的词，打印 true / false
    static void anyLong(List<String> words) {
        Boolean boo = words.stream()
                .anyMatch(x -> x.length() >= 7);
        System.out.println(boo);
        // 你写
    }

    // 5 · allMatch ：是不是每个词长度都 > 1，打印 true / false
    static void allLong(List<String> words) {
        Boolean boo1 = words.stream()
                .allMatch(x -> x.length() > 1);
        System.out.println(boo1);

        // 你写
    }

    // 6 · noneMatch ：有没有以 z 开头的词（没有就 true），打印 true / false
    static void noZ(List<String> words) {
        Boolean boo2 = words.stream()
                .noneMatch(x -> x.substring(0, 1).equals("z"));
        System.out.println(boo2);
        // 你写
    }

    // 7 · findFirst ：按长度从长到短排完取第一个，打印那个词                                             //不知道可以套到sout里面
    static void first(List<String> words) {

        System.out.println(words.stream()
                        .sorted((a,b) ->b.length()-a.length())
                .findFirst()
                .get());

        // 你写
    }

    // 8 · reduce ：把所有词的长度加起来，打印总和                                                                   //不熟悉
    static void sum(List<String> words) {
        int sum1 = words.stream()
                .map(String::length)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum1);
        // 你写
    }

    public static void main(String[] args) {
        List<String> w = List.of("java", "io", "stream", "file", "buffered", "a", "reader", "go", "code");

        System.out.println("--- 1 count ---");      howMany(w);
        System.out.println("--- 2 collect ---");    initials(w);
        System.out.println("--- 3 forEach ---");    each(w);
        System.out.println("--- 4 anyMatch ---");   anyLong(w);
        System.out.println("--- 5 allMatch ---");   allLong(w);
        System.out.println("--- 6 noneMatch ---");  noZ(w);
        System.out.println("--- 7 findFirst ---");  first(w);
        System.out.println("--- 8 reduce ---");     sum(w);
    }
}
