// 题 Y1 —— 范围先说清（左包括、右不包括）
// 数组 a 已经从小到大排好。写 firstAtLeast：返回第一个 >= target 的下标；找不到返回 a.length。
//
// 硬规则（4 条）：
//   1. 先在这行下面写一句范围说明，写清「l 能取到、r 取不到」
//   2. 方法不超过 10 行
//   3. 跑之前先把 5 组预测填进 main 里那行注释
//   4. 闭卷；不许 println 瞎试
//
// 你写：
public class checkY1 {

    static int firstAtLeast(int[] a, int target) {
        return -1; // 你写
    }

    // ===== 下面不用改 =====
    public static void main(String[] args) {
        // 预测：我预计 5 组的结果依次是 ____ / ____ / ____ / ____ / ____
        int[] a = {1, 3, 3, 5};
        p(a, 3, 1);
        p(a, 0, 0);
        p(a, 6, 4);
        p(a, 4, 3);
        p(new int[]{}, 3, 0);
    }

    static void p(int[] a, int target, int want) {
        int got = firstAtLeast(a, target);
        System.out.println("数组 " + java.util.Arrays.toString(a) + "  target=" + target
                + "  →  你: " + got + "   期望: " + want + (got == want ? "   ✅" : "   ❌"));
    }
}
