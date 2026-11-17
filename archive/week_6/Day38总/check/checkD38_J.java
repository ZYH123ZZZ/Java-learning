import java.util.*;
import java.util.function.Function;

public class checkD38_J {

    // 你只写这个：两个参数、void、自己打印
    static void price(List<Integer> list, Function<Integer, Integer> f) {
        if (list.isEmpty()) {
            System.out.println("没有价格");
            return;
        }

        List<Integer> list1 = new ArrayList<>(list);
        int sum = 0;
        int newsum = 0;
        for (int x : list1) {
            sum += x;
            int newnum = f.apply(x);
            newsum += newnum;
            System.out.println(x + " -> " + newnum);
        }

        System.out.println("原总 " + sum + ",新总 " + newsum + ",省了 " + (sum - newsum));








        // 你写
    }

    public static void main(String[] args) {
        Function<Integer, Integer> off = p -> p * 85 / 100;
        System.out.println("--- j1 ---");
        price(new ArrayList<>(List.of(100, 60, 45)), off);
        System.out.println("--- j2 空表 ---");
        price(new ArrayList<>(), off);
    }
}
