import java.util.*;
import java.util.stream.*;

public class checkD39_S1 {

    // 1 · filter ：只留长度 >= 5 的词，收集成 List 打印
    static void onlyLong(List<String> words) {
        List<String> words1 = words.stream()
                .filter(w -> w.length() >= 5)
                .collect(Collectors.toList());
        System.out.println(words1);
        // 你写
    }

    // 2 · map ：把每个词换成长度，收集成 List 打印
    static void lengths(List<String> words) {
        List<Integer> words1 = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(words1);
        // 你写
    }

    // 3 · sorted() ：按字典序排，收集成 List 打印
    static void abc(List<String> words) {
        List<String> words1 = words.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(words1);
        // 你写
    }

    // 4 · sorted(Comparator) ：按长度从长到短，收集成 List 打印
    static void byLenDesc(List<String> words) {
        List<String> words1 = words.stream()
                .sorted((a, b) -> b.length() - a.length())
                .collect(Collectors.toList());
        System.out.println(words1);
        // 你写
    }

    // 5 · distinct ：先换成长度，再去重，收集成 List 打印                                                               //不熟悉
    static void uni(List<String> words) {
        List<Integer> words1 = words.stream()
                .map(String::length)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(words1);
        // 你写
    }

    // 6 · skip + limit ：跳过前 2 个，再取 3 个，收集成 List 打印                                                   //不熟悉
    static void top3(List<String> words) {
        List<String> words1 = words.stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(words1);
        // 你写
    }

    // 7 · peek ：先 peek 打印 "看: " + 词，再收集成 List，最后打印 "收完还是 N 个"                                      //不熟悉
    static void peeked(List<String> words) {
        List<String> words1 = words.stream()
                .peek(x-> System.out.println("看: " + x))
                .collect(Collectors.toList());
        System.out.println("收完还是 " + words1.size() + " 个");
        // 你写
    }

    public static void main(String[] args) {
        List<String> w = List.of("java", "io", "stream", "file", "buffered", "a", "reader", "go", "code");

        System.out.println("--- 1 filter ---");            onlyLong(w);
        System.out.println("--- 2 map ---");               lengths(w);
        System.out.println("--- 3 sorted ---");            abc(w);
        System.out.println("--- 4 sorted比较器 ---");       byLenDesc(w);
        System.out.println("--- 5 distinct ---");          uni(w);
        System.out.println("--- 6 skip+limit ---");        top3(w);
        System.out.println("--- 7 peek ---");              peeked(w);
    }
}
