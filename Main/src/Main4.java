import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static double countAvg(int n, int[] b) {
        Arrays.sort(b);
        int sum = 0;
        for (int i = 1; i < b.length - 1; i++) {
            sum = sum + b[i];
        }
        return sum / (double)(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
        }
        System.out.print(countAvg(n, b));
    }
}
