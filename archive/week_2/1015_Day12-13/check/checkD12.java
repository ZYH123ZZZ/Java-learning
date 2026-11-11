public class checkD12 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                System.out.print(i + "*" + j + "=" + (j * i) + " "+ "\t");
            }
            System.out.println();
        }
    }
}
