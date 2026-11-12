public class checkD27_D {
    public static boolean contains(int[] arr, int i, int target) {
        if (i < 0 || i >= arr.length) {
            return false;
        }
        if (i == 0) {
            return (arr[0] == target);
        }
        if (arr[i] == target) {
            return true;
        }
        return contains(arr, i - 1, target);
    }
    public static void main(String[] args) {
        System.out.println(contains(new int[]{3,9,2,7}, 3, 2));
        System.out.println(contains(new int[]{3, 9, 2, 7}, 3, 5));
        System.out.println(contains(new int[]{}, 0, 5));
        System.out.println(contains(new int[]{4, 4, 4}, 2, 4));
        System.out.println(contains(new int[]{3, 9}, -1, 3));
        System.out.println(contains(new int[]{-1, 0, 5}, 2, 0));
        System.out.println(contains(new int[]{5,6},1,5));
    }
}
