public class MathDemo {

    public static void main(String[] args) {

        // ============================================================
        // 0. 你看不懂的原因：这些名字全是【英文缩写】
        // ============================================================
        //    pow   = power        = 幂        = 几次方
        //    sqrt  = square root  = 平方根    = 哪个数自己乘自己等于它
        //    abs   = absolute     = 绝对值    = 去掉负号
        //    round = 四舍五入
        //    PI    = π（圆周率）
        //
        //    —— 名字认出来了，代码就没什么神秘的了。
        // ============================================================


        System.out.println("===== 1. pow：几次方 =====");

        // Math.pow(a, b) = a 的 b 次方 = b 个 a 相乘
        System.out.println("2 的 3 次方  = " + Math.pow(2, 3));    // 2*2*2  = 8
        System.out.println("2 的 10 次方 = " + Math.pow(2, 10));   // 10 个 2 相乘 = 1024
        System.out.println("5 的 2 次方  = " + Math.pow(5, 2));    // 5*5    = 25

        // ★ 为什么是 1024.0 不是 1024？
        //   因为 pow 的返回类型是 double（带小数点的数）
        //   想要整数就得自己转：int x = (int) Math.pow(2, 10);
        int x = (int) Math.pow(2, 10);
        System.out.println("转成 int 之后 = " + x);                // 1024


        System.out.println();
        System.out.println("===== 2. sqrt：平方根 =====");

        // Math.sqrt(a) = 哪个数自己乘自己等于 a
        System.out.println("16 的平方根 = " + Math.sqrt(16));   // 4*4 = 16  → 4
        System.out.println("25 的平方根 = " + Math.sqrt(25));   // 5*5 = 25  → 5
        System.out.println("2  的平方根 = " + Math.sqrt(2));    // 1.4142…（无限不循环）
        System.out.println("10 的平方根 = " + Math.sqrt(10));   // 3.1622…


        System.out.println();
        System.out.println("===== 3. abs：绝对值（去掉负号）=====");

        System.out.println("abs(-5)   = " + Math.abs(-5));      // 5
        System.out.println("abs(5)    = " + Math.abs(5));       // 5
        System.out.println("abs(-3.7) = " + Math.abs(-3.7));    // 3.7


        System.out.println();
        System.out.println("===== 4. max / min =====");

        System.out.println("max(3, 7) = " + Math.max(3, 7));    // 7
        System.out.println("min(3, 7) = " + Math.min(3, 7));    // 3

        // ★ 只能比两个！三个要套着写
        int a = 3, b = 9, c = 5;
        System.out.println("三个数里最大 = " + Math.max(a, Math.max(b, c)));   // 9


        System.out.println();
        System.out.println("===== 5. round / floor / ceil =====");

        System.out.println("round(3.6) = " + Math.round(3.6));   // 4   四舍五入
        System.out.println("round(3.4) = " + Math.round(3.4));   // 3
        System.out.println("floor(3.9) = " + Math.floor(3.9));   // 3.0 向下取整（地板）
        System.out.println("ceil(3.1)  = " + Math.ceil(3.1));    // 4.0 向上取整（天花板）


        System.out.println();
        System.out.println("===== 6. PI：圆周率 =====");

        // ★ 注意：PI 是常量，不是方法 —— 没有括号！
        System.out.println("Math.PI = " + Math.PI);              // 3.141592653589793


        // ============================================================
        // 7. 真正用起来 —— 场景一：判断质数（你 Day12C 写过的题！）
        // ============================================================
        System.out.println();
        System.out.println("===== 7. 场景：判断质数 =====");

        // 你当时写的循环条件是 i < num（试到 num-1）
        // 其实只需要试到 √num —— 这就是 Math.sqrt 最经典的用法
        int num = 97;
        boolean isPrime = true;

        for (int i = 2; i <= Math.sqrt(num); i++) {     // ★ 就是这一行
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(num + " 是质数吗？ " + isPrime);

        // 为什么可以只试到 √97 ？
        //   如果 num = a × b，那么 a 和 b 里【必有一个 ≤ √num】
        //   所以小的那一半试过了，就不用再试大的那一半


        // ============================================================
        // 8. 场景二：两点之间的距离（勾股定理 a² + b² = c²）
        // ============================================================
        System.out.println();
        System.out.println("===== 8. 场景：两点距离 =====");

        int x1 = 0, y1 = 0, x2 = 3, y2 = 4;

        double dist = Math.sqrt(
                           Math.pow(x2 - x1, 2)      // 横着差 3，平方 = 9
                         + Math.pow(y2 - y1, 2)      // 竖着差 4，平方 = 16
                       );                            // √(9+16) = √25 = 5

        System.out.println("(0,0) 到 (3,4) 的距离 = " + dist);   // 5.0


        // ============================================================
        // 9. 场景三：绝对值求距离
        // ============================================================
        System.out.println();
        System.out.println("===== 9. 场景：两个数的距离 =====");

        int p = 3, q = 10;
        System.out.println("3 和 10 相距 " + Math.abs(p - q) + " （不管谁减谁，结果都一样）");
        System.out.println("10 和 3 相距 " + Math.abs(q - p));


        // ============================================================
        // 10. 场景四：圆面积 / 周长
        // ============================================================
        System.out.println();
        System.out.println("===== 10. 场景：圆 =====");

        double r = 2.0;
        System.out.println("半径 2 的圆面积 = " + Math.PI * r * r);        // π r²
        System.out.println("半径 2 的圆周长 = " + 2 * Math.PI * r);       // 2πr


        // ============================================================
        // 11. Random：跟 Math 相反，这个【要 new】
        // ============================================================
        System.out.println();
        System.out.println("===== 11. Random：随机数 =====");

        java.util.Random rnd = new java.util.Random();

        System.out.println("nextInt(6)      = " + rnd.nextInt(6));         // 0~5
        System.out.println("nextInt(6) + 1  = " + (rnd.nextInt(6) + 1));   // 1~6（掷骰子）
        System.out.println("nextInt(100)    = " + rnd.nextInt(100));       // 0~99

        // ★ 为什么是 0~5 而不是 1~6 ？
        //   跟 "hello".substring(0,5) 出 5 个字符是同一个规矩：含头不含尾
    }
}
