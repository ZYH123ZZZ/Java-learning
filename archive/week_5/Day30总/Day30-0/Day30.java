import java.util.ArrayList;
import java.util.Iterator;

public class Day30 {
    public static void main(String[] args) {
        ArrayList<Integer> abc = new ArrayList<>();

        abc.add(3);
        abc.add(47);
        abc.add(12);
        abc.add(88);
        abc.add(12);
        abc.add(5);
        abc.add(12);
        abc.add(60);
        System.out.println(abc);

        Iterator<Integer> it = abc.iterator();
//        while (it.hasNext()) {
//            int x = it.next();
//            if (x == 12 || x < 10) {
//                it.remove();
//            }
//        }
        for (int i = abc.size() - 1; i >= 0; i--) {
//            int x = it.next();
            if (abc.get(i) == 12 || abc.get(i) < 10) {
                abc.remove(i);
            }
        }
        System.out.println(abc);
    }
}
