import java.util.Scanner;

public class Day7A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你的成绩：");
        int[] scores = new int[5];

        int ave = 0;
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            scores[i] = sc.nextInt();
            sum = sum + scores[i];
        }
        ave = sum / scores.length;

        int max = scores[0];
        int min = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        System.out.println("最高分和最低分分别是：" + max + " " + min);
        System.out.println("平均分和总分分别是 " + ave + " " + sum);

    }
}
