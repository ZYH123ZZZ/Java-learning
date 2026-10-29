import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day18C {
    public static void arr(ArrayList<Integer> arr1) {
        boolean first = true;
        for (int x : arr1) {
            if (!first) {
                System.out.print(" ");
            }
            System.out.print(x * 2);
            first = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr1 = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr1.add(sc.nextInt());
        }
        arr(arr1);
    }
}
