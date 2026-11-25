// 复查题 checkR20（台账 #20 Stream 四样，2026-11-25 复查，闭卷）
//
// 规则：今天不翻文档、不翻速查、不翻待复习清单。凭记忆写，写不出来就空着交。
//
// 要你做五件事，都用 Stream 一条流水线写完，不许用 for 循环：
// （2026-11-25 新规矩：复查查整个知识点——这一节讲过的全算，不只查最初那四样）
//
// ① static List<Integer> pick(List<Integer> nums)
//      去掉 <= 0 的数 → 每个数平方 → 从小到大排 → 收成 List 返回
//
// ② static long howMany(List<Integer> nums)
//      返回 nums 里 > 0 的个数
//
// 硬规则：
//   1. 只用 Stream 的中间操作 + 一个终结操作，不许 for / while
//   2. 先填下面 3 行预测，再点运行
//   3. 最下面「三问」用大白话各写一句，不许空着
//
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class checkR20 {

    static List<Integer> pick(List<Integer> nums) {
        List<Integer> Rt = nums.stream()
                .filter(x -> x > 0)
                .map(x -> x * x)
                .sorted((a, b) -> a - b)
                .collect(Collectors.toList());
        // 你写
        return Rt;
    }

    static long howMany(List<Integer> nums) {
        long how = nums.stream()
                .filter(x -> x > 0)
                .count();
        // 你写
        return how;
    }

    // ③ static boolean hasLong(List<String> words)
    //      只要有一个单词长度 >= 6 就返回 true（找到就可以停）
    static boolean hasLong(List<String> words) {
        boolean a =  words.stream()
                .anyMatch(x->x.length()>=6);
        // 你写
        return a;
    }

    // ④ static String firstThree(List<String> words)
    //      取前 3 个，用逗号连成一个字符串；不够 3 个就有几个给几个
    static String firstThree(List<String> words) {
        String a = words.stream()
                .limit(3)
                .collect(Collectors.joining(","));
        // 你写
        return a;
    }

    // ⑤ static Map<Integer, Long> countByLength(List<String> words)
    //      按单词长度分组，数每种长度各几个词
    static Map<Integer, Long> countByLength(List<String> words) {
        Map<Integer, Long> m = words.stream()
                .collect(Collectors.groupingBy(x -> x.length(), Collectors.counting()));
        // 你写
        return m;
    }

    // 三问（用大白话写一句，别抄概念）：
    // 问1 只写 .filter(...).map(...) 不写最后一个操作，程序会执行吗？
    // 答1：NO
    // 问2 .sorted() 会把传进来的那个 List 的顺序改掉吗？
    // 答2：No
    // 问3 把 nums.stream() 存成一个变量，然后对它 count() 两次，会怎样？
    // 答3：print 1

    // ===== 下面不用改 =====
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(3, -1, 2, -5, 4, 0));

        // 预测① pick(nums)          = 4,9,16
        // 预测② howMany(nums)        = 3
        // 预测③ pick(空表)           =
        // 预测④ firstThree(words)    = java,io,stream
        // 预测⑤ countByLength(words) = 1=1,2=2,4=3,6=2,8=1

        System.out.println("判据1 pick:          " + pick(nums) + "    期望 [4, 9, 16]");
        System.out.println("判据2 空表:          " + pick(new ArrayList<>()) + "    期望 []");
        System.out.println("判据3 原表没动:      " + nums + "    期望 [3, -1, 2, -5, 4, 0]");
        System.out.println("判据4 howMany:       " + howMany(nums) + "    期望 3");

        List<String> words = new ArrayList<>(
                List.of("java", "io", "stream", "file", "buffered", "a", "reader", "go", "code"));

        System.out.println("判据5 hasLong:       " + hasLong(words) + "    期望 true");
        System.out.println("判据6 firstThree:    " + firstThree(words) + "    期望 java,io,stream");
        System.out.println("判据7 firstThree空:  [" + firstThree(new ArrayList<>()) + "]    期望 [] （空串，不是 null）");
        System.out.println("判据8 countByLength: " + countByLength(words) + "    期望 {1=1, 2=2, 4=3, 6=2, 8=1}");
    }
}
