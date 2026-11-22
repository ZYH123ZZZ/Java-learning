public class checkR7D {

    // 最大公约数，用辗转相除。gcd(12, 18) → 6
    // 提示：gcd(a, b) 在递归时两个参数会换位置，不是只缩小一个
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 你写
        return gcd(b, a % b);
    }

    // 判断回文。isPal("level") → true；空串和单字符都算回文
    // 只准用 length / charAt / substring，不许 for/while，不许 new StringBuilder(s).reverse()
    static boolean isPal(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        // 你写
        return isPal(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(gcd(12, 18));        // 期望 6
        System.out.println(gcd(100, 75));       // 期望 25
        System.out.println(gcd(7, 13));         // 期望 1
        System.out.println(gcd(9, 9));          // 期望 9
        System.out.println(gcd(9, 0));          // 期望 9

        System.out.println("---");

        System.out.println(isPal("level"));     // 期望 true
        System.out.println(isPal("abc"));       // 期望 false
        System.out.println(isPal(""));          // 期望 true
        System.out.println(isPal("a"));         // 期望 true
        System.out.println(isPal("abca"));      // 期望 false
    }
}
