// 复习 7-A · 斐波那契（递归出口专项，11-18）
// 目标 10 分钟。闭卷。
// 规矩：不许写 for / while，只能递归。

public class checkR7A {

    // fib(n)：第 n 项。fib(0)=0, fib(1)=1, fib(2)=1, fib(3)=2, fib(4)=3, fib(5)=5
    static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        // 你写
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(0));    // 期望 0
        System.out.println(fib(1));    // 期望 1
        System.out.println(fib(2));    // 期望 1
        System.out.println(fib(5));    // 期望 5
        System.out.println(fib(10));   // 期望 55
    }
}
