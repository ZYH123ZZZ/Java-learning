import java.util.Scanner;

public class Drill5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("What s your height");

        double height = sc.nextDouble();

        System.out.print("What s your age:");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("What s your name:");
        String name = sc.nextLine();

        System.out.print("your name is " + name +
                ",and your height is "
                + height + ",also your age is " + age);

    }
}
