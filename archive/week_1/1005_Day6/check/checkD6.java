import java.util.Arrays;

public class checkD6 {
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int[] reversed(int[] arr) {
        int[] rra = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rra[i] = arr[arr.length - 1 - i];
        }
        return rra;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));
        System.out.println(max(arr));
        System.out.println(Arrays.toString(reversed(arr)));
    }
}
