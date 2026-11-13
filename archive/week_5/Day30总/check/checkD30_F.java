import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class checkD30_F {
    public static void method1(List<String> list, int k) {
        if (list.size() == 0) {
            return;
        }
        if (k > list.size()) {
            k = (k % list.size());
        }
        Iterator<String> it = list.iterator();
        String[] s1 = new String[k];
        while (it.hasNext()) {
            for (int i = 0; i < k; i++) {
                String s = it.next();
                it.remove();
                s1[i] = s;
            }
            for (String x : s1) {
                list.add(x);
            }
            System.out.println(list);
            return;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<>(List.of("a", "b", "c", "d", "e"));
        method1(a1, 2);
    }
}
