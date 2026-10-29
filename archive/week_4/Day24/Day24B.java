import java.util.ArrayList;
import java.util.HashMap;

public class Day24B {
    public static String maxPrice(ArrayList<Goods> a) {
        double max = a.get(0).price;
        String maxName = a.get(0).name;
        for (Goods x : a) {
            if (max < x.price) {
                max = x.price;
                maxName = x.name;
            }
        }
        return maxName;
    }

    public static double sumPrice(ArrayList<Goods> a) {
        double sum = 0;
        for (Goods x : a) {
            sum = sum + x.price;
        }
        return sum;
    }
    public static void main(String[] args) {
        ArrayList<Goods> a = new ArrayList<>();
//        snack s1 = new snack("薯片", 6.50);
//        snack s2 = new snack("巧克力", 12.00);
//        Drink d1 = new Drink("可乐", 3.00);
//        Drink d2 = new Drink("牛奶", 4.50);
//        Study_tool t1 = new Study_tool("铅笔", 2.00);//这一段曾经卡住
        System.out.println("=== 商品 ===");
        a.add(new snack("薯片", 6.50));
        a.add(new snack("巧克力", 12.00));
        a.add(new Drink("可乐", 3.00));
        a.add(new Drink("牛奶", 4.50));
        a.add(new Study_tool("铅笔", 2.00));
        a.add(new Frost_Goods("冰香肠", 16.35));
        a.add(new Frost_Goods("雪糕", 2.75));
        for (Goods x : a) {
            System.out.printf("%s %.2f%n",x.name,x.price);
        }
        System.out.println("=== 种类统计 ===");
        HashMap<String, Integer> h = new HashMap<>();
        for (Goods x : a) {             //为什么x.name可以但是a.name不可以 因为a是一个数列 而x是从列中遍历出来的Goods
            h.put(x.kind(), h.getOrDefault(x.kind(), 0) + 1);
        }
        for (String x : h.keySet()) {
            System.out.println(x + " " + h.get(x) + " 件");
        }
        System.out.println("=== 最贵的 ===");
        System.out.println(maxPrice(a));
        System.out.println("=== 总价 ===");
        System.out.printf("%.2f%n",sumPrice(a));
    }
}
