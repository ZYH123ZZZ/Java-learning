public class checkR7E {

    // 十进制转二进制字符串。toBinary(10) → "1010"；toBinary(0) → "0"；n 不会是负数
    // 提示：每次除以 2 得到一位，但那一位要接在前面的后面（写反了会得到 "0101"）
    static String toBinary(int n) {

        // 你写
        return "";
    }

    // 把 a 里 lo 到 hi 这一段的和算出来（含 lo 和 hi）
    // 这题不用 i+1 一路走到头，而是从中间劈成两半，两半分别求和再加起来
    // sumHalf(a, 0, a.length - 1) 就是整组的和；空数组会传 lo=0, hi=-1
    static int sumHalf(int[] a, int lo, int hi) {
        if (lo > hi) {
            return 0;
        }
        if (lo == hi) {
            return a[lo];
        } else if (lo + 1 == hi) {
            return a[lo] + a[hi];
        }
        // 你写
        return sumHalf(a, lo + 1, hi - 1) + a[lo] + a[hi];
    }
    public static void main(String[] args) {
        System.out.println(toBinary(10));               // 期望 1010
        System.out.println(toBinary(0));                // 期望 0
        System.out.println(toBinary(1));                // 期望 1
        System.out.println(toBinary(7));                // 期望 111
        System.out.println(toBinary(255));              // 期望 11111111

        System.out.println("---");

        System.out.println(sumHalf(new int[]{3, 8, 2, 9}, 0, 3));           // 期望 22
        System.out.println(sumHalf(new int[]{5}, 0, 0));                    // 期望 5
        System.out.println(sumHalf(new int[]{}, 0, -1));                    // 期望 0
        System.out.println(sumHalf(new int[]{1, 2, 3, 4, 5, 6}, 0, 5));     // 期望 21
    }
}
