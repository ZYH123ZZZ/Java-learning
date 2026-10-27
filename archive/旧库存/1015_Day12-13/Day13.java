import java.util.Arrays;                        // 和Scanner同一个道理

public class Day13 {
    public static void main(String[] args) {

        int[] arr = {5, 2, 9, 7, 1};

        Arrays.sort(arr);                       //排序
        System.out.println(Arrays.toString(arr));      //输出需要toString（转化为字符串）


        String[] names = {"banana", "apple", "cherry"};
        Arrays.sort(names);

        System.out.println(Arrays.toString(names));


        //手写麻烦排序
        int[] arr1 = {5, 2, 9, 1, 7};
        for (int i = 0; i < arr1.length; i++) {      //这里的i不做实质纸面上的计算 仅作为多次循环的工具
            for (int j = 0; j < arr1.length - 1 - i; j++) {
                if (arr1[j] < arr1[j + 1]) {
                    int tmp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr1));   //Arrays是一个可调用工具 .toString实际上是进行了一次只读输出
    }
}
