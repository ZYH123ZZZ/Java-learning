import java.util.*;

public class checkD38_F {

    // 接口我写好了，不许改
    interface Judge {
        boolean ok(String s);
    }

    // 过滤方法我写好了，不许改
    static List<String> filter(List<String> l, Judge j) {
        List<String> out = new ArrayList<>();
        for (String s : l) if (j.ok(s)) out.add(s);
        return out;
    }

    // 你只写这个：一个参数、void、自己打印
    static void show(List<String> words) {
        if (words.isEmpty()) {
            System.out.println("没有词");
            return;
        }

        //A
        ArrayList<String> words1 = new ArrayList<>(words);
        Collections.sort(words1, Comparator.comparingInt(String::length).reversed());//change
        System.out.println("A: " + words1);

        //B
        ArrayList<String> words2 = new ArrayList<>(words);
        Collections.sort(words2, String::compareTo);
        System.out.println("B: " + words2);
//        Judge j1 = new Judge() {
//            @Override
//            public boolean ok(String s) {
//                s.compareTo(s);
//            }
//        };

        //C
        ArrayList<String> words3 = new ArrayList<>(words);
        Collections.sort(words3, (a, b) -> a.length() - b.length());
        System.out.println("C: " + words3);

        //D
        Judge j1 = s -> s.length() >= 5;
        ArrayList<String> words4 = new ArrayList<>(filter(words, j1));
        words4.forEach(System.out::println);//不会

        System.out.println("共 " + words.size() + " 个词");
        System.out.println("原表: " + words);

















        // 你写
    }

    public static void main(String[] args) {
        System.out.println("--- f1 ---");
        show(new ArrayList<>(List.of("pear", "banana", "apple", "fig", "kiwi")));
        System.out.println("--- f2 空表 ---");
        show(new ArrayList<>());
    }
}
