import java.util.*;

public class checkD38_O {

    interface Maker { List<String> make(); }

    // 你只写这个方法：一个参数、void、自己打印
    static void split(List<String> words) {
        if (words.isEmpty()) {
            System.out.println("没有词");
            return;
        }

        Maker mk = ArrayList::new;
        List<String> Long = mk.make();
        List<String> Short =mk.make();

        for (String x : words) {
            if (x.length() > 3) {
                Long.add(x);
            }
            if (x.length() <= 3) {
                Short.add(x);
            }
        }

        System.out.println("短: " + Short + " 长: " + Long + " 共 " + (Short.size() + Long.size()) + " 个");






        // 你写
    }

    public static void main(String[] args) {
        System.out.println("--- o1 ---");
        split(new ArrayList<>(List.of("on", "cat", "elephant", "fig")));
        System.out.println("--- o2 空表 ---");
        split(new ArrayList<>());
        System.out.println("--- o3 ---");
        split(new ArrayList<>(List.of("dog", "bird")));
    }
}
