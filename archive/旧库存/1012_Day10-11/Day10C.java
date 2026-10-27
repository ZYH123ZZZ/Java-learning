import java.util.Scanner;

public class Day10C {
    public static int[] pickDigits(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i)<= '9') {
                count++;
            }
        }
        int[] result = new int[count];

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i)<= '9') {
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

        System.out.println("数字个数 : " + pickDigits(s).length);

        int[] result = pickDigits(s);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

        }
    }

}
