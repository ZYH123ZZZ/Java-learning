import java.util.Arrays;

public class checkD9 {
    public static void bubbleSort(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static double avg(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum / (double) arr.length;
    }
    public static void main(String[] args) {
        bubbleSort(new int[]{5, 2, 8, 1});
        System.out.println(avg(new int[]{1, 2, 3, 4}));
    }
}
