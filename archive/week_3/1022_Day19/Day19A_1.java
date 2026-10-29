//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Day19A_1 {
//    public static void main(String[] args) {
//        ArrayList<String> arr = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        HashMap<String, Integer> hash = new HashMap<>();
//        String[] ar1 = sc.nextLine().split(" ");
//        for (int i = 0; i < ar1.length; i++) {            //这里不熟悉
//            hash.put(ar1[i], hash.getOrDefault(ar1[i], 0) + 1);
//            arr.add(ar1[i]);
//        }
//        int best = hash.get(ar1[0]);
//        for (int i = 0; i < ar1.length; i++) {
//            for (int j = i; j < ar1.length; j++) {
//                if (best < hash.get(ar1[i])) {
//                    int tmp = hash.get(ar1[i]);
//                    hash.put(ar1[i], best);          //要变量
//                    best = tmp;
//                }
//            }
//        }
//        for (String key : hash.keySet()) {
//            System.out.println(key + " " + hash.get(key));
//        }
//
//    }
//}
