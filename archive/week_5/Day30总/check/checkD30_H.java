import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class checkD30_H {
    public static void deletepeople(Collection<String> a, int n) {
        int count = 0;
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.length() < n) {
                it.remove();
                count++;
            }
        }
        System.out.println("删了 " + count + " 个，现在 " + a);
    }

    public static void main(String[] args) {
        ArrayList<String> g1 = new ArrayList<>();
        g1.add("张");
        g1.add("李");
        g1.add("王五");
        g1.add("赵六六");


        ArrayList<String> g2 = new ArrayList<>();   // 空集合，一个都不放

        ArrayList<String> g3 = new ArrayList<>();
        g3.add("张");

        ArrayList<String> g4 = new ArrayList<>();
        g4.add("王五");

        ArrayList<String> g5 = new ArrayList<>();
        g5.add("张");
        g5.add("李");
        deletepeople(g1,2);
        deletepeople(g2, 2);
        deletepeople(g3, 2);
        deletepeople(g4, 2);
        deletepeople(g5, 2);
    }
}
