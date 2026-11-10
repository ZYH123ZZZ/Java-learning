public class checkD8 {
    public static int add(int a, int b) {
        return a + b;
    }

    public static void printLine(String s) {
        System.out.println(s);
        return;
    }

    public static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(add(1,2));
        printLine("akdsjh");
        System.out.println(isEven(5));
    }
}
