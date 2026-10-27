//public class Day5b {
//    public static void main(String[] args) {
//        int sum = 0;
//        for (int i = 1; i <= 100; i++) {
//            int value = i;
//            if (i % 2 == 0) {
//                value = i;
//            } else {
//                value = 0;
//            }
//            sum = sum + value;
//        }
//        System.out.println(sum);
//    }
//}
//public class Day5b {
//    public static void main(String[] args) {
//        int sum = 0;
//        for (int i = 2; i <= 100; i += 2) {
//            sum = sum + i;
//        }
//        System.out.println(sum);
//    }
//}
//public class Day5b {
//    public static void main(String[] args) {
//        int sum = 0;
//        for (int i = 1; i <= 100; i++) {
//            if (i % 2 == 0) {
//                sum = sum + 1;
//            }
//        }
//        System.out.println(sum);
//    }
//}
//public class Day5b {
//    public static void main(String[] args) {
//        for (int i = 2; i <= 100; i += 2) {
//            System.out.println(i);
//        }
//    }
//}
public class Day5b {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 100; i >= 1; i -= 1) {
            System.out.println(i);
            sum = sum + i;
            System.out.println(sum);
        }
    }
}