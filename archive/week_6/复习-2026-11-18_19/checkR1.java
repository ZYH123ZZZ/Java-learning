// 复习 1 · switch 语法与贯穿（待复习清单第 1 条，B 档，11-18）
// 目标 15 分钟。闭卷，不许翻笔记。
public class checkR1 {

    // 【1】daysIn(int month) —— 返回这个月有几天
    //     2            → 28
    //     4、6、9、11  → 30
    //     1、3、5、7、8、10、12 → 31
    //     不在 1~12    → -1
    //
    // 硬要求：用 switch，而且 31 天那一组多个 case 要落进同一段（贯穿），
    //        不许每个 case 各写一遍 d = 31; break;
    static int daysIn(int month) {
        switch (month) {
            case 2:
                return 28;

            case 4, 6, 9, 11:
                return 30;

            case 1, 3, 5, 7, 8, 10, 12:
                return 31;

            default:
                return -1;
            }
        }

    // 【2】report(int[] months) —— 逐个打印，末尾数出 31 天的月份有几个
    //     打印：3 月 → 31 天
    //          13 月 → 非法          （daysIn 返回 -1 时打「非法」）
    //     最后一行：31 天的月份：4 个
    static void report(int[] months) {
        int days;
        int count31 = 0;
        for (int x : months) {
            days = daysIn(x);
            if (days == 31) {
                count31++;
            }
            if (days == -1) {
                System.out.println("非法");
            } else {
                System.out.println(x + " 月 -> " + days + " 天");
            }
        }

        System.out.println("31 天的月份 " + count31 + " 个");
        // 你写
    }

    public static void main(String[] args) {
        System.out.println(daysIn(1));   // 31
        System.out.println(daysIn(2));   // 28
        System.out.println(daysIn(4));   // 30
        System.out.println(daysIn(11));  // 30
        System.out.println(daysIn(13));  // -1
        System.out.println(daysIn(0));   // -1
        System.out.println("---");
        report(new int[]{3, 12, 7, 2, 13, 5, 9, 0});
    }
}
