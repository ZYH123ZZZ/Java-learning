// 题 learn1_4A（1.4 纸上跑一遍 / Trace，约 25 分钟）
//
// 下面这个方法**是故意写错的**，你一个字都不要改它。
// 你的任务是：不点运行，先在纸上（这里）把表填完，再点运行对答案。
//
// 方法的意思：返回"最长一段连续相同的数"有多长。
//   {1,1,2,2,2} 正确答案是 3（三个 2），但它返回的是 4。
//
// 硬规则（3 条）：
//   1. 先把下面「表」和「三问」填满，再点运行；空着就交 = 不算
//   2. 不许用 Stream、不许用 Math.*（这题你也不用写代码）
//   3. 表里每一格都要填数字，"我不知道"不算
//
public class learn1_4A {

    // ↓↓↓ 这块是题目内容，别改 ↓↓↓
    static int longestRun(int[] a) {
        int best = 1;
        int run = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                run = run + 1;
            }
            if (run > best) {
                best = run;
            }
        }
        return best;
    }
    // ↑↑↑ 这块是题目内容，别改 ↑↑↑


    // ===== 你要填的（a = {1,1,2,2,2}，i 从 1 数到 4，一共 4 轮）=====

    // 表（每轮跑完循环体之后，run 和 best 各是多少）：
    //   轮① i=1  a[1]=2  run=2  best=2
    //   轮② i=2  a[2]=2  run=2  best=2
    //   轮③ i=3  a[3]=2  run=3  best=3
    //   轮④ i=4  a[4]=2  run=4  best=4

    // 三问（各一句话，别写长）：
    // 问1 从第几轮开始不对？从第二轮开始不对 因为两边数不一样要重置 不重置就把上一次统计的旧数加上了 这一轮 run 应该是 1，程序里实际是 2
    // 问2 错在第几行？（写成 "第 21，22 行"） 要加一个重置
    // 问3 一句话说清根因：因为两边数不一样要重置 不重置就把上一次统计的旧数加上了


    static int longestRuncorrect(int[] a) {
        int best = 1;
        int run = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                run = run + 1;
            } else if (a[i] != a[i - 1]) {
                run = 1;
            }
            if (run > best) {
                best = run;
            }
        }
        return best;
    }
    // ===== 下面不用改 =====
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 2};
        System.out.println("判据1 三个2连一起:  " + longestRun(a) + "   正确应是 3");

        int[] b = {5, 5, 5};
        System.out.println("判据2 全一样:       " + longestRun(b) + "   正确应是 3");

        int[] c = {1, 2, 3};
        System.out.println("判据3 全不一样:     " + longestRun(c) + "   正确应是 1");
    }
}
