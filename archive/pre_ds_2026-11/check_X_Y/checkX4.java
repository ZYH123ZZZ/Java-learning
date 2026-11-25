// checkX4  盲区诊断④ 带 bug 代码的定位推演（纸面题，不许运行）
//
// 硬规则（违反就不算这题的结果）
//   1) 不许运行、不许加 println、不许改完先跑来试。
//   2) 第 1 步：纸上填追踪表（6 轮，i / run / best 三列），并指出「哪一轮该重置却没重置」。
//   3) 第 2 步：如果上 IDEA 断点——打在哪一行、看哪两个变量、第几次命中就能定死 bug。
//   4) 第 3 步：改。改动不超过三处，代码上方补一行不变量注释「每轮开头 run 代表什么」。
//   我批改时会抽查第 4 轮和第 5 轮的 run / best 各是多少 —— 只有真推过的人才答得出。

public class checkX4 {

    // 不变量（改完补一行）：每轮开头 run 代表 ______
    static int longestRun(int[] a) {
        int best = 0, run = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) run++;
            best = run;
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println("判据1 [1,1,2,2,2,3] : " + longestRun(new int[]{1, 1, 2, 2, 2, 3}));
        System.out.println("判据2 [5]           : " + longestRun(new int[]{5}));
        System.out.println("判据3 []            : " + longestRun(new int[]{}));
        System.out.println("隐藏1 [1,2,1,2]     : " + longestRun(new int[]{1, 2, 1, 2}));
        System.out.println("隐藏2 [2,2,2]       : " + longestRun(new int[]{2, 2, 2}));
    }
}
