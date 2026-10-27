import java.util.Arrays;
import java.util.Scanner;

public class Day13A {
    public static String sortTostring(int[] a) {
        Arrays.sort(a);
        return Arrays.toString(a);     //这是转化成字符串输出了 所以要用String类别
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入五个数： ");       //读入5个数
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(sortTostring(a));
        System.out.println("最大： " + a[a.length - 1]);
        System.out.println("最小： " + a[0]);     //这俩必须放输出过sortTostring的后面

        int[] b = new int[5];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[4 - i];
            System.out.print(b[i] + " ");
        }

        System.out.println();
        //不排序打擂台
        int max = a[0];
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
            if (min > a[i]) {
                min = a[i];
            }
        }
        System.out.println(max + " " + min);
    }
}
