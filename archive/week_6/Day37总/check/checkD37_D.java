import java.util.*;

public class checkD37_D {

    // ===== 下面这段别改 =====
    // 你自己定义的"规则"接口：一个方法，回答"这个分数算不算"
    interface Rule {
        boolean ok(int n);
    }
    // =======================

    // 只有三个参数、void、自己打印
    static void grade(List<Integer> scores, int pass) {
        if (scores.isEmpty()) {
            System.out.println("没有成绩");
            return;
        }

        Rule passTo = new Rule() {
            @Override
            public boolean ok(int n) {
                if (n >= pass) {
                    return true;
                }
                return false;
            }
        };
        Rule failTo = new Rule() {
            @Override
            public boolean ok(int n) {
                if (n < pass) {
                    return true;
                }
                return false;
            }
        };

        List<Integer> passto = new ArrayList<>();
        List<Integer> failto = new ArrayList<>();
        for (int x : scores) {
            if (passTo.ok(x)) {
                passto.add(x);
            }
            if (failTo.ok(x)) {
                failto.add(x);
            }
        }
        System.out.println("合格 " + passto.size() + " 个: " + passto);
        System.out.println("不合格 " + failto.size() + " 个: " + failto);
        if (failto.isEmpty()) {
            System.out.println("全部合格");
        }
        if (passto.isEmpty()) {
            System.out.println("全部不合格");
        }

        // 你写
    }

    static List<Integer> of(int... a) {
        List<Integer> l = new ArrayList<>();
        for (int x : a) l.add(x);
        return l;
    }

    public static void main(String[] args) {
        System.out.println("--- s1 [90,45,60,58,60] pass=60 ---");
        grade(of(90, 45, 60, 58, 60), 60);
        System.out.println("--- s2 空 ---");
        grade(of(), 60);
        System.out.println("--- s3 [59,58] pass=60 ---");
        grade(of(59, 58), 60);
        System.out.println("--- s4 [100] pass=60 ---");
        grade(of(100), 60);
        System.out.println("--- s5 [60,0] pass=0 ---");
        grade(of(60, 0), 0);
    }
}
