public class checkD27_B {
    public static int maxOf(int[] arr, int i) {
        if (i == 0) {
            return arr[0];//这里提交值不太会
        }
        int front = maxOf(arr, i - 1);
        if (arr[i] > front) {
            return arr[i];
        }
        return front;
    }
    public static void main(String[] args) {
        System.out.println(maxOf(new int[]{3, 9, 2, 7}, 3));
    }
}
