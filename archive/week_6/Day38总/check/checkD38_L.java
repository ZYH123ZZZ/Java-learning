import java.util.*;
import java.util.function.Function;

public class checkD38_L {

    interface Maker { List<String> make(); }

    // 你只写这个：一个参数、void、自己打印
    static void four(List<String> names) {
        names.forEach(System.out::println);

        List<String> names1 = new ArrayList<>(names);
        Collections.sort(names1, (String::compareTo));//不会
        System.out.println(names1);

        Function<String, Integer> f = Integer::parseInt;
        int a1 = f.apply("123") + 1;
        System.out.println(a1);

        Maker mk = ArrayList::new;
        List<String> l = mk.make();
        l.add("x");
        System.out.println(l);





        // 你写
    }

    public static void main(String[] args) {
        System.out.println("--- l1 ---");
        four(new ArrayList<>(List.of("pear", "apple", "banana")));
    }
}
