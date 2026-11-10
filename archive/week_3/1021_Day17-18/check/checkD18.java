import java.util.ArrayList;
import java.util.List;

public class checkD18 {
    public static <T> void printAll(List<T> list) {
        for (T x : list) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1876);
        l1.add(137);
        List<String> l2 = new ArrayList<>();
        l2.add("ajyd");
        l2.add("kahsds");
        printAll(l1);
        printAll(l2);
    }
}
