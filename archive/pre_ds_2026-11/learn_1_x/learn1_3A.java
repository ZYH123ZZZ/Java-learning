// 题 learn1_3A（1.3 写代码的先后顺序，约 25 分钟）
//
// 要你写一个方法：groups 里每个小组是一个 int[]，把每个小组的格子加起来，
// 结果按小组顺序装进一个**新数组**返回。样例：
//   {{1,2},{3},{},{4,5,6}}  →  {3, 3, 0, 15}
//
// 硬规则（4 条）：
//   1. 方法上方必须先把下面这三行草稿填了，再写循环（填错也算交）：
//        // 何时有值：sum 在 ______循环内 里声明
//        // 每轮归零：是 / 否，因为 ______是 因为每一次都会把sum存到一个新数组里
//        // 门口挡什么：空组 / 零组 / 都不用 都不用
//   2. 不许用 Stream、不许用 Arrays.stream、不许用 Math.*
//   3. 先填下面三行预测，再点运行
//   4. 只改这一个方法，main 里一个字都不许动
//
// 现在方法体是假占位（返回 {-1}），整段换成你自己的实现。
//
public class learn1_3A {

    // 你写
    static int[] sumGroups(int[][] groups) {
        int[] arr = new int[groups.length];

        for (int i = 0; i < groups.length; i++) {
            int sum = 0;
            for (int j = 0; j < groups[i].length; j++) {
                sum += groups[i][j];
            }
            arr[i] = sum;
        }
        return arr;
    }

    // ===== 下面不用改 =====
    public static void main(String[] args) {
        int[][] g = {{1, 2}, {3}, {}, {4, 5, 6}};
        int[][] empty = new int[0][];

        // 预测① sumGroups(g) 里第 1 组那个数 = ______3
        // 预测② sumGroups(g) 里第 3 组（空组）那个数 = ______0
        // 预测③ sumGroups(g) 返回数组的长度 = ______4

        System.out.println("判据1 四组:       " + java.util.Arrays.toString(sumGroups(g)) + "    期望 [3, 3, 0, 15]");

        int[] e = sumGroups(empty);
        System.out.println("判据2 零组长度:   " + (e == null ? "null" : e.length) + "    期望 0（不是 null）");

        System.out.println("判据3 两个空组:   " + java.util.Arrays.toString(sumGroups(new int[][]{{}, {}})) + "    期望 [0, 0]");

        System.out.println("判据4 换个数据:   " + java.util.Arrays.toString(sumGroups(new int[][]{{7}, {8, 8}})) + "    期望 [7, 16]");
    }
}
