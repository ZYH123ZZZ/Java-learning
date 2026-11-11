import java.util.Scanner;

public class checkD3_B {
    public static void printInfo(String name, int age, double height) {
        System.out.println(name + " " + age + " " + height);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        double height = sc.nextDouble();
        printInfo(name, age, height);
    }
}
