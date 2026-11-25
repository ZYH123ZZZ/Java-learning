import java.util.Arrays;

// 题 learn1_1B（1.1 中档，约 25 分钟）—— 门牌号第二层：行也是一个数组
//
// 背景：int[][] m 就是"数组的数组"。m[0] 本身也是一个 int[]，
//       所以 int[] row = m[0]; 抄的是哪间屋的门牌号？这就是本题。
//
// 要你写两行（标了 // 你写 的地方），其它一个字都不许改：
//   ① 让 row 和 m[0] 是【同一行】（共享，不许复制）
//   ② 让 safe 是 m[1] 的【副本】（改了 m[1] 不能跟着变）
//
// 硬规则（3 条）：
//   1. ① 里不许出现 new，不许出现 copyOf —— 想清"同一行"要怎么做
//   2. ② 里必须真的复制（copyOf 或 for 循环都行，你选）
//   3. 写完先预测下面四行输出，再点运行
//
public class learn1_1B {

    public static void main(String[] args) {
        int[][] m = {{1, 2}, {3, 4}};

        // ① 你写（让 row 和 m[0] 是同一行）
        int[] row = m[0];

        // ② 你写（让 safe 是 m[1] 的副本）
        int[] safe = Arrays.copyOf(m[1], m[1].length);

        // ===== 下面不用改 =====
        if (row != null) row[0] = 99;
        if (safe != null) safe[0] = 7;

        System.out.println("① m[0][0] = " + m[0][0] + "        （期望 99）");
        System.out.println("② m[1][0] = " + m[1][0] + "        （期望 3）");
        System.out.println("③ row 与 m[0] 是同一行？ " + (row == null ? "row 还是 null" : String.valueOf(row == m[0])) + "   （期望 true）");
        System.out.println("④ safe 与 m[1] 是同一行？ " + (safe == null ? "safe 还是 null" : String.valueOf(safe == m[1])) + "   （期望 false）");
    }
}
