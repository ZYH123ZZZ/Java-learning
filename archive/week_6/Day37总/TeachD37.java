import java.util.*;

// ① 传统写法：单写一个实现类，占一个"类"的位置
class ByLength implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        return a.length() - b.length();
    }
}

public class TeachD37 {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>(List.of("cat", "elephant", "on"));
        List<String> l2 = new ArrayList<>(List.of("cat", "elephant", "on"));
        List<String> l3 = new ArrayList<>(List.of("cat", "elephant", "on"));

        // ① 传一个类的对象
        Collections.sort(l1, new ByLength());

        // ② 匿名内部类：类名省了，当场 new 一个实现，用一次就扔
        Collections.sort(l2, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        // ③ Lambda：② 的简写（前提：这个接口只有一个抽象方法）
        Collections.sort(l3, (a, b) -> a.length() - b.length());

        System.out.println("① 单写一个类   " + l1);
        System.out.println("② 匿名内部类   " + l2);
        System.out.println("③ Lambda       " + l3);
    }
}
