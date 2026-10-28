import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Scanner;

public class week1_2 {
    public static int sumScore(Student x) {
        return x.scoreM + x.scoreE + x.scoreC;
    }

    public static String kind(Student x) {
//        switch (sumScore(a,num)) {
//            case >=270 -> {
//
//            }
//        }
        if (sumScore(x) >= 270) {
            return "优秀";
        } else if (sumScore(x) >= 240) {
            return "良好";
        } else if (sumScore(x) >= 180) {
            return "及格";
        } else if (sumScore(x) < 180) {
            return "不及格";
        }
        return "";
    }

    public static double[] avgScore(ArrayList<Student> a) {
        double cSum = 0, mSum = 0, eSum = 0;
        for (Student x : a) {
            cSum += x.scoreC;
            mSum += x.scoreM;
            eSum += x.scoreE;
        }
        double[] d = new double[3];
        d[0] = cSum / a.size();
        d[1] = mSum / a.size();
        d[2] = eSum / a.size();
        return d;
    }

    public static Student maxSum(ArrayList<Student> a) { //又忘记返回类型
        Student best = a.get(0);
        for (Student m : a) {
            if (sumScore(best) < sumScore(m)) {    // 研究一下
                best = m;
            }
        }
        return best;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> a = new ArrayList<>();

        int n = sc.nextInt();//学生人数
        for (int i = 0; i < n; i++) {
            a.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        System.out.println("=== 成绩单 ===");
        for (Student x : a) {
            System.out.printf("%s %s %d %s%n",x.name,"总分",sumScore(x),kind(x));
        }
        System.out.println("=== 等级分布 ===");
        HashMap<String, Integer> h = new HashMap<>();           //这里卡住   原因：上来就乱放遍历
        for (Student s : a) {
            h.put(kind(s), h.getOrDefault(kind(s), 0) + 1);
        }

        for (String x : h.keySet()) {
            System.out.println(x + " " + h.get(x) + " 人");
        }
        System.out.println("=== 各科平均 ===");
        System.out.printf("%s %.2f%n", "语文", avgScore(a)[0]);
        System.out.printf("%s %.2f%n", "数学", avgScore(a)[1]);
        System.out.printf("%s %.2f%n", "英语", avgScore(a)[2]);
        System.out.println("=== 总分最高 === ");
        System.out.println(maxSum(a).name + " " + sumScore(maxSum(a)));   //研究一下
    }
}
