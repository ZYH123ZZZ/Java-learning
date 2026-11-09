import java.util.List;
import java.util.function.Consumer;

public class Day38A {
    public static <T> void runAll(List<T> data, Consumer<T> action) {
        for (T x : data) {
            action.accept(x);
        }
    }
    public static void main(String[] args) {
        List<String> names = List.of("张三", "李四", "王五");
        List<Integer> nums = List.of(1, 2, 3, 4);

        runAll(names, s -> System.out.println("处理: " + s));//格式不知道
        runAll(names, s -> System.out.println(s));
        runAll(nums, x -> System.out.println(x * x));
    }
}
