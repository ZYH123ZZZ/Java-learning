import java.util.Scanner;

public class B3b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入年份：");
        int year = sc.nextInt();

        if (year % 400 == 0) {
            System.out.println(year + "是闰年");
        } else if (year % 4 == 0) {
            System.out.println(year + "是闰年");
        } else if (year % 100 == 0) {
            System.out.println(year + "不是闰年");
        } else {
            System.out.println(year + "不是闰年");
        }
    }
}