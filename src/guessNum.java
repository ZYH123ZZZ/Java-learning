import java.util.Scanner;

public class guessNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = 89;
        System.out.println("请猜数字 范围0~100");
        while (true) {
            int num1 = sc.nextInt();
            if (num == num1) {
                System.out.println("猜对了！");
                break;
            }
            System.out.println("数字不正确");
        }
    }
}
