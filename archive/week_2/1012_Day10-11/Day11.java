import java.util.Scanner;

public class Day11 {

    public static int countSpace(String sentence) {
        int num1 = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                num1++;
            }
        }
        return num1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "hello world";

        System.out.println(s.substring(0, 5));
        System.out.println(s.indexOf("world"));
        System.out.println(s.toUpperCase());
        System.out.println(s.equals("hello world"));
        System.out.println(s.contains("lo w"));
        System.out.println(s.toLowerCase());

        String src = "abcde";
        String result = "";
        for (int i = src.length() - 1; i >= 0; i--) {
            result = result + src.charAt(i);
        }
        System.out.println(result);


        System.out.println("请输入一句话：");
        String sentence = sc.nextLine();

        System.out.println("一共有" + countSpace(sentence) + "个空格");

    }
}
