// 题 learn1_2A（1.2 基础，约 20 分钟）—— 左包括，右不包括
//
// 要你写一个方法：把 a[from] 到 a[to-1] 加起来。
//   含 from，不含 to。合法输入只有 0 <= from <= to <= a.length。
//
// 硬规则（3 条）：
//   1. 循环上面必须加一行注释，写死你的约定（例：// i 从 from 取到 to-1）
//   2. 不许用 Stream、不许用 Arrays 里的求和、不许用 Math.*
//   3. 先填下面三行预测，再点运行
//
public class learn1_2A {

    // 你写
    static int sumRange(int[] a, int from, int to) {
        int sum = 0;
        //i 从 from 加到 to - 1
        for (int i = from; i < to; i++) {
            sum += a[i];
        }
        return sum;
    }

    // ===== 下面不用改 =====
    public static void main(String[] args) {
        int[] a = {3, 1, 4, 1, 5};

        // 预测① sumRange(a, 0, 0) = ______
        // 预测② sumRange(a, 1, 4) = ______
        // 预测③ sumRange(a, 5, 5) = ______

        System.out.println("判据1 空区间 (0,0):      " + sumRange(a, 0, 0) + "    期望 0");
        System.out.println("判据2 整段 (0,5):        " + sumRange(a, 0, 5) + "   期望 14");
        System.out.println("判据3 中间 (1,4):        " + sumRange(a, 1, 4) + "    期望 6");
        System.out.println("判据4 单格 (2,3):        " + sumRange(a, 2, 3) + "    期望 4");
        System.out.println("判据5 尾后空 (5,5):      " + sumRange(a, 5, 5) + "    期望 0");
    }
}
