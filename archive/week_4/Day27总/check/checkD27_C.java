public class checkD27_C {
    public static void printReverse(int[] arr, int i) {
        if (i < 0) {
            return;
        }
        System.out.println(arr[i]);
        printReverse(arr, i - 1);
    }

    public static void main(String[] args) {
        printReverse(new int[]{1, 2, 3}, 2);
    }
}
