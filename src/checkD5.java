public class checkD5 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 100; i = i + 2) {
            sum = sum + i;
        }
        System.out.println(sum);

        int a = 1;
        int b = 1;
        while (a <= 5) {
            b = b * a;
            a++;
        }
        System.out.println(b);

        int c = 1;
        int d = 1;
        do {
            d = d * c;
            c++;
        } while (c <= 5);
        System.out.println(d);
    }
}
