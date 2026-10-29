import java.util.Scanner;

public class Drill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("你的年龄是；");
        int age = sc.nextInt();

        System.out.print("你的身高是：");
        double height = sc.nextDouble();

        sc.nextLine();

        System.out.print("你的名字是：");
        String name = sc.nextLine();

        boolean isStudent = age >= 17;

        System.out.print("身高是" + height + "，年龄是" + age + "，名字是"
                + name + "，是大学生吗？" + isStudent);


    }
}