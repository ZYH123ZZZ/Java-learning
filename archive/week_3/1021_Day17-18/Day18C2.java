import java.util.Arrays;
import java.util.Scanner;

public class Day18C2 {
    public static void arr(int[] arr1) {
        for (int x : arr1) {
            System.out.print(x * 2 + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        arr(arr1);
    }
}
