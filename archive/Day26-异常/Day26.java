import java.util.InputMismatchException;
import java.util.Scanner;

public class Day26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                int n = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("请输入数字");
                System.out.println(e.getClass().getSimpleName());
                sc.nextLine();
            }
        }
    }
}
