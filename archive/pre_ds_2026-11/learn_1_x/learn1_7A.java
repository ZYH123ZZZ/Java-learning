// 题 learn1_7A（1.7 中档，约 25 分钟）—— 循环不变量：sum 到底是什么的和
//
// 题面不给代码，只给要求，结构你自己写：
//
//   写 maxWindowSum(int[] a, int k)：找出长度正好为 k 的连续一段，返回其中和最大的那个和。
//   如果 a 的长度比 k 小（包括 a 是空数组），返回 0。
//
//   做法不限几层，但有一条规定：进入主循环之后，每一步只能"减掉一个、加上一个"，
//   不许对每个 i 都重新把 k 个数加一遍（那样是 n×k 次，白学这一节）。
//   每一步 i 上，你要维护的 sum 必须等于 a[i-k+1] 到 a[i] 这 k 个数的和。
//
// 硬规则（4 条）：
//   1. 主循环上方写一行注释，就是那句不变量：// 这一步 sum = ________
//   2. 主循环里不许出现再套一层的循环、不许用 Stream、不许用 Math.*
//   3. 先填下面三行预测，再点运行
//   4. 只改这一个方法
//
public class learn1_7A {

    // 你写
    static int maxWindowSum1(int[] a, int k) {
        if (a.length < k || a.length == 0) {
            return 0;
        }

        // 这一步 sum1 = 每一次求和
        int size1 = a.length - k + 1;
        int[] sum1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            for (int j = i; j < i + k; j++) {
                sum1[i] += a[j];
            }
        }

        int max = sum1[0];
        for (Integer x : sum1) {
            if (max < x) {
                max = x;
            }
        }
        // 你写
        return max;
    }


    static int maxWindowSum(int[] a, int k) {
        if (a.length < k || a.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = 0;
        int size = a.length - k + 1;
        //这里sum加的首次k项和
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }

        //sum从[i,i + k - 1]替换成[i + 1,i + k]
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                max = sum;
            } else {
                sum = sum - a[i - 1] + a[i + k - 1];
            }

            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }
    // ===== 下面不用改 =====
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {5, 5, 5};

        // 预测① maxWindowSum(a1, 2) = 9
        // 预测② maxWindowSum(a1, 3) = 12
        // 预测③ maxWindowSum({}, 1)  = 0

        System.out.println("判据1 a1,k=2:  " + maxWindowSum(a1, 2) + "    期望 9");
        System.out.println("判据2 a1,k=3:  " + maxWindowSum(a1, 3) + "    期望 12");
        System.out.println("判据3 a1,k=1:  " + maxWindowSum(a1, 1) + "    期望 5");
        System.out.println("判据4 a2,k=3:  " + maxWindowSum(a2, 3) + "    期望 15");
        System.out.println("判据5 空数组:  " + maxWindowSum(new int[]{}, 1) + "  期望 0");
        System.out.println("判据6 k 太大:  " + maxWindowSum(new int[]{1}, 2) + "  期望 0");
    }
}
