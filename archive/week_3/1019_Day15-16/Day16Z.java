import java.util.HashMap;

public class Day16Z {
    public static void main(String[] args) {
        HashMap<String, String> s = new HashMap<>();

        s.put("2621821878", "周永航");
        s.put("0000000001", "张三");
        s.put("0000000002", "李四");

        System.out.println(s.get("周永航"));
        System.out.println(s.get("2621821878"));
        System.out.println(s.getOrDefault("张三", "0"));
        System.out.println(s.containsKey("王五"));

    }
}
