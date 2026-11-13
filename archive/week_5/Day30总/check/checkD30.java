import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class checkD30 {
    public static List<String> dedup(List<String> in) {
        ArrayList<String> ar1 = new ArrayList<>();
        for (String x : in) {
            if (!ar1.contains(x)) {
                ar1.add(x);
            }
        }
        return ar1;
    }

    public static void removeShort(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.length() < 3) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        List<String> t = new ArrayList<>(List.of("java", "io", "file", "a", "an", "stream"));
        removeShort(t);
        System.out.println(t);
    }
}
