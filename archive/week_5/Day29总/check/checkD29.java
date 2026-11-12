import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class checkD29 {
    public static <T> void printAll(T... items) {
        for (T x : items) {
            System.out.println(x);
        }
    }

    public static <T> T first(List<T> list) {
        return list.getFirst();
    }

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>(List.of(1, 2, 3, 4));
        printAll("a","b","c");
        printAll(1,2);
        System.out.println(first(li));
    }
}
