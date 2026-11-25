// 复查题 checkR20B（Stream 全节 · 改错题，约 25 分钟）
//
// 这题的骨架和 checkR20 不一样：上次是"你写五个方法"，这次是"给你一段跑不通的代码，你找错修好"。
//
// report 想干两件事（两个都必须真的打印出来）：
//   1) 打印「长度 >= 6 的词，用 / 连起来」；一个都没有就打印一个短横线 -
//   2) 打印「每种长度各几个词」，形如 {1=1, 2=2, 4=3, 6=2, 8=1}
//
// 现在这段代码有三个错：跑起来直接崩，崩之前也没打印出正确内容。
//
// 硬规则：
//   1. 只改 report 方法体，两个 System.out.println 都要保留（不许删掉第二个功能）
//   2. 不许 for / while
//   3. 在下面「三个错」的三行里各写一句「错在哪」，先写再改代码
//
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class checkR20B {

    // 错1：Stream<String>
    // 错2：没有给两个输出分类
    // 错3：没有分组,counting
    static void report(List<String> words) {
        List<String> longs = words.stream()
                .filter(w -> w.length() >= 6)
                .collect(Collectors.toList());

        String joined = longs.stream().collect(Collectors.joining("/"));

        if (joined.isEmpty()) {
            System.out.println("长词: -");
        } else {
            System.out.println("长词: " + joined);
        }

        System.out.println("统计: " + words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting())));
    }

    // 第三件事（额外一小问）：static List<String> descByLength(List<String> words)
    //      返回一个新的 List：按单词长度从长到短排；长度相同的，保持原来的先后。
    //      必须写成 Comparator.comparingInt(...).reversed() 这种形式，
    //      不许手写 (a, b) -> b.length() - a.length()。
    static List<String> descByLength(List<String> words) {
        List<String> l1 = words.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        // 你写
        return l1;
    }

    // ===== 下面不用改 =====
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(
                List.of("java", "io", "stream", "file", "buffered", "a", "reader", "go", "code"));
        List<String> shortWords = new ArrayList<>(List.of("java", "io", "go"));

        System.out.println("===== 判据1+2：正常表 =====");
        // 期望第一行：长词: stream/buffered/reader
        // 期望第二行：统计: {1=1, 2=2, 4=3, 6=2, 8=1}
        report(words);

        System.out.println("===== 判据3+4：只有短词的表 =====");
        // 期望第一行：长词: -
        // 期望第二行：统计: {2=2, 4=1}
        report(shortWords);

        System.out.println("===== 判据5：按长度倒序 =====");
        // 期望：[buffered, stream, reader, java, file, code, io, go, a]
        //       长度相同的（stream/reader、java/file/code、io/go）保持原来先后
        System.out.println(descByLength(words));
    }
}
