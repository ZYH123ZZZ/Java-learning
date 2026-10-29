class Day9 {
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static double average(int[] arr) {
        return sumArray(arr) / (double) arr.length;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int countPass(int[] arr) {
        int people = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 60) {
                people = people + 1;
            }
        }
        return people;
    }

    public static void main(String[] args) {
        int[] arr = {88, 92, 75, 100, 61};
        System.out.println("总分：" + sumArray(arr));
        System.out.println("平均分：" + average(arr));
        System.out.println("最高分：" + findMax(arr));
        System.out.println("最低分：" + findMin(arr));
        System.out.println("及格人数：" + countPass(arr));
    }

}
