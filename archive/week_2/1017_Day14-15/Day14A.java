import java.util.Arrays;
import java.util.Scanner;

public class Day14A {
    public static String countArray(int[] count) {
        Arrays.sort(count);
        return Arrays.toString(count);
    }

    public static int countSum(int[] count) {
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum = sum + count[i];
        }
        return sum;
    }

    public static int countMax(int[] count) {
        int max = count[0];
        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }
        return max;
    }

    public static int countMin(int[] count) {
        int min = count[0];
        for (int i = 0; i < count.length; i++) {
            if (min > count[i]) {
                min = count[i];
            }
        }
        return min;
    }

    public static double countAvg(int[] count) {
        return countSum(count) / (double)count.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] count = new int[5];


        for (int i = 0; i < count.length; i++) {
            count[i] = sc.nextInt();
        }
        System.out.println(countArray(count));
        System.out.println(countSum(count));
        System.out.println(countMax(count));
        System.out.println(countMin(count));
        System.out.println(countAvg(count));
    }
}
