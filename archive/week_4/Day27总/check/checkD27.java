public class checkD27 {
    public static int fact(int n) {
        if (n <= 0) {
            return 1;
        }
        return fact(n - 1) * n;
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int sum(int[] arr, int i) {
        if (i < 0 || i >= arr.length) {//要考虑所有情况
            return 0;//要考虑空数组的情况
        }
        return sum(arr, i - 1) + arr[i];
    }
    public static void main(String[] args) {
        System.out.println(fact(5));
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sum(arr,4));
    }
}
