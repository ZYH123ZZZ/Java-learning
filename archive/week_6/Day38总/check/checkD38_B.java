import java.util.*;

public class checkD38_B {

    // 你只写这个：一个参数、void、自己打印
    static void show(List<String> names) {
        names.sort(String::compareTo);//查表了
        names.forEach(System.out::println);
        System.out.println("共 " + names.size() + " 个");


    }

    public static void main(String[] args) {
        System.out.println("--- b1 ---");
        show(new ArrayList<>(List.of("pear", "apple", "fig", "banana", "kiwi")));
        System.out.println("--- b2 空表 ---");
        show(new ArrayList<>());
    }
}
