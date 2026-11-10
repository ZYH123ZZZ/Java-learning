import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class checkD19 {
    public static Map<String, Integer> wordCount(List<String> words) {
        HashMap<String, Integer> hm1 = new HashMap<>();
        for (String x : words) {
            hm1.put(x, hm1.getOrDefault(x, 0) + 1);//总感觉这个写的不对但是总体来说对了 之前用了俩加强遍历 现在就用了一个还没用keyset
        }
        return hm1;
    }

    public static void main(String[] args) {
        Map<String, Integer> m = wordCount(List.of("a", "b", "a", "a"));
        for (String x : m.keySet()) {
            System.out.println(x + " = " + m.get(x));
        }
    }

}
