public class Day5 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum = sum + i;
        }
        System.out.println("1 到 100 的和是 " + sum);

        int j = 1;
        while (j <= 5) {
            System.out.println("while:" + j);
            j++;
        }
    }
}
