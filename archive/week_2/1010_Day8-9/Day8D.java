import java.util.Scanner;

public class Day8D {
    public static void printMenu() {
        System.out.println("====== 迷你工具箱 =====");
        System.out.println("1.求1~n 的和");
        System.out.println("2.判断一个数是不是偶数");
        System.out.println("0.退出");
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }


    public static int sumTo(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total = total + i;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            printMenu();
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("请输入n：");
                int n = sc.nextInt();
                System.out.println("1~" + n + " 的和是" + sumTo(n));
            } else if (choice == 2) {
                System.out.println("请输入数字：");
                int x = sc.nextInt();
                if (isEven(x)) {
                    System.out.println(x + "是偶数");
                } else {
                    System.out.println(x + "不是偶数");
                }
            } else if (choice == 0) {
                System.out.println("byebye");
            } else {
                System.out.println("错误的数字");
            }
        } while (choice != 0);
    }
}
