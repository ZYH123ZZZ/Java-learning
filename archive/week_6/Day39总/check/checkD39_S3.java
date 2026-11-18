import java.util.*;
import java.util.stream.*;

public class checkD39_S3 {

    // 1 · joining ：把长度 >= 5 的词用 ", " 拼成一句话打印
    static void join(List<String> words) {
        System.out.println(words.stream()
                .filter(x->x.length()>=5)
                .collect(Collectors.joining(",")));
        // 你写
    }

    // 2 · joining 带前后缀 ：只取前 3 个词，用 "-" 连起来，外面套 < >                                                 //不太熟
    static void bracket(List<String> words) {
        System.out.println(words.stream()
                .limit(3)
                .collect(Collectors.joining("-","<",">")));
        // 你写
    }

    // 3 · groupingBy ：按长度分组，直接打印这个 Map
    static void byLen(List<String> words) {
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(String::length)));
        // 你写
    }

    // 4 · groupingBy + counting ：按长度分组，每组只要个数             //不会 不知道groupingby括号里面填什么 不知道counting怎么用
    static void byLenCount(List<String> words) {
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting())));
        // 你写
    }

    // 5 · partitioningBy ：长度 >= 5 分成两组，直接打印这个 Map                                                     //不熟悉
    static void part(List<String> words) {
        System.out.println(words.stream()
                .collect(Collectors.partitioningBy(x -> x.length() >= 5)));
        // 你写
    }

    public static void main(String[] args) {
        List<String> w = List.of("java", "io", "stream", "file", "buffered", "a", "reader", "go", "code");

        System.out.println("--- 1 joining ---");              join(w);
        System.out.println("--- 2 joining 前后缀 ---");        bracket(w);
        System.out.println("--- 3 groupingBy ---");           byLen(w);
        System.out.println("--- 4 groupingBy+counting ---");  byLenCount(w);
        System.out.println("--- 5 partitioningBy ---");       part(w);
    }
}
