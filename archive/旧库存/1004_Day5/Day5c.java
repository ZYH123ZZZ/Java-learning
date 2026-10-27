import java.util.Scanner;

public class Day5c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入n:");
        int num = sc.nextInt();
        int sum = 1;

        for (int i = 1; i <= num; i += 1){
            sum = sum * i;
        }
        System.out.println("n! =" + sum);
    }
}
