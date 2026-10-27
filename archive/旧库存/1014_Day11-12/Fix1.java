import java.util.Scanner;

public class Fix1 {
    public static double C(double r) {
        return Math.PI * r * 2;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double r = sc.nextDouble();

        System.out.println(C(r));
    }
}