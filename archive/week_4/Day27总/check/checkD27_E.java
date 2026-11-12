public class checkD27_E {
    public static int countTarget(int[] arr, int i, int target) {
        if (i < 0 || i >= arr.length) {
            return 0;
        }
        if (i == 0) {
            if (arr[0] == target) {
                return 1;
            }
            return 0;
        }
        if (arr[i] == target) {
            return countTarget(arr, i - 1, target) + 1;
        }
        if (arr[i] != target) {
            return countTarget(arr, i - 1, target);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countTarget(new int[]{3, 9, 3, 7}, 3, 3));
        System.out.println(countTarget(new int[]{3, 9, 3, 7}, 3, 5));
        System.out.println(countTarget(new int[]{}, 0, 3));
        System.out.println(countTarget(new int[]{4, 4, 4}, 2, 4));
        System.out.println(countTarget(new int[]{3, 9}, -1, 3));
        System.out.println(countTarget(new int[]{-1, 0, 0}, 2, 0));
    }
}
