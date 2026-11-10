import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Day38C {
    public static <T, R> List<R> map(List<T> data, Function<T, R> f) {
        List<R> l1 = new ArrayList<>();
        for (T x : data) {
            l1.add(f.apply(x));
        }
        return l1;
    }

    public static <T> List<T> filter(List<T> data, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T x : data) {
            if (p.test(x)) {
                result.add(x);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> names = List.of("张", "李四", "王五五", "赵六六六");
        List<Integer> lens = map(names, s -> s.length());//忘记结构
        System.out.println(lens);
        List<String> longNames = filter(names, s -> s.length() >= 3);
        System.out.println(longNames);
        System.out.println(map(longNames, String::length));
    }


}
