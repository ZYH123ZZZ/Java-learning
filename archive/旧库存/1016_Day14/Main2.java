import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int[] C1 = new int[3];
            C1[0] = a;
            C1[1] = b;
            C1[2] = c;
            Arrays.sort(C1);

            int a1 = C1[0];
            int b1 = C1[1];
            int c1 = C1[2];

            if (a + b > c && a + c > b && b + c > a) {
                if (a1 * a1 + b1 * b1 == c1 * c1) {
                    System.out.println("Right triangle");
                }
                if (a1 * a1 + b1 * b1 > c1 * c1) {
                    System.out.println("Acute triangle");
                }
                if (a1 * a1 + b1 * b1 < c1 * c1) {
                    System.out.println("Obtuse triangle");
                }
                if (a == b || a == c || b == c) {
                    System.out.println("Isosceles triangle");
                }
                if (a == b && b == c && c == a) {
                    System.out.println("Equilateral triangle");
                }
            } else {
                System.out.println("Not triangle");
            }
        }
    }

