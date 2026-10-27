import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入两个整数");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int max = a;
        if (b > max) {
            max = b;
        }
        System.out.println(max);
    }
}
