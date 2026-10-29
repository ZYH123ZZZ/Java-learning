import java.util.Scanner;

public class Day5d3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入一个正整数：");
        int n = sc.nextInt();
        int m = n;

        int t = 0;
        while (n != 0) {

            n = n / 10;
            t = t + 1;
        }
        if (m == 0) {
            System.out.println(m + " 有 " + 1 + " 位");
        } else {
            System.out.println(m + " 有 " + t + " 位");
        }
    }
}