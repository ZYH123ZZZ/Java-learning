import java.util.*;
import java.util.function.*;

public class TeachD38d {

    // ① Comparator：给"怎么比大小"的规则
    static void cmpDemo() {
        List<String> l = new ArrayList<>(List.of("cat", "elephant", "on"));
        l.sort((a, b) -> b.length() - a.length());        // 长 → 短
        System.out.println("① Comparator 排序: " + l);
    }

    // ② Runnable：一段"要干的活"，没有参数、没有返回值
    static void runDemo() throws Exception {
        Runnable job = () -> System.out.println("② Runnable 在另一个线程里干活: " + Thread.currentThread().getName());
        Thread t = new Thread(job, "我的线程");
        t.start();
        t.join();
    }

    // ③ Function：一个进、一个出
    static void fnDemo() {
        Function<String, Integer> len = s -> s.length();
        Function<Integer, String> star = n -> "*".repeat(n);
        System.out.println("③ Function 长度: " + len.apply("banana"));
        System.out.println("③ Function 组合: " + len.andThen(star).apply("abc"));
    }

    public static void main(String[] args) throws Exception {
        cmpDemo();
        runDemo();
        fnDemo();
    }
}
