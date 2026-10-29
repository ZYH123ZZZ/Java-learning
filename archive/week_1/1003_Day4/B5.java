import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入 1~7：");
        int num = sc.nextInt();

        if (num == 1) {
            System.out.println("星期一");
        } else if (num == 2) {
            System.out.println("星期二");
        } else if (num == 3) {
            System.out.println("星期三");
        } else if (num == 4) {
            System.out.println("星期四");
        } else if (num == 5) {
            System.out.println("星期五");
        } else if (num == 6) {
            System.out.println("星期六");
        } else if (num == 7) {
            System.out.println("星期天");
        } else {
            System.out.println("不存在的日子");
        }
    }
}
