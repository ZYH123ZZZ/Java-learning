import java.util.*;

public class checkD38_G {

    // ===== 下面这两样我写好了，你不用动 =====
    interface Judge { boolean ok(int n); }

    static List<Integer> filterNum(List<Integer> l, Judge j) {
        List<Integer> out = new ArrayList<>();
        for (int n : l) if (j.ok(n)) out.add(n);
        return out;
    }
    // ======================================

    // 变式 1：换类型。数字表，升序 + 降序 + 过滤
    static void v1(List<Integer> nums) {
        if (nums.isEmpty()) {
            System.out.println("没有数");
            return;
        }

        //A
        ArrayList<Integer> nums1 = new ArrayList<>(nums);
        Collections.sort(nums1, (Integer::compareTo));//方法引用 不熟
        System.out.println("A: " + nums1);

        //B
        ArrayList<Integer> nums2 = new ArrayList<>(nums);
        Collections.sort(nums2, (a, b) -> b - a);
        System.out.println("B: " + nums2);

        //C
        List<Integer> nums3 = new ArrayList<>(nums);
        Judge j1 = n -> n >= 60;
        nums3 = filterNum(nums, j1);
        nums3.forEach(System.out::println);


        //Final
        System.out.println("共 " + nums.size() + " 个数");
        // 你写
    }

    // 变式 2：换方向。词表，反字典序 + 长度升序
    static void v2(List<String> words) {
        if (words.isEmpty()) {
            System.out.println("没有词");
            return;
        }

        //A
        List<String> words1 = new ArrayList<>(words);
        Collections.sort(words1,(a,b)->b.compareTo(a));
        System.out.println("A: " + words1);

        //B
        List<String> words2 = new ArrayList<>(words);
        Collections.sort(words2, Comparator.comparing(String::length));
        System.out.println("B: " + words2);

        //Final
        System.out.println("共 " + words.size() + " 个词");
        // 你写
    }

    // 变式 3：比较器存成变量，用两次
    static void v3(List<String> words) {
        if (words.isEmpty()) {
            System.out.println("没有词");
            return;
        }

        //A
        List<String> words1 = new ArrayList<>(words);
//        不会用Comparator<>
        Comparator<String> byLen = Comparator.comparingInt(String::length);//是比较器 不是结果
        Collections.sort(words1, byLen);
        System.out.println("A: " + words1);

        //B
        List<String> words2 = new ArrayList<>(words);
        Comparator<String> words2To = byLen.reversed();//Comparator开头
        Collections.sort(words2, words2To);
        System.out.println("B: " + words2);

        //Final
        System.out.println("共 " + words.size() + " 个词");
        // 你写
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(90, 45, 60, 58, 72);
        List<String> words = List.of("pear", "banana", "apple", "fig", "kiwi");

        System.out.println("=== v1 ===");
        v1(new ArrayList<>(nums));
        System.out.println("=== v2 ===");
        v2(new ArrayList<>(words));
        System.out.println("=== v3 ===");
        v3(new ArrayList<>(words));

        System.out.println("=== 空表 ===");
        v1(new ArrayList<>());
        v2(new ArrayList<>());
        v3(new ArrayList<>());
    }
}
