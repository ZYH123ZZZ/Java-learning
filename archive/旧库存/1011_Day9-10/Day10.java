import java.util.Scanner;

public class Day10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "hello";

        System.out.println(s.length());
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(4));

        for (int i = 0; i < s.length(); i++) {
            System.out.println("第 " + (i + 1) + " 个字符是" + s.charAt(i));
        }
        System.out.println("请输入字符串：");
        String t1 = sc.nextLine();

        System.out.println("这个字符串有 " + t1.length() + " 个字符");
        for (int i = t1.length() - 1; i >= 0; i--) {
            System.out.println("第 " + (i + 1) + " 个字符是" + t1.charAt(i));
        }
        int num = 0;
        for (int i = 0; i < t1.length(); i++) {

            if (t1.charAt(i) == 'a') {
                num++;
            }
        }
        System.out.println("字符串里面有 " + num + " 个字母a");
    }
}
