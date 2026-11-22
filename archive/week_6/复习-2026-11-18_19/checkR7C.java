public class checkR7C {

    // 反转字符串。rev("hello") → "olleh"；空串返回 ""
    // 只准用 charAt / substring / isEmpty / length，不许 for/while，不许 StringBuilder.reverse
    static String rev(String s) {
        if (s.isEmpty()) {
            return "";
        }
        // 你写
        return s.substring(s.length() - 1) + rev(s.substring(0, s.length() - 1));
    }

    // 各位数字之和。digitSum(123) → 1+2+3 = 6；n 不会是负数
    // 不许 for/while，不许 toString 转字符串
    static int digitSum(int n) {
        if (n == 0) {
            return 0;
        }
        // 你写
        return digitSum(n / 10) + n % 10;
    }

    public static void main(String[] args) {
        System.out.println("[" + rev("hello") + "]");   // 期望 [olleh]
        System.out.println("[" + rev("abc") + "]");     // 期望 [cba]
        System.out.println("[" + rev("") + "]");        // 期望 []
        System.out.println("[" + rev("a") + "]");       // 期望 [a]

        System.out.println(digitSum(123));              // 期望 6
        System.out.println(digitSum(0));                // 期望 0
        System.out.println(digitSum(7));                // 期望 7
        System.out.println(digitSum(1000));             // 期望 1
    }
}
