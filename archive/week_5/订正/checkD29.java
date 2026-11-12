import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class checkD29 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(List.of("java", "io", "stream", "file", "buffered", "a", "reader"));
        System.out.println("原始: " + words);
        Collections.sort(words, (a, b) -> {
            int d1 = b.length() - a.length();
            if (d1 == 0) {
                return a.compareTo(b);
            }
            return d1;
        });
        System.out.println(words);
        System.out.println("最长的是: " + words.get(0) + " 长度: " + words.get(0).length());
    }
}
