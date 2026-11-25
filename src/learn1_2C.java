// 题 learn1_2C（1.2 区间 [from,to)，中档，约 25 分钟）
//
// 要你写一个方法：把 a[from] 到 a[to-1] 这一段拷出来，装进一个**新数组**返回。
//   含 from，不含 to。合法输入只有 0 <= from <= to <= a.length。
//
// 硬规则（4 条）：
//   1. 循环上面必须加一行注释，写死你的约定（例：// 约定：拷 from 到 to-1）
//   2. 不许用 Arrays.copyOf / System.arraycopy / clone / Stream
//   3. 先填下面三行预测，再点运行
//   4. 只改这一个方法，main 里一个字都不许动
//
// 现在方法体里是假占位（返回 {-1}），整段换成你自己的实现。
//
public class learn1_2C {

    // 你写
    static int[] copyRange(int[] a, int from, int to) {
        int size = to - from;//因为这里的size和to是一个道理 所以不用减一 我刚才报错了成功定位问题
        int[] cpa = new int[size];

        //从from拷到to-1
        int j = 0;
        for (int i = from; i < to; i++) {
            cpa[j] = a[i];
            j++;
        }

        return cpa;
    }


    // ===== 下面不用改 =====
    public static void main(String[] args) {
        int[] a = {3, 1, 4, 1, 5};

        // 预测① copyRange(a, 1, 4) 的内容和长度 = ______
        // 预测② copyRange(a, 2, 2) 的长度 = ______
        // 预测③ 把 ①的结果第一个格子改成 99 之后，a[1] 是多少 = ______

        int[] r1 = copyRange(a, 1, 4);
        System.out.println("判据1 中间段:       " + java.util.Arrays.toString(r1) + "    期望 [1, 4, 1]");

        String len2 = "null";
        int[] r2 = copyRange(a, 2, 2);
        if (r2 != null) len2 = String.valueOf(r2.length);
        System.out.println("判据2 空段长度:     " + len2 + "    期望 0（不是 null）");

        int[] r3 = copyRange(a, 3, 5);
        System.out.println("判据3 尾段:         " + java.util.Arrays.toString(r3) + "    期望 [1, 5]");

        if (r1 != null && r1.length > 0) r1[0] = 99;
        System.out.println("判据4 改返回值后 a: " + java.util.Arrays.toString(a) + "    期望 [3, 1, 4, 1, 5]");

        int[] r4 = copyRange(a, 0, 5);
        System.out.println("判据5 整段:         " + java.util.Arrays.toString(r4) + "    期望 [3, 1, 4, 1, 5]");
    }
}
