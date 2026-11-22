public class checkR8 {

    // 用 sep 把 items 连起来。
    // join("-", "a", "b", "c") → a-b-c
    // join(",", 1, 2, 3)       → 1,2,3
    // join("-")                → (空)
    // 注意：什么类型都能塞进来（String、int、boolean 混着都行）
    static <T> String join(String sep, T... items) {
        if (items.length == 0) {
            return "(空)";
        }
        String a1 = "";
        int i = 0;
        for (T x : items) {
            if (i == 0) {
                a1 = a1 + x;
            } else if (i >= 1) {
                a1 = a1 + sep + x;
            }
            i++;
        }
        // 你写
        return a1;
    }

    // 求任意个 int 里最大的那个。
    // maxOf(3, 8, 2) → 8
    // maxOf(7)       → 7
    // 一个数都没给 → 抛 IllegalArgumentException("没有数")
    static int maxOf(int... nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("没有数");
        }
        int[] nums1 = nums;
        int max = nums1[0];
            for (int i = 0; i < nums1.length; i++) {
                if (max < nums1[i]) {
                    max = nums1[i];
                }
            }
        // 你写
        return max;
    }

    public static void main(String[] args) {
        System.out.println(join("-", "a", "b", "c"));    // 期望 a-b-c
        System.out.println(join(",", 1, 2, 3));          // 期望 1,2,3
        System.out.println(join("-"));                   // 期望 (空)
        System.out.println(join(" | ", "java", 21, true)); // 期望 java | 21 | true

        System.out.println("---");

        System.out.println(maxOf(3, 8, 2));              // 期望 8
        System.out.println(maxOf(7));                    // 期望 7
        System.out.println(maxOf(-5, -1, -9));           // 期望 -1
        try {
            maxOf();                                     // 期望 抛 IllegalArgumentException，消息是 没有数
        } catch (IllegalArgumentException e) {
            System.out.println("炸了：" + e.getMessage());  // 期望 炸了：没有数
        }
    }
}
