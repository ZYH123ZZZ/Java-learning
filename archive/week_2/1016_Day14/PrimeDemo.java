public class PrimeDemo {

    /** 判断 num 是不是质数 */
    public static boolean isPrime(int num) {

        // 0 和 1 不是质数（前置守卫，你在 Day11A2 学过）
        if (num < 2) {
            return false;
        }

        // ★ 只试到 √num 就够了
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {         // 找到一个因数
                return false;           // 立刻否定
            }
        }

        return true;                    // 一个因数都没找到 → 是质数
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 9, 17, 25, 97, 100};

        System.out.println("===== 判断这些数是不是质数 =====");

        for (int k = 0; k < nums.length; k++) {

            int num = nums[k];

            if (isPrime(num)) {
                System.out.println(num + " 是质数");
            } else {
                System.out.println(num + " 不是质数");
            }
        }

        // ============================================================
        // 下面是"为什么会这样" —— 手把手看 97 那一趟
        // ============================================================
        System.out.println();
        System.out.println("===== 97 那一趟，i 到底走到哪 =====");
        System.out.println();

        int num = 97;
        System.out.println("Math.sqrt(97) = " + Math.sqrt(97));
        System.out.println("所以循环条件 i <= Math.sqrt(97) 就是 i <= 9.848857…");
        System.out.println();

        for (int i = 2; i <= Math.sqrt(num); i++) {
            System.out.println("i = " + i + "    97 % " + i + " = " + (97 % i) + "    （不是 0，继续）");
        }

        System.out.println("i = 10   10 <= 9.848？不成立 → 循环结束");
        System.out.println();
        System.out.println("一个因数都没找到 → 97 是质数");

        System.out.println();
        System.out.println("===== 对比：老的写法 i < 97 会走多少趟 =====");
        System.out.println("i 从 2 一直走到 96，一共 95 趟");
        System.out.println("新写法只走了 8 趟（i = 2,3,4,5,6,7,8,9）");

        // 实际数一遍给他看
        int oldTimes = 0;
        for (int i = 2; i < num; i++) {
            oldTimes++;
        }
        int newTimes = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            newTimes++;
        }
        System.out.println();
        System.out.println("实际数出来：老写法 " + oldTimes + " 趟，新写法 " + newTimes + " 趟");
    }
}
