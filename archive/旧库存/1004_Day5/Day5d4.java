import java.util.Scanner;

public class Day5d4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入一个正整数：");
        int n = sc.nextInt();
        int m = n;
        int t = 0;

        do {
            n = n / 10;
            t++;
        } while (n != 0);
        System.out.println(m + " 有 " + t + " 位");
    }
}
