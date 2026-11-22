// 复习 4 · 冒泡排序（待复习清单第 4 条，B 档，11-18）
// 目标 15 分钟。闭卷。禁用：Arrays.sort（这题就是考手写冒泡）。
import java.util.Arrays;

public class checkR4 {

    // 【1】bubble(int[] a) —— 原地升序冒泡，返回「比较次数」
    //     每执行一次 b[j] > b[j+1] 的比较，计数 +1（不管有没有交换）
    //     骨架照教材 E:\dsh\java\第二周练习.md:403
    //
    //     bubble(new int[]{5,3,8,1}) → 返回 6，数组变成 [1, 3, 5, 8]
    static int bubble(int[] a) {
        int countRun = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j + 1] < a[j]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
                countRun++;
            }
        }
        // 你写
        return countRun;
    }

    // 【2】bubbleDesc(int[] a) —— 原地降序冒泡，返回「比较次数」
    //     跟上面只差一个符号（教材 :431「把冒泡排序改成从大到小，只改一个符号」）
    //
    //     bubbleDesc(new int[]{5,3,8,1}) → 返回 6，数组变成 [8, 5, 3, 1]
    static int bubbleDesc(int[] a) {
        int countRun = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j + 1] > a[j]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
                countRun++;
            }
        }
        // 你写
        return countRun;
    }

    public static void main(String[] args) {
        int[] x = {5, 3, 8, 1};
        System.out.println(bubble(x) + " 次  " + Arrays.toString(x));

        int[] y = {5, 3, 8, 1};
        System.out.println(bubbleDesc(y) + " 次  " + Arrays.toString(y));

        int[] e = {};
        System.out.println(bubble(e) + " 次  " + Arrays.toString(e));

        int[] s = {7};
        System.out.println(bubble(s) + " 次  " + Arrays.toString(s));
    }
}
