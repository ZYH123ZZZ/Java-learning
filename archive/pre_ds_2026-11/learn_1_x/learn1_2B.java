// 题 learn1_2B（1.2 中档，约 25 分钟）—— 只反转一段：两头夹
//
// 要你写：static void reverse(int[] a, int from, int to)
//   把 a 的 [from, to) 这一段原地反过来，不含 to；别的格子一格都不许动。
//
// 打法就一句话：两个下标，一个从 from 往右走，一个从 to-1 往左走，走到碰上就停。
//   l 指向左边待换的格子，r 指向右边待换的格子；
//   换完 l++、r--；当 l 不再小于 r，这一段就换完了。
//
// 硬规则（4 条）：
//   1. 循环上面必须写一行不变量注释：`// l 左边已反转，r 右边已反转`
//   2. 不许新建数组、不许 Collections.reverse、不许 Stream
//   3. 段外（下标 < from 或 >= to）一格都不许动
//   4. 先填两行预测，再点运行
//
public class learn1_2B {

    // 你写
    static void reverse(int[] a, int from, int to) {
        for (int i = from; i < to; i++) {
            int fromi = i;
            int toi = (to - 1) - (i - from);
            if (fromi >= toi) {//以后记住 判断是否break的时候要仔细想想是不是判断要在执行之前
                break;
            }
            int tmp = a[fromi];
            a[fromi] = a[toi];
            a[toi] = tmp;
        }
    }

    // ===== 下面不用改 =====
    static void check(int[] a, int from, int to, String want) {
        reverse(a, from, to);
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i < a.length - 1) sb.append(", ");
        }
        sb.append("]");
        String got = sb.toString();
        System.out.println("(" + from + "," + to + ") → " + got + "   期望 " + want + "   " + (got.equals(want) ? "✅" : "❌"));
    }

    public static void main(String[] args) {
        // 预测① check({1,2,3,4,5}, 1, 4) 的结果 = ______
        // 预测② check({1,2,3,4,5}, 3, 5) 的结果 = ______

        check(new int[]{1, 2, 3, 4, 5}, 0, 5, "[5, 4, 3, 2, 1]");
        check(new int[]{1, 2, 3, 4, 5}, 1, 4, "[1, 4, 3, 2, 5]");
        check(new int[]{1, 2, 3, 4, 5}, 2, 2, "[1, 2, 3, 4, 5]");
        check(new int[]{1, 2, 3, 4, 5}, 0, 1, "[1, 2, 3, 4, 5]");
        check(new int[]{1, 2, 3, 4, 5}, 3, 5, "[1, 2, 3, 5, 4]");
    }
}
