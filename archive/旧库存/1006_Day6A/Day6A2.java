import java.util.Scanner;

public class Day6A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.println("请输入五个整数：");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("请输入要查找的数：");
        int a = sc.nextInt();

        boolean found = false;
        int pos = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                found = true;
                pos = i + 1;
                break;
            }
        }

        if (found == true) {
            System.out.println(a + "是第 " + pos + " 个数");
        } else {
            System.out.println(a + "没有找到");
        }
    }
}
