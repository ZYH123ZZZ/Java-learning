import java.util.Arrays;
import java.util.Scanner;

public class Day14 {
    public static String scoreArr(int[] score) {             //String 又忘记了
        Arrays.sort(score);
        return Arrays.toString(score);
    }

    public static int sumScore(int[] score1) {
        int sum = 0;
        for (int i = 0; i < score1.length; i++) {
            sum = sum + score1[i];
        }
        return sum;
    }

    public static int scoreMax(int[] score2) {
        int max = score2[0];
        for (int i = 0; i < score2.length; i++) {
            if (max < score2[i]) {
                max = score2[i];
            }
        }
        return max;
    }

    public static int scoreMin(int[] score3) {
        int min = score3[0];
        for (int i = 0; i < score3.length; i++) {
            if (min > score3[i]) {
                min = score3[i];
            }
        }
        return min;
    }

    public static double scoreAvg(int[] score4) {
        return sumScore(score4) / score4.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] score = new int[5];
        System.out.println("请输入五个成绩： ");
        for (int i = 0; i < score.length; i++) {
            score[i] = sc.nextInt();
        }

        System.out.println("排序后： " + scoreArr(score));
        System.out.println("总分： " + sumScore(score));
        System.out.println("平均分： " + scoreAvg(score));
        System.out.println("最高分： " + scoreMax(score));
        System.out.println("最低分： " + scoreMin(score));
    }                                                   //括号里是score 方法里例如score3就被替换为score了
}
