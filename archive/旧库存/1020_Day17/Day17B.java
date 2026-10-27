import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day17B {
    public static ArrayList<Integer> scoreArray(Scanner sc,int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (!arr.contains(x)) {
                arr.add(x);
            }
        }
        Collections.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = scoreArray(sc, n);

        System.out.println(arr.size());
        System.out.println(arr);
    }
}
