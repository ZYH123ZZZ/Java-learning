// 题 learn1_6A（1.6 基础，约 15 分钟）—— 数一数最里面那行跑了几次
//
// 结构是这样的（内层从 j = i 开始，不是从 0 开始）：
//内层第i轮跑 n - i 次
//   for (int i = 0; i < n; i++) {
//       for (int j = i; j < n; j++) {
//           c++;
//       }
//   }
//
// 要你写 stepCount(n)：返回 c 最后是多少，也就是 c++ 一共执行了几次。
//
// 硬规则（3 条）：
//   1. 循环上方必须写一行注释，写死你对"内层每轮跑几次"的判断
//   2. 不许用 Math.*、不许直接 return n * (n + 1) / 2（必须让循环真的跑一遍）
//   3. 先填下面三行预测，再点运行
//
public class learn1_6A {

    // 你写
    static int stepCount(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) {
            c += i;
        }
        // 你写
        return c;
    }

    // ===== 下面不用改 =====
    public static void main(String[] args) {
        // 预测① stepCount(2)  = ______
        // 预测② stepCount(4)  = ______
        // 预测③ stepCount(10) = ______

        System.out.println("判据1 n=0:   " + stepCount(0) + "    期望 0");
        System.out.println("判据2 n=1:   " + stepCount(1) + "    期望 1");
        System.out.println("判据3 n=4:   " + stepCount(4) + "    期望 10");
        System.out.println("判据4 n=10:  " + stepCount(10) + "    期望 55");
        System.out.println("判据5 n=100: " + stepCount(100) + "   期望 5050");
    }
}
