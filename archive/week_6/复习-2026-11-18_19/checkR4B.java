// 复习 4 变式 · 冒泡 + 字符串长度（B 档，11-18）
// 目标 15 分钟。闭卷。禁用：Arrays.sort / Comparator / Stream。
import java.util.Arrays;

public class checkR4B {

    // sortByLen(String[] a) —— 原地按「字符串长度」升序冒泡，返回「交换次数」
    //     ① 比较的是长度 a[j].length()，不是字符串本身
    //     ② 长度相同 → 不交换，保持原来的先后（稳定）
    //     ③ 计数：只有真换了才 +1（这题要交换次数，跟 R4 的不一样）
    //
    //     sortByLen(new String[]{"java","io","stream","abc"}) → 返回 3
    //     数组变成 [io, abc, java, stream]
    static int sortByLen(String[] a) {
        int countRun = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j].length() > a[j + 1].length()) {
                    String tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    countRun++;
                }
            }
        }
        // 你写
        return countRun;
    }

    public static void main(String[] args) {
        String[] w = {"java", "io", "stream", "abc"};
        System.out.println(sortByLen(w) + " 次  " + Arrays.toString(w));

        String[] t = {"bb", "aa", "cc"};        // 三个长度都是 2
        System.out.println(sortByLen(t) + " 次  " + Arrays.toString(t));

        String[] e = {};
        System.out.println(sortByLen(e) + " 次  " + Arrays.toString(e));

        String[] s = {"solo"};
        System.out.println(sortByLen(s) + " 次  " + Arrays.toString(s));
    }
}
