import java.util.Scanner;

public class Main3 {
    public static boolean isPrime(int a) {
        if (a < 2) {
            return false;}
        for (int j = 2; j <= Math.sqrt(a); j++) {
            if (a % j == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int count = 0;
        int sum = 0;

        for (int i = 1; i <= L; i++) {
            if (isPrime(i)) {
                sum = sum + i;
                if (sum > L) {
                    sum = sum - i;
                    break;
                }
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }
}

