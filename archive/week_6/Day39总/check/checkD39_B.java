import javax.security.auth.login.CredentialException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;

/**
 * 查漏 32 · Day39 Stream 词长报告
 * 题面：E:\dsh\java\查漏32-Day39Stream.md
 * 规矩：两个方法都只能用 Stream，不许 for 循环；方法名、参数、接口都不许改。
 */
public class checkD39_B {

    // 附赠练手（不判档，30 秒）：接口我写死，你只填下面那行 Lambda
    // 期望：make(6, 2L) → "6:2"
    interface Row {
        String make(int len, long n);
    }

    static Row row = (len, n) -> len + ":" + n;   // ← 你填：(len, n) -> ???

    // 1 · 拆词 + 过滤 + 按长度分组计数
    static Map<Integer, Long> dist(String text) {
        String[] n1 = text.split(" +");
        Map<Integer,Long> m1 = Arrays.stream(n1)
                .filter(x -> x.length() >= 3)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        return m1;
        // 你写（只能用 Stream）
        // 提示：text.split(" +") 得到的是数组，数组起流用 Arrays.stream(...)
         }

    // 2 · 排序 + 拼成一整行
    static String brief(Map<Integer, Long> d) {
        if (d.isEmpty()) {
            return "(无数据)";
        }

        String ans = d.keySet().stream()
                .sorted((a, b) -> {
                    if (d.get(a).equals(d.get(b))) {
                        return b.compareTo(a);
                    }
                    return (int) (d.get(b) - d.get(a));
                })
                .map(x -> row.make(x, d.get(x)))
                .collect(Collectors.joining("|", "[", "]"));
        // 你写（只能用 Stream；每段文字调 row.make(k, d.get(k)) 生成）
        // 提示：Map 自己不能排序，先 d.keySet().stream() 起一条流
        return ans;                   // 占位：写完把这行删掉
    }

    public static void main(String[] args) {
        String[] texts = {
                "java file stream reader cat dog buffered io a",
                "a io",
                "java",
                "aaa bbb"
        };
        for (String t : texts) {
            System.out.println("--- " + t + " ---");
            Map<Integer, Long> d = dist(t);
            System.out.println("dist  = " + d);
            System.out.println("brief = " + brief(d));
        }
    }
}
