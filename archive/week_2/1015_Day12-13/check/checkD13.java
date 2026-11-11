import java.util.*;


public class checkD13 {
    public static int[] arrnum(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {//又忘记数组下标和长度的区别了
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a1 = {234, 564, 24, 456, 687, 354};
        Arrays.sort(a1);
        System.out.println(Arrays.toString(a1));
        String[] a3 = {"adsadas", "adsa", "asd", "ssss", "sssss"};
        Arrays.sort(a3);
        System.out.println(Arrays.toString(a3));//为什么没有变？
    }
}

