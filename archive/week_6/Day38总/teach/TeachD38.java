import java.util.*;

public class TeachD38 {

    // 一个"只有一个抽象方法"的接口 —— 这种接口 Lambda 才能用
    interface Say {
        void say(String s);
    }

    public static void main(String[] args) {
        // ===== ① 同一件事，两种写法 =====
        Say s1 = new Say() {                 // 老写法：匿名内部类
            @Override
            public void say(String s) {
                System.out.println("匿名类: " + s);
            }
        };
        Say s2 = s -> System.out.println("Lambda: " + s);   // 新写法：Lambda

        s1.say("你好");
        s2.say("你好");

        // ===== ② Runnable（没有参数、没有返回值）=====
        Runnable r1 = new Runnable() {
            @Override
            public void run() { System.out.println("Runnable 匿名类"); }
        };
        Runnable r2 = () -> System.out.println("Runnable Lambda");
        r1.run();
        r2.run();

        // ===== ③ Comparator（两个参数、返回 int）=====
        List<String> a = new ArrayList<>(List.of("cat", "elephant", "on"));
        List<String> b = new ArrayList<>(a);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String x, String y) { return y.length() - x.length(); }
        });
        Collections.sort(b, (x, y) -> y.length() - x.length());
        System.out.println("匿名类排序: " + a);
        System.out.println("Lambda排序: " + b);

        // ===== ④ forEach + 方法引用 =====
        System.out.println("forEach + Lambda:");
        b.forEach(s -> System.out.println("  " + s));
        System.out.println("forEach + 方法引用:");
        b.forEach(System.out::println);
    }
}
