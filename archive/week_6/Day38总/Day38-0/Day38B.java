import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Day38B {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of(
                "java", "io", "stream", "file", "buffered", "a", "reader", "go", "code"));

        System.out.println("原始：" + words.toString());

        Collections.sort(words, new Comparator<String>() {//忘记格式 看了昨天练习文档
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
        });
        System.out.println("排序后：" + words.toString());
        int count = 0;
        for (String x : words) {
            if (x.length() < 3) {
                continue;
            }
            System.out.println(x);
            count++;
        }
        System.out.println("剩余 " + count + " 个");
    }
}
