// 复习 6 · 抛异常之后 try 后面的代码不会再执行（待复习清单第 6 条，B 档，11-18）
// 目标 15 分钟。闭卷。
// 规矩：只用 try-catch 判断"能不能转成数字"，不许用 Character.isDigit / matches / 正则自己判。

public class checkR6 {

    // report(String[] a) —— 逐个处理数组里的每个字符串：
    //     能转成 int  → 累加，打印 "<原串> → 累加 <当前总和>"
    //     转不了的    → 打印 "坏 <原串> → 跳过"
    //   最后打印 "合计 <成功数> 个成功、<跳过数> 个跳过、总数 <总和>"
    //
    //     report(new String[]{"12","abc","34","xyz","2"}) 期望：
    //       12 → 累加 12
    //       坏 abc → 跳过
    //       34 → 累加 46
    //       坏 xyz → 跳过
    //       2 → 累加 48
    //       合计 3 个成功、2 个跳过、总数 48
    static void report(String[] a) {
        int countTrueTrans = 0;
        int countFailTrans = 0;
        int sum = 0;
        for (String x : a) {
            try {
                int num = Integer.parseInt(x);
                sum += num;
                System.out.println(x + " -> 累加 " + sum);
                countTrueTrans++;
            } catch (NumberFormatException e) {
                System.out.println("坏 " + x + " -> 跳过");
                countFailTrans++;
            }
        }
        System.out.println("合计 " + countTrueTrans + " 个成功, " + countFailTrans + " 个跳过,总数 " +sum);
        // 你写
    }

    public static void main(String[] args) {
        System.out.println("--- 第一组 ---");
        report(new String[]{"12", "abc", "34", "xyz", "2"});

        System.out.println("--- 第二组：全是坏的 ---");
        report(new String[]{"aa", "bb"});

        System.out.println("--- 第三组：第一个就坏 ---");
        report(new String[]{"q", "7"});
    }
}
