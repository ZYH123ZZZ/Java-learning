// checkX2  盲区诊断② 区间语义 [l, r) 推导
//
// 题：lowerBound —— a 升序（可重复），返回第一个 ≥ target 的下标；全部小于 target 返回 a.length；空数组返回 0。
//
// 硬规则（违反就不算结果）
//   1) 写循环前，先在不变量注释里写清：循环开头 l 代表什么、r 代表什么（用 [l, r) 的措辞）。
//   2) 跑之前，先在纸上把 a = [1,3,3,5]、target = 3 的逐轮 l / r / mid 填成表，填完再跑。
//   3) 不许先跑再挪 +1 / -1。两个更新分支和出口条件都得从区间语义读出来。
//   4) 跑完要能答：为什么出口是 l == r 而不是 l > r；为什么有一支更新是 r = mid 而不是 mid - 1。

public class checkX2 {

    static int lowerBound(int[] a, int target) {
        // 不变量（先写这一行，再写代码）：
        //   循环开头，答案一定落在 [l, r) 里，l 和 r 各代表 ______

        // 你写

        return 0;
    }

    static void show(int[] a, int target) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i < a.length - 1) sb.append(',');
        }
        sb.append(']');
        System.out.println("  数组 " + sb + " target=" + target + " → " + lowerBound(a, target));
    }

    public static void main(String[] args) {
        System.out.println("判据1 主表：[1,3,3,5]");
        show(new int[]{1, 3, 3, 5}, 3);
        show(new int[]{1, 3, 3, 5}, 0);
        show(new int[]{1, 3, 3, 5}, 6);
        show(new int[]{1, 3, 3, 5}, 4);

        System.out.println("隐藏组：");
        show(new int[]{}, 3);
        show(new int[]{2}, 2);
        show(new int[]{1, 1, 1}, 1);
        show(new int[]{5, 6}, 6);
        show(new int[]{5, 6}, 7);
    }
}
