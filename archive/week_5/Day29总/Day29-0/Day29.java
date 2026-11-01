import java.util.ArrayList;
import java.util.Scanner;

public class Day29 {
    public static <T> void  printAll(ArrayList<T> t) {
        for (T x : t) {
            System.out.println(x);
        }
    }

    public static int sum(int... nums) {
        int sum = 0;
        for (int x : nums) {
            sum = sum + x;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println(sum(a, b, c));

        System.out.println("jadgjasgd");
        int[] d = new int[5];
        for (int i = 0; i < d.length; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println(sum(d));
        ArrayList<String> k = new ArrayList<>();

        k.add("aksdhga");
        k.add("jahdsgdj");
        printAll(k);

        ArrayList<Integer> k1 = new ArrayList<>();
        k1.add(8917263);
        k1.add(2);
        printAll(k1);
    }
}
