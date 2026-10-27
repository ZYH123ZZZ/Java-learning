import java.util.ArrayList;
import java.util.Scanner;

public class Day18B {
    public static int findMax(int n,int[] a) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(a[i]);
        }
        int max = arr.get(0);
        for (int x : arr) {
            if (max < x) {
                max = x;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(findMax(n,a));
    }
}
