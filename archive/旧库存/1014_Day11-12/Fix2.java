import java.util.Scanner;

public class Fix2 {
    public static double BMI(double height, double weight) {
        return weight / (height * height);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入身高哦： ");
        double height = sc.nextDouble();
        System.out.print("请输入体重哦： ");
        double weight = sc.nextDouble();

        System.out.println("BMI: " + BMI(height,weight));
    }
}
