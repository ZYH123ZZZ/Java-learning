import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day17B2 {
//    ArrayList<Integer> score = new ArrayList<>();

    public static ArrayList<Integer> scoreArr(Scanner sc, int n) {
        ArrayList<Integer> score = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (!score.contains(x)) {
                score.add(x);
            }
        }
        Collections.sort(score);// 还是不熟
        return score;
    }

    public static void main(String[] args) {        //后面还是不知道咋写 和昨天同一个错误
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = scoreArr(sc, n);

        System.out.println(arr.size());
        System.out.println(arr);
//        System.out.println(scoreArr(sc, n).size());
//        System.out.println(scoreArr(sc,n));
        }

    }

