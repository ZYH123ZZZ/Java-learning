import java.util.*;
import java.util.function.*;

public class TeachD38c {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>(List.of("cat", "elephant", "on"));

        // ① 静态方法：类名::静态方法
        Function<String, Integer> f1 = s -> Integer.parseInt(s);
        Function<String, Integer> f2 = Integer::parseInt;
        System.out.println("① 静态  " + f1.apply("123") + " / " + f2.apply("123"));

        // ② 某个对象的实例方法：对象::方法
        Consumer<String> c1 = s -> System.out.println("  打印: " + s);
        l.forEach(c1);
        l.forEach(s -> System.out.println("  引用: " + s));
        Function<String, Integer> f3 = s -> s.length();          // 等价下面这行
        Function<String, Integer> f4 = String::length;           // 第一个参数当接收者
        System.out.println("② 实例  " + f3.apply("abcd") + " / " + f4.apply("abcd"));

        // ③ 排序里用：String::compareTo  ==  (a, b) -> a.compareTo(b)
        List<String> a1 = new ArrayList<>(l);
        List<String> a2 = new ArrayList<>(l);
        a1.sort((x, y) -> x.compareTo(y));
        a2.sort(String::compareTo);
        System.out.println("③ 字典序 " + a1 + " / " + a2);

        // ④ 构造方法引用：类名::new
        Supplier<List<String>> s1 = () -> new ArrayList<>();
        Supplier<List<String>> s2 = ArrayList::new;
        List<String> made = s2.get();
        made.add("新造的");
        System.out.println("④ 构造  " + s1.get() + " / " + made);
    }
}
