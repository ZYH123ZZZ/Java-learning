import java.util.Scanner;

public class Day7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入五个成绩:");

        int[] score = new int[5];
        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            score[i] = sc.nextInt();
            sum = sum + score[i];
        }
        double ave = sum / (double)score.length;
        System.out.println("总分: " + sum);
        System.out.println("平均分: " + ave);

        int max = score[0];
        int min = score[0];
        for (int i = 0; i < score.length; i++) {
            if (score[i] > max) {
                max = score[i];
            }
            if (score[i] < min) {
                min = score[i];
            }
        }
        System.out.println("最高分： " + max);
        System.out.println("最低分： " + min);
    }
}
