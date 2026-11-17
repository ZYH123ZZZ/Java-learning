import java.util.*;

public class TeachD38b {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>(List.of("cat", "elephant", "on", "dog"));
        List<String> b = new ArrayList<>(a);

        // ① 自己写 compare：降序 = 后一个减前一个
        Collections.sort(a, (x, y) -> y.length() - x.length());

        // ② 用 comparingInt 说"按什么排"，再 reversed() 整体反过来
        Collections.sort(b, Comparator.comparingInt(String::length).reversed());//

        System.out.println("① 自己写 compare : " + a);
        System.out.println("② comparingInt    : " + b);

        // ③ 升序就是不要 reversed()
        List<String> c = new ArrayList<>(List.of("cat", "elephant", "on", "dog"));
        c.sort(Comparator.comparingInt(String::length));//
        System.out.println("③ 不要 reversed() : " + c);

        // ④ List.sort 也能用，和 Collections.sort 等价
        List<String> d = new ArrayList<>(List.of("cat", "elephant", "on", "dog"));
        d.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println("④ List.sort       : " + d);
    }
}
