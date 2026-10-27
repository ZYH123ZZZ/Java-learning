import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("你的分数是？：");
        double score = sc.nextDouble();

        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 80) {
            System.out.println("良好");
        } else if (score >= 70) {
            System.out.println("中等");
        } else if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

        System.out.print("请输入第一个数：");
        int count1 = sc.nextInt();

        System.out.print("请输入第二个数：");
        int count2 = sc.nextInt();

        System.out.print("请输入第三个数：");
        int count3 = sc.nextInt();

        int max = count1;
        if (count2 > max) { max = count2; }
        if (count3 > max) {
            max = count3;
        }
        System.out.println("最大的数字是：" + max);

    }
}