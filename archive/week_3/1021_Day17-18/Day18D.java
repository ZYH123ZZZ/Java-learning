import java.util.Scanner;

public class Day18D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Dogsort s1 = new Dogsort(sc.next(), sc.nextInt());
        System.out.println(s1.sort + " " + s1.age);
    }
}
