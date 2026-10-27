import java.util.HashMap;
import java.util.Scanner;

public class Day19C {

    public static boolean isrepeat(HashMap<Integer, Integer> n2, int[] n1,int n) {
        for (int i = 0; i < n; i++) {
            n2.put(n1[i], n2.getOrDefault(n1[i],0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (n2.get(n1[i]) > 1) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] n1 = new int[n];
        HashMap<Integer, Integer> n2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            n1[i] = sc.nextInt();
        }
        boolean has = isrepeat(n2, n1, n);          //n2在变 调多次要先接住
        System.out.println(has);

        if (has) {
            System.out.println("1");

        }
    }
}

