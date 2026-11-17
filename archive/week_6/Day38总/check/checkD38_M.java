import java.util.*;
import java.util.function.Function;

public class checkD38_M {

    // 你只写这个方法：一个参数、void、自己打印
    static void total(List<String> nums) {
        if (nums.isEmpty()) {
            System.out.println("没有计数");
            return;
        }

        Function<String, Integer> f = Integer::parseInt;

        int countPassnum = 0;
        int countFailnum = 0;
        int sumNum = 0;

            for (String x : nums) {
                try {  f.apply(x);
                sumNum += f.apply(x);
                countPassnum++;} catch (NumberFormatException e) {
                    countFailnum++;
                }
            }


        System.out.println("有效 " + countPassnum + " 个，一共 " + sumNum + " 跳过 " + countFailnum + " 个");






















        // 你写
    }

    public static void main(String[] args) {
        System.out.println("--- m1 混合数据 ---");
        total(new ArrayList<>(List.of("12", "7", "30", "x9", "5")));
        System.out.println("--- m2 空表 ---");
        total(new ArrayList<>());
        System.out.println("--- m3 全是坏数据 ---");
        total(new ArrayList<>(List.of("a", "b")));
        System.out.println("--- m4 两个正常 ---");
        total(new ArrayList<>(List.of("3", "3")));
    }
}
