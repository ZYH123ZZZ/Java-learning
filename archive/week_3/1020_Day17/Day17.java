import java.util.ArrayList;

public class Day17 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(85);
        list.add(92);
        list.add(78);

        System.out.println(list.get(0));
        System.out.println(list.size());
        list.set(1, 100);
        list.remove(0);
        System.out.println(list.contains(78));
    }
}
