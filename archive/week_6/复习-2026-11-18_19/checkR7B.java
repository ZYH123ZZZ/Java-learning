// 复习 7-B · 递归中档（递归出口专项，11-18）
// 目标 15 分钟。闭卷。
// 规矩：两个方法都不许写 for / while，只能递归。不许改传入的数组。

public class checkR7B {

    // 1) countGT(a, i, t)：从下标 i 到末尾，数出「比 t 大」的有几个。空数组返回 0。
    static int countGT(int[] a, int i, int t) {
        if (a.length == 0) {
            return 0;
        }
        if (i == a.length - 1) {
            return a[i] > t ? 1 : 0;
        }

        int t1 = a[i];
        // 你写
        return t1 > t ? countGT(a, i + 1, t) + 1 : countGT(a, i + 1, t);
    }

    // 2) joinAll(a, i)：从下标 i 到末尾，用 "-" 连成一个串。空数组返回 "(空)"
    static String joinAll(int[] a, int i) {
        if (a.length == 0) {
            return "(空)";
        }
        if (i == a.length - 1) {
            return String.valueOf(a[i]);
        }
        // 你写
        return a[i] + "-" + joinAll(a, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(countGT(new int[]{3, 8, 2, 9}, 0, 4));    // 期望 2  （8、9）
        System.out.println(countGT(new int[]{}, 0, 4));              // 期望 0
        System.out.println(countGT(new int[]{-5, -1, -9}, 0, -2));   // 期望 1  （-1）

        System.out.println(joinAll(new int[]{3, 8, 2}, 0));          // 期望 3-8-2
        System.out.println(joinAll(new int[]{7}, 0));                // 期望 7
        System.out.println(joinAll(new int[]{}, 0));                 // 期望 (空)
    }
}
