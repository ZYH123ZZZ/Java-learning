public class Day27B {
    public static int rev(int n, int acc) {
        if (n == 0) {
            return acc;                    // ① 没数字了，交什么？
        }
        return rev(n / 10, acc * 10 + (n % 10)); //不会  //刚开始没有意识到n管生不管养 要用acc加        // ② 两个参数分别给什么？
    }

    public static void main(String[] args) {
        System.out.println(rev(1234, 0));    // 期望 4321
        System.out.println(rev(7, 0));       // 期望 7
        System.out.println(rev(10000, 0));   // 期望 1
        System.out.println(rev(0, 0));       // 期望 0
    }
}