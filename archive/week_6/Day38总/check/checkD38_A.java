import java.util.*;

public class checkD38_A {

    // ===== 下面别改 =====
    interface Check {
        boolean pass(int n);
    }

    static int countIf(List<Integer> l, Check c) {
        int n = 0;
        for (int x : l) if (c.pass(x)) n++;
        return n;
    }
    // ===================

    // 你只写这个：两个参数、void、自己打印
    static void report(List<Integer> scores, int line) {
        if (scores.isEmpty()) {
            System.out.println("没有成绩");
            return;
        }

        Check passTo = n -> n >= line;
        Check failTo = n -> n < line;

        System.out.println("及格 " + countIf(scores, passTo) + " 个");
        System.out.println("不及格 " + countIf(scores, failTo) + " 个");
        System.out.println("共 " + (countIf(scores, passTo) + countIf(scores, failTo)) + " 个");
        // 你写
    }

    static List<Integer> of(int... a) {
        List<Integer> l = new ArrayList<>();
        for (int x : a) l.add(x);
        return l;
    }

    public static void main(String[] args) {
        System.out.println("--- d1 [90,45,60,58,60] line=60 ---");
        report(of(90, 45, 60, 58, 60), 60);
        System.out.println("--- d2 空 ---");
        report(of(), 60);
        System.out.println("--- d3 [60] line=60 ---");
        report(of(60), 60);
        System.out.println("--- d4 [59,58] line=60 ---");
        report(of(59, 58), 60);
        System.out.println("--- d5 [0,100] line=0 ---");
        report(of(0, 100), 0);
    }
}
