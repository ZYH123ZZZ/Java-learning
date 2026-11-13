import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class checkD30_BC {
    public static void dedupInPlace(List<String> list) {
        if (list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        String last = it.next();//提示了才写出来
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals(last)) {
                it.remove();
            }
            last = s;
        }
    }

    public static int removeAll(List<String> list, String target) {
        int count = 0;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String tgt1 = it.next();
            if (tgt1.equals(target)) {
                it.remove();
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        arr1.add("1");
        arr1.add("1");
        arr1.add("1");
        arr1.add("3");
        dedupInPlace(arr1);
        dedupInPlace(arr2);
        System.out.println(arr1);
        System.out.println(arr2);
        System.out.println(removeAll(arr1, "1"));//忽略了第一个方法对列表造成的影响
        System.out.println(removeAll(arr2,"1"));
    }
}
