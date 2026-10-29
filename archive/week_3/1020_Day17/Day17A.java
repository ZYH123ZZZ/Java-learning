import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day17A {
    public static int scoreSum(ArrayList<Integer> score) {
        int sum = 0;
        for (int i = 0; i < score.size(); i++) {
            sum = sum + score.get(i);
        }
        return sum;
    }

    public static double scoreAvg(ArrayList<Integer> score) {
        return scoreSum(score) / (double)score.size();
    }

    public static int scoreMax(ArrayList<Integer> score) {
        int max = score.get(0);
        for (int i = 0; i < score.size(); i++) {
            if (max < score.get(i)) {
                max = score.get(i);
            }
        }
        return max;
    }

    public static int scoreMin(ArrayList<Integer> score) {

        int min = score.get(0);
        for (int i = 0; i < score.size(); i++) {
            if (min > score.get(i)) {
                min = score.get(i);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> score = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            score.add(sc.nextInt());
        }
        Collections.sort(score);
        System.out.println(score);
        System.out.println(scoreSum(score));
        System.out.printf("%.1f%n",scoreAvg(score));
        System.out.println(scoreMax(score));
        System.out.println(scoreMin(score));
    }
}
