import java.util.*;

public class checkD13 {
    public static void selectionsSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //不会
        }
    }
    public static void main(String[] args) {
        int[] a1 = {234, 564, 24, 456, 687, 354};
        Arrays.sort(a1);
        System.out.println(Arrays.toString(a1));
        String[] a2 = {"adsadas", "adsa", "asd", "ssss", "sssss"};
        HashMap<Integer, String> hm1 = new HashMap<>();
        int n1 = a2.length;
        int[] a2l = new int[n1];
        for (int i = 0; i < n1; i++) {
            hm1.put(a2[i].length(), a2[i]);
            a2l[i] = a2[i].length();
        }
        Arrays.sort(a2l);
        for (int i = 0; i < n1; i++) {
            System.out.print(hm1.get(a2l[i]) + " ");
        }
        String[] a3 = {"adsadas", "adsa", "asd", "ssss", "sssss"};
        Arrays.sort(a3);
        System.out.println(Arrays.toString(a3));//为什么没有变？
    }
}
