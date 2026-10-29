import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Day9B {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int gcdSlow(int a, int b) {
        int i = 1;
        int ans = 1;
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

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("辗转相除 → " + gcd(a, b));
        System.out.println("约数枚举 → " + gcdSlow(a, b));
    }

}
