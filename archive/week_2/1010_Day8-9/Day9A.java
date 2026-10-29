import java.util.Scanner;

public class Day9A {
    public static int gcdSlow(int a, int b) {
        int ans = 1;
        int i = 1;
        while (i <= a && i <= b) {
            if (a % i == 0 && b % i == 0) {
                ans = i;
            }
            i++;

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一个数：");
        int a = sc.nextInt();
        System.out.println("请输入第二个数：");
        int b = sc.nextInt();

        System.out.println("最大公约数是" + gcdSlow(a, b));
    }
}
