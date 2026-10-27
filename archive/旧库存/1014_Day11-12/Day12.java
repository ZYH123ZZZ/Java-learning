public class Day12 {
    public static void main(String[] args) {
//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print("*");
//                System.out.print("i=" + i + " j=" + j);
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//
//        for (int i = 1; i <= 9; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(j + "x" + i  + "=" + (i * j) + "\t");
//            }
//            System.out.println();
//        }

        for (int i = 5; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
