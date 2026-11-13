import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class checkD30_G {
    public static boolean method1(List<String> a, List<String> b) {
        Iterator<String> ita = a.iterator();
        Iterator<String> itb = b.iterator();
        if (a.isEmpty() && b.isEmpty()) {
            return true;
        }
        while (ita.hasNext() && itb.hasNext()) {
                String a1 = ita.next();
                String b1 = itb.next();
                if (!(a1.equals(b1))) {
                    return false;
                }
        }
        if (ita.hasNext() || itb.hasNext()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("1");
        a1.add("2");
        a1.add("1");
        a1.add("3");
        a1.add("1");
        a1.add("1");
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("1");
        a2.add("2");
        a2.add("1");
        a2.add("3");
        a2.add("1");
        a2.add("1");
        System.out.println(method1(a1,a2));
    }
}
