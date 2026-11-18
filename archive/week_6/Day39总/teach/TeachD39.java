import java.util.*;
import java.util.stream.*;

public class TeachD39 {
    public static void main(String[] args) {
        List<String> words = List.of("java", "io", "stream", "file", "buffered", "a", "reader", "go", "code");

        // ① 你自己手写过的那套：一个 for + 一个 if + 一张新表
        List<Integer> hand = new ArrayList<>();
        for (String w : words) {
            if (w.length() >= 3) hand.add(w.length());
        }
        System.out.println("手写:   " + hand);

        // ② Stream 版：干的是同一件事，只是换了写法
        List<Integer> stream = words.stream()
                                    .filter(w -> w.length() >= 3)
                                    .map(String::length)
                                    .collect(Collectors.toList());
        System.out.println("Stream: " + stream);

        // ③ 只有中间操作，没有终点 —— 什么都不会发生
        words.stream().filter(w -> w.length() >= 3);
        System.out.println("上面那行只写了 filter，你看它一个输出都没有");

        // ④ 补上终点，立刻出结果
        long n = words.stream().filter(w -> w.length() >= 3).count();
        System.out.println("补上 count(): " + n + " 个");
    }
}
