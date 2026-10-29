import java.util.Scanner;

public class Day3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入你的名字：");
        String name = sc.nextLine();

        System.out.print("请输入你的年龄：");
        int age = sc.nextInt();


        System.out.print("请输入你的身高：");
        double height = sc.nextDouble();

        System.out.println("你好" + name + "，你今年" + age + "岁" +
                "，你身高" + height + "厘米");
    }
}
