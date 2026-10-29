import java.util.IllformedLocaleException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Day26C {
    public static boolean isInfo(int cash) {
        if (cash <= 0) {
            throw new RuntimeException("取款金额必须大于0");
        }
        if (cash > 1000) {
            throw new RuntimeException("余额不足");
        }
//        if (!(cash instanceof Integer)) {
//            throw new RuntimeException("只能输入数字");
//        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cash;
        while (true) {
            try {
                cash = sc.nextInt();
                isInfo(cash);
                break;
            } catch (InputMismatchException e) {
                System.out.println("只能输入数字");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        System.out.printf("%s %d%n","取钱成功！已取",cash);
    }
}

