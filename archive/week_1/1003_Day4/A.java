import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入一个整数：");
        int num = sc.nextInt();

        if (num % 5 == 0) {
            System.out.println(num + "能被5整除");
        } else {
            System.out.println(num + "不能被5整除");
        }
    }
}