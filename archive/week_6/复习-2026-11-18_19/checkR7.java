// 复习 7 · 递归出口（待复习清单第 7 条，C 档，11-18）
// 目标 20 分钟。闭卷。
// 规矩：两个方法都不许写 for / while，只能靠递归。

public class checkR7 {

    // 1) sum(a, i)：从下标 i 到末尾求和。空数组要返回 0。
    static int sum(int[] a, int i) {
        if (i == a.length ) {
            return 0;
        }
        // 你写
        return sum(a, i + 1) + a[i];
    }

    // 2) maxOf(a, i)：从下标 i 到末尾取最大值。调用时保证至少有 1 个元素。
    static int maxOf(int[] a, int i) {
        if (i == a.length - 1) {
            return a[i];
        }
        int rest = maxOf(a, i + 1);
        return a[i] > rest ? a[i] : rest;
    }

    public static void main(String[] args) {
        int[] g1 = {3, 8, 2};
        int[] g2 = {};
        int[] g3 = {5};
        int[] g4 = {-3, -8, -1};

        System.out.println(sum(g1, 0) + " " + maxOf(g1, 0));   // 期望 13 8
        System.out.println(sum(g2, 0));                        // 期望 0
        System.out.println(sum(g3, 0) + " " + maxOf(g3, 0));   // 期望 5 5
        System.out.println(sum(g4, 0) + " " + maxOf(g4, 0));   // 期望 -12 -1
    }
}
