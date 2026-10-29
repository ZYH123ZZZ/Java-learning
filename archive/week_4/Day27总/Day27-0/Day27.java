import java.util.Scanner;

public class Day27 {
    public static int num(int n) {//位数
        if (n / 10 == 0) {//设置下限
            return 1;
        }
        return num(n / 10) + 1;//递归循环
    }

    public static void print(int n) {
        System.out.print(n - ((n / 10) * 10));//打印 我自己想的第一办法
        System.out.print(n % 10);//第二方法 看了你让用%想起来的
        if (n / 10 == 0) {//设置下限
            return;
        }
        System.out.print(" ");//空格 第一最后都没有
        print(n / 10);//循环
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println("位数: " + num(n));
        print(n);
    }
}
