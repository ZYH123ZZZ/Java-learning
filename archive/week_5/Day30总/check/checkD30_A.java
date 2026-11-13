import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class checkD30_A {
    public static List<String> compress(List<String> in) {
        List<String> out = new ArrayList<>();
        for (String x : in) {
            if (out.isEmpty() || !out.get(out.size() - 1).equals(x)) {
                out.add(x);
            }
        }
        return out;
    }

    public static void removeEvenPos(List<String> list) {
        Iterator<String> it = list.iterator();
        int i = 1;
        while (it.hasNext()) {
            String s = it.next();
            if (i % 2 == 0) {
                it.remove();
            }
            i++;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> a11 = new ArrayList<>(List.of("1", "2", "3", "4"));
        System.out.println(compress(new ArrayList<>(List.of("1","2","3","4"))));
        removeEvenPos(a11);
        System.out.println(a11);
    }
}
