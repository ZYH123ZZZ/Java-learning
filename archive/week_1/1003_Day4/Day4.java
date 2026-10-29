import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入一个整数：");
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println(n + "是偶数。");
        } else {
            System.out.println(n + "是奇数。");
        }

        if (n > 0) {
            System.out.println(n + "是正数。");
        } else if (n < 0) {
            System.out.println(n + "是负数。");
        } else {
            System.out.println("它就是0.");
        }

        if (n % 3 == 0) {
            System.out.println(n + "能被3整除。");
        } else {
            System.out.println(n + "不能被3整除");
        }
    }


}
