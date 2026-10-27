import java.util.ArrayList;
import java.util.Scanner;

public class Day18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] word = sc.nextLine().split(" ");
        ArrayList<String> wd = new ArrayList<>();

        int max = word[0].length();
        int maxi = 0;
        for (int i = 0; i < word.length; i++) {
            if (max < word[i].length()) {
                max = word[i].length();
                maxi = i;
            }
            wd.add(word[i]);
        }

        System.out.println(wd.size());
        boolean first = true;
        for (String x : wd) {
            if (!first) {
                System.out.print(" / ");
            }
            System.out.print(x);
            first = false;
        }
        System.out.println();
        System.out.println(word[maxi]);
    }
}
