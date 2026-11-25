// 题 learn1_6B（1.6 基础，约 15 分钟）—— 内层不是每次都跑满
//
// 题面这次不给你代码，只给中文，结构你自己写：
//
//   外层：i 从 0 开始，每轮加 1，只要 i < n 就继续。
//   内层：对每个 i，j 从 i 开始，每轮加 2，只要 j < n 就再数一次。
//        每数一次，c 加 1。
//   最后返回 c。
//
// 要你写 stepCount(n)。
//
// 硬规则（3 条）：
//   1. 内层循环上方写一行注释，写死你以为"这一轮内层会跑几次"
//   2. 不许用 Math.*、不许写公式直接 return（必须让循环真的跑）
//   3. 先填下面三行预测，再点运行
//
public class learn1_6B {

    // 你写
    static int stepCount(int n) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j += 2) {
                c++;
            }
        }
        // 你写
        return c;
    }

    // ===== 下面不用改 =====
    public static void main(String[] args) {
        // 预测① stepCount(2)  =  1
        // 预测② stepCount(4)  =  3
        // 预测③ stepCount(10) =  15

        System.out.println("判据1 n=0:   " + stepCount(0) + "    期望 0");
        System.out.println("判据2 n=1:   " + stepCount(1) + "    期望 1");
        System.out.println("判据3 n=2:   " + stepCount(2) + "    期望 2");
        System.out.println("判据4 n=4:   " + stepCount(4) + "    期望 6");
        System.out.println("判据5 n=10:  " + stepCount(10) + "    期望 30");
    }
}
