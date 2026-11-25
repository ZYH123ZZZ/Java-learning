// 题 learn1_7B（1.7 再练一道，约 20 分钟）—— 换一个答案，同一套滑动
//
// 写 countWindows(int[] a, int k, int limit)：
//   数一数"长度为 k 的连续一段"里，有多少段的和 >= limit，返回这个个数。
//   如果 a 的长度比 k 小（包括空数组），返回 0。
//
// 硬规则（4 条）：
//   1. 主循环上方写一行注释，就是那句不变量：// 走到这一行时，sum = ________
//   2. 主循环里只能"减一个、加一个"，不许再套一层循环，不许用 Stream / Math
//   3. 先填下面三行预测，再点运行
//   4. 只改 countWindows 这一个方法
//
public class learn1_7B {

    // 你写
    static int countWindows(int[] a, int k, int limit) {
        if (a.length < k || a.length == 0) {
            return 0;
        }

        int sum = 0;
        int size = a.length - k;//这里k和a.length是一个计数方式
        int count = 0;

        for (int i = 0; i < k; i++) {
            sum += a[i];

        }

        if (sum >= limit) {
            count++;
        }

        //走到这一行时 sum = a[i] ~ a[i + k - 1]
        for (int i = 0; i < size; i++) {
            sum = sum - a[i] + a[k + i];//曾经报错
            if (sum >= limit) {
                count++;
            }
        }
        // 你写
        return count;
    }

    // ===== 下面不用改 =====
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {5, 5, 5};

        // 预测① countWindows(a1, 2, 7) = 2
        // 预测② countWindows(a1, 3, 9) =  2
        // 预测③ countWindows(a1, 2, 10) = 0

        System.out.println("判据1 a1,k=2,limit=7:   " + countWindows(a1, 2, 7) + "    期望 2");
        System.out.println("判据2 a1,k=3,limit=9:   " + countWindows(a1, 3, 9) + "    期望 2");
        System.out.println("判据3 a1,k=2,limit=10:  " + countWindows(a1, 2, 10) + "   期望 0");
        System.out.println("判据4 a1,k=1,limit=5:   " + countWindows(a1, 1, 5) + "    期望 1");
        System.out.println("判据5 空数组:           " + countWindows(new int[]{}, 1, 0) + "  期望 0");
        System.out.println("判据6 k 太大:           " + countWindows(new int[]{1}, 2, 0) + "  期望 0");
        System.out.println("判据7 a2,k=3,limit=15:  " + countWindows(a2, 3, 15) + "   期望 1");
    }
}
