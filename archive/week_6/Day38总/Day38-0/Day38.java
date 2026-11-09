import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day38 {
    public static void main(String[] args) {
        Runnable r1 = () -> {
            System.out.println("我是一句话");
        };
        r1.run();

        Comparator<String> com = (String a, String b) -> {
            return b.length() - a.length();
        };

        List<String> li = new ArrayList<>();
        li.add("43");
        li.add("akdghia");
        li.add("192371");
        li.sort(com);
        System.out.println(li.toString());

        List<Runnable> li1 = new ArrayList<>();
        li1.add(() -> System.out.println("你好"));
        li1.add(() -> System.out.println("72638"));
        li1.add(() -> System.out.println("我喜欢hi"));
        li1.forEach(System.out::println);
    }
}
