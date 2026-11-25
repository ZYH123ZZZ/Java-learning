// 复查题 checkR20C（Stream 全节 · 填空卷，约 20 分钟）
//
// 骨架已经给你，只改标着「空①」「空②」「空③」的三行，别的一个字都不许动。
// 目标：把「每种长度各有几个词」按长度从小到大写成一行，形如
//   1=1,2=2,4=3,6=2,8=1
//
// 硬规则（3 条）：
//   1. 只改那三行
//   2. 填之前先在「空② 拿到的是什么」那行注释里写一句答案，写不出来就先别填
//   3. 不许新增中间变量、不许另写 for / while
//
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class checkR20C {

    // 空② 拿到的是什么：
    static String profile(List<String> words) {
        return words.stream()
                // 空① 现在按"全是 0"分组，所以永远只有一个组。要改成按长度分组。
                .collect(Collectors.groupingBy(String::length, Collectors.counting()))
                .entrySet()
                .stream()
                // 空② 现在按"全是 0"排，等于没排。要改成按长度从小到大排。
                .sorted(Comparator.comparingInt(e -> e.getKey()))
                .map(e -> e.getKey() + "=" + e.getValue())
                // 空③ 现在用一个空串连接，结果会粘成 1=12=24=3。要改成用逗号连。
                .collect(Collectors.joining(","));
    }

    // ===== 下面不用改 =====
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(
                List.of("java", "io", "stream", "file", "buffered", "a", "reader", "go", "code"));
        List<String> shortWords = new ArrayList<>(List.of("java", "io", "go"));

        // 判据1 期望：1=1,2=2,4=3,6=2,8=1
        System.out.println("判据1: " + profile(words));

        // 判据2 期望：空串（不是 null，也不会崩）
        System.out.println("判据2: [" + profile(new ArrayList<>()) + "]");

        // 判据3 期望：2=2,4=1
        System.out.println("判据3: " + profile(shortWords));
    }
}
