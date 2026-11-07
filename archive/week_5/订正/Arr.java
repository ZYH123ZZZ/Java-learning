import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Arr {
    public static void main(String[] args) {
        HashMap<String, Integer> count = new HashMap<>();

        count.put("the", 4);
        count.put("on", 2);
        count.put("sat", 2);
        count.put("cat", 1);
        count.put("dog", 1);
        count.put("elephant", 1);
        count.put("mat", 3);
        ArrayList<String> ar = new ArrayList<>(count.keySet());
        Collections.sort(ar,(a,b) -> {
            int d1 = count.get(b) - count.get(a);
            if (d1 != 0) {
                return d1;
            }
            return a.compareTo(b);
        });//collection代码还不熟悉
        for (int i = 0; i < ar.size(); i++) {
            String m = ar.get(i);
            System.out.println(m + " " + count.get(m));
        }
    }
}
