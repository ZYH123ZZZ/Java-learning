import java.util.Scanner;

public class Day10B {
    public static boolean isPalindrome(String s) {
        int length = s.length();
        int num = 0;
        for (int i = 0; i < length / 2 && s.charAt(i) == s.charAt(length - i - 1); i++) {
            num++;
        }
        return num == s.length() / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入字符串");
        String s = sc.nextLine();

        if (isPalindrome(s)) {
            System.out.println(s + "是回文");
        } else {
            System.out.println(s + "不是回文");
        }
    }
}

