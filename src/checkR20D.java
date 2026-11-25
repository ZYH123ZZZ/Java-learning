// 复查题 checkR20D（Stream 全节 · 从零写，约 25 分钟）
//
// 这一卷不给骨架、不给填空，方法体是空的，你自己从零写。
// 练的是：把"要做什么"翻译成流水线，选对中间操作和终结操作。
//
// 要做的事：返回"最长的 n 个词"。
//   1. 只留长度 >= 3 的词（长度 1、2 的不要）
//   2. 按长度从大到小排
//   3. 长度相同的，保持它们在原表里的先后顺序
//   4. 只要前 n 个
//   5. n <= 0 返回空表；不够 n 个就有几个给几个
//
// 硬规则（4 条）：
//   1. 只改 topLongest 这一个方法，别的不许动
//   2. 不许用 for / while / 手写循环
//   3. 先填下面三行预测，再点运行
//   4. 不许新建中间 List 变量，一条流水线写完
//
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class checkR20D {

    // 你写
    static List<String> topLongest(List<String> words, int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> li = words.stream()
                .filter(x -> x.length() >= 3)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(n)
                .collect(Collectors.toList());
        return li;
    }

    // ===== 下面不用改 =====
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(
                List.of("java", "io", "stream", "file", "buffered", "a", "reader", "go", "code"));
        List<String> tiny = new ArrayList<>(List.of("ab", "c", "de"));

        // 预测① topLongest(words, 3)  = ______
        // 预测② topLongest(words, 10) = ______
        // 预测③ topLongest(words, 0)  = ______

        // 判据1 期望：[buffered, stream, reader]
        System.out.println("判据1: " + topLongest(words, 3));

        // 判据2 期望：[buffered, stream, reader, java, file, code]
        System.out.println("判据2: " + topLongest(words, 10));

        // 判据3 期望：[]
        System.out.println("判据3: " + topLongest(words, 0));

        // 判据4 期望：[buffered]
        System.out.println("判据4: " + topLongest(words, 1));

        // 判据5 期望：[] （全是长度 1、2 的词，一个都不留）
        System.out.println("判据5: " + topLongest(tiny, 5));

        // 判据6 期望：[buffered, stream, reader, java] （只要前 4 个；后面那行是为了看原表有没有被改）
        System.out.println("判据6: " + topLongest(words, 4));
        System.out.println("原表还是: " + words);
    }
}
