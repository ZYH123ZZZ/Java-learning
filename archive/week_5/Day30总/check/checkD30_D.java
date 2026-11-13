import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class checkD30_D {
    public static void limitRuns(List<String> list, int n) {
        Iterator<String> it = list.iterator();
        if (!it.hasNext()) {
            return;
        }
        String first = it.next();
        int run = 1;
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals(first)) {
                run++;
                if (run > n) {
                    it.remove();
                }
            } else {
                first = s;
                run = 1;
            }
        }
    }

    public static void main(String[] args) {
        List<String> li1 = new ArrayList<>();
        li1.add("a");
        li1.add("a");
        li1.add("a");
        li1.add("a");
        li1.add("b");
        li1.add("b");
        limitRuns(li1,2);
        System.out.println(li1);
    }
}
