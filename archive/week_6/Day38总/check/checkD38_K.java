import java.util.*;
import java.util.function.Function;

public class checkD38_K {

    // 你只写这个：一个参数、void、自己打印
    static void demo(List<String> words) {

        List<String> words1 = new ArrayList<>(words);
        Collections.sort(words1, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });
        System.out.println("[排序] " + words1);

        Runnable r = () -> {
            for (String s : words1) {
                System.out.println("  " + s);
            }
        };
        r.run();

        Function<String,Integer> f = s -> {
            int n = s.length();
            return n * 10;
        };
        System.out.println("[打分] " + f.apply(words1.get(0)));
        // 你写
    }

    public static void main(String[] args) {
        System.out.println("--- k1 ---");
        demo(new ArrayList<>(List.of("peach", "on", "cat", "dog", "fig")));
    }
}
