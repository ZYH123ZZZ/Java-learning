import java.util.*;

public class checkD38_N {

    // 你只写这个方法：一个参数、void、自己打印
    static void names(List<String> words) {
        if (words.isEmpty()) {
            System.out.println("没有名字");
            return;
        }

        List<String> words1 = new ArrayList<>(words);
        Collections.sort(words1, (String::compareTo));
        System.out.println("排序: " + words1);

        System.out.println("第一 " + words1.getFirst() + ",最后 " + words1.getLast());








        // 你写
    }

    public static void main(String[] args) {
        System.out.println("--- n1 ---");
        names(new ArrayList<>(List.of("pear", "apple", "banana")));
        System.out.println("--- n2 空表 ---");
        names(new ArrayList<>());
        System.out.println("--- n3 只有一个 ---");
        names(new ArrayList<>(List.of("zoom")));
    }
}
