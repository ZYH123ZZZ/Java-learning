public class checkD27_B2 {
    public static int maxOf(int[] arr, int i) {
        if (i == 0) {
            return arr[0];
        }
        return Math.max(arr[i], maxOf(arr, i - 1));
    }

    public static void main(String[] args) {

    }
}
