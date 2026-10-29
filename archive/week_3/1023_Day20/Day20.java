import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> arr1 = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();

        String[] n = sc.nextLine().split(" ");
        for (String s : n) {
            int x = Integer.parseInt(s);
            arr1.add(x);
            arr.add(x);
        }

        HashSet<Integer> seen = new HashSet<>();
        ArrayList<Integer> unique = new ArrayList<>();
        for (int x : arr) {
            if (!seen.contains(x)) {
                seen.add(x);
                unique.add(x);
            }
        }

        System.out.println(n.length);
        System.out.println(unique);
        boolean has = (arr1.size() != arr.size());
        System.out.println(has);
    }
}
