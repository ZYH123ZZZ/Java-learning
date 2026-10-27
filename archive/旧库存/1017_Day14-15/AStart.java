import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AStart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s = new Student();

        s.name = "zhangsan";
        s.score = 85;
        System.out.println(s.name + "\n" + s.score);

        ArrayList<Integer> list1 = new ArrayList<>();

        list1.add(85);
        list1.add(92);

        System.out.println(list1.get(0) + "\n" + list1.get(1));
        System.out.println(list1.size());

        HashMap<String, Integer> map = new HashMap<>();

        map.put("apple", 3);
        int n = map.getOrDefault("apple", 0);
        boolean has = map.containsKey("apple");


        for (int i = 0; i < 5; i++) {
            String name = sc.nextLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        int a = map.getOrDefault("a", 0);
        int b = map.getOrDefault("b",0);
        int c = map.getOrDefault("c", 0);
        System.out.println(a + " " + b + " " + c);
    }
}
