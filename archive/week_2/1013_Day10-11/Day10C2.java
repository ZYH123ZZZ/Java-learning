import java.util.Scanner;

public class Day10C2 {
    public static int[] pickDigit(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count++;
            }
        }

        int[] result = new int[count];

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                result[j] = s.charAt(i) - '0';
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串字符：");
        String s = sc.nextLine();
        int[] num = pickDigit(s);
        System.out.println("这串字符有 " + num.length + " 个数字");
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}
