public class Day5d {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i += 1) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }
}
