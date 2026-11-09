import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Day38C {
    public static <T, R> List<R> map(List<T> data, Function<T, R> f) {
        List<R> l1 = new ArrayList<>();
        for (T x : data) {
            l1.add(f.apply(x));
        }
        return l1;
    }

    public static void main(String[] args) {
        List<String> names = List.of("张", "李四", "王五五", "赵六六六");
    }
}
