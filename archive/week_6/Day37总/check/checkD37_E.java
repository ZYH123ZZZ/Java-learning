import java.util.*;

public class checkD37_E {

    // ===== 下面这段别改 =====
    // 你自己定义的"区间"接口：一个方法，回答"这个分数在不在区间里"
    interface Bucket {
        boolean in(int n);
    }
    // =======================

    // 只有三个参数、void、自己打印
    static void band(List<Integer> scores, int low, int high) {
        if (scores.isEmpty()) {
            System.out.println("没有成绩");
            return;
        }

        Bucket in = new Bucket() {
            @Override
            public boolean in(int n) {
                return (n >= low && n <= high);
            }
        };
        Bucket out = new Bucket() {//括号忘记了
            @Override
            public boolean in(int n) {
                return (n < low || n > high);
            }
        };

        ArrayList<Integer> inthis = new ArrayList<>();
        ArrayList<Integer> outthis = new ArrayList<>();
        for (int x : scores) {
            if (in.in(x)) {
                inthis.add(x);
            }
            if (out.in(x)) {
                outthis.add(x);
            }
        }

        System.out.println("区间内 " + inthis.size() + " 个: " + inthis);
        System.out.println("区间外 " + outthis.size() + " 个: " + outthis);
        if (inthis.isEmpty()) {
            System.out.println("全部在区间外");
        }
        if (outthis.isEmpty()) {
            System.out.println("全部在区间内");
        }

        // 你写
    }

    static List<Integer> of(int... a) {
        List<Integer> l = new ArrayList<>();
        for (int x : a) l.add(x);
        return l;
    }

    public static void main(String[] args) {
        System.out.println("--- b1 [50,60,70,80,90] 区间 60~80 ---");
        band(of(50, 60, 70, 80, 90), 60, 80);
        System.out.println("--- b2 空 ---");
        band(of(), 60, 80);
        System.out.println("--- b3 [59,81] 区间 60~80 ---");
        band(of(59, 81), 60, 80);
        System.out.println("--- b4 [60,80] 区间 60~80 ---");
        band(of(60, 80), 60, 80);
        System.out.println("--- b5 [70] 区间 70~70 ---");
        band(of(70), 70, 70);
    }
}
