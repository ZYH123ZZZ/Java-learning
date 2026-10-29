import java.util.Scanner;

public class Day8 {
    public static void sayHello() {
        System.out.println("nihaowoshifangfa");
    }

    public static void printMenu() {
        System.out.println("===== 菜单 =====");
    }

    public static void printname(String name) {
        System.out.println(name);
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        sayHello();
        sayHello();

        int result = add(3, 5);
        System.out.println(result);

        System.out.println(add(10, 20));

        System.out.println("===== 菜单 =====");
        System.out.println("===== 菜单 =====");
        System.out.println("===== 菜单 =====");

        printMenu();
        printMenu();
        printMenu();

        Scanner sc = new Scanner(System.in);

        System.out.println("Please add your name:");

        String name = sc.nextLine();
        printname(name);

        System.out.println("add a number");

        int num = sc.nextInt();
        if (isEven(num)) {
            System.out.println(num + "是偶数");
        } else {
            System.out.println(num + "不是偶数");
        }
    }
}

