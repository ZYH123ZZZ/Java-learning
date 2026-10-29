public class ForWhileDemo {

    public static void main(String[] args) {

        int n = 5;

        // ================= 写法一：for =================
        System.out.println("--- for 写法 ---");
        for (int i = 0; i < n; i++) {
            System.out.println("第 " + i + " 圈");
        }

        // ================= 写法二：等价的 while（一模一样的结果）=================
        System.out.println();
        System.out.println("--- while 写法（结果跟上面完全一样）---");
        int i = 0;                  // ① 初始化槽  -> 搬到 while 前面
        while (i < n) {             // ② 条件槽    -> 搬进括号
            System.out.println("第 " + i + " 圈");
            i++;                    // ③ 推进槽    -> 搬到末尾（漏了就是死循环）
        }

        // ================= 写法三：不知道要转几圈的 while =================
        System.out.println();
        System.out.println("--- 不知道要转几圈：累加，超过 10 就停 ---");
        int[] arr = {3, 5, 2, 8, 4};
        int sum = 0;
        int k = 0;

        while (k < arr.length && sum < 10) {   // ← 两个条件：还没走完 而且 还没到 10
            sum = sum + arr[k];
            System.out.println("加上 " + arr[k] + "  ->  sum = " + sum);
            k++;
        }
        System.out.println("停了。最终 sum = " + sum);
    }
}
