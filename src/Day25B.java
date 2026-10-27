import java.util.ArrayList;
import java.util.HashMap;

public class Day25B {
    public static double salarySum(ArrayList<Employee> a) {
        double sum = 0;
        for (Employee x : a) {
            sum = sum + x.salary();
        }
        return sum;//我在测试时GIT
    }

    public static double bonusSum(ArrayList<Employee> a) {
        double sum = 0;
        for (Employee x : a) {
            if (x instanceof Bonus) {
                Bonus b = (Bonus) x;
                sum = sum + b.getBonus();
            }
        }
        return sum;
    }

    public static double Sum(ArrayList<Employee> a) {
        return salarySum(a) + bonusSum(a);
    }

    public static void main(String[] args) {
        ArrayList<Employee> a = new ArrayList<>();
        a.add(new Worker("张三"));
        a.add(new Worker("孙七"));
        a.add(new Clerk("周八"));
        a.add(new Manager("李四"));
        a.add(new Manager("王五"));
        a.add(new Director("赵六"));

        System.out.println("=== 工资单 ===");
        for (Employee x : a) {
            System.out.printf("%s  %s  %.2f%n",x.name,x.kind(),x.salary());
        }
        System.out.println("=== 分类人数 ===");
        HashMap<String, Integer> h = new HashMap<>();
        for (Employee x : a) {
            h.put(x.kind(), h.getOrDefault(x.kind(), 0) + 1);
        }
        for (String x : h.keySet()) {          //不知道需要遍历的类型 不熟悉
            System.out.println(x + " " + h.get(x) + " 人");
        }
        System.out.println("=== 奖金明细 ===");
        for (Employee x : a) {
            if (x instanceof Bonus) {
                Bonus b = (Bonus) x;
                System.out.printf("%s  %s %.2f%n",x.name,b.bonusTitle(),b.getBonus());
            }
        }
        System.out.println("=== 汇总 ===");
        System.out.printf("%s %.2f%n", "基本工资总额", salarySum(a));
        System.out.printf("%s %.2f%n", "奖金总额", bonusSum(a));
        System.out.printf("%s %.2f%n","总支出", Sum(a));
        }
    }

