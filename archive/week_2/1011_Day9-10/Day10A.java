import java.util.Scanner;

public class Day10A {
    public static boolean isTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
        }

    public static String triangleType(int a, int b, int c) {
        if (a == b && a == c && b == c) {
            return "等边三角形";
        } else if (a == b || a == c || b == c) {
            return "等腰三角形";
        } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
            return "直角三角形";
        } else {
            return "普通三角形";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入三条边:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (isTriangle(a, b, c)) {
            System.out.println("这个三角形是" + triangleType(a, b, c));
        } else {
            System.out.println("不是三角形");
        }
    }

    }

