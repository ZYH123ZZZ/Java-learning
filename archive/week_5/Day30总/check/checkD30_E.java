import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class checkD30_E {
    public static void dropFirstAndLast(List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        Iterator<String> it = list.iterator();
        it.next();
        it.remove();
        while (it.hasNext()) {
            it.next();
        }
        if (!list.isEmpty()) {
            it.remove();
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("1");
        arr1.add("1");
        arr1.add("1");
        arr1.add("1");
        arr1.add("1");
        dropFirstAndLast(arr1);
        System.out.println(arr1);
    }
}
