import java.util.Scanner;

public class Day5d2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入一个整数：");
        int n = sc.nextInt();
        boolean isPrime = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                isPrime = false;
            }
        }
        if (isPrime == true) {
            System.out.println(n + " 是素数");
        } else {
            System.out.println(n + " 不是素数");
        }
    }
}
