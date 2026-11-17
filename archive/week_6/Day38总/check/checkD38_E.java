import java.util.*;

public class checkD38_E {

    // 这个接口我写好了，不许改
    interface Judge {
        boolean ok(String s);
    }

    // 这个方法我也写好了，不许改
    static int countIf(List<String> l, Judge j) {
        int c = 0;
        for (String s : l) if (j.ok(s)) c++;
        return c;
    }

    // 你只写这个：三个 Judge 用 Lambda 写，然后各打一行
    static void run() {
        List<String> l = List.of("", "apple", "avocado", "fig", "banana");

        // ① 判断是不是空字符串
        // ② 判断是不是以 "a" 开头
        // ③ 判断长度是不是 >= 5

        // 三行输出写成：
        // 空: N 个
        // a 开头: N 个
        // 长度>=5: N 个
        // 你写
    }

    public static void main(String[] args) {
        run();
    }
}
