import java.util.Scanner;

public class Day8C2 {

    public static int countDigits(int n) {
        int count = 0;
        do {
            n = n / 10;
            count++;
        } while (n != 0);
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("请输入第" + (i + 1) + "个数");
            int x = sc.nextInt();
            System.out.println(x + "有" + countDigits(x) + "位");
        }
    }
}
