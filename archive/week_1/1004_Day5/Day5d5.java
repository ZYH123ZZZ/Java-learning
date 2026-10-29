import java.util.Scanner;

public class Day5d5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入若干个整数（输入 0 结束）：");

        int max = 0;
        int n = sc.nextInt();
        while (n != 0) {
            if (n > max) {
                max = n;
            }
            n = sc.nextInt();
        }
        System.out.println(max);
    }
}
 