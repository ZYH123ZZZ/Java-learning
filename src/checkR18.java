// 复习 18 · Lambda 与方法引用（待复习清单第 18 条，B 档，11-23）
// 目标 25 分钟。闭卷。禁用：匿名内部类（new Comparator<String>() {...}）、Stream。
//       这三处必须让编译器看到 -> 或者 ::。
// 教材：E:\dsh\java\第六周练习.md:253（Day38）、:275（三种 Lambda 写法）、:283（方法引用）、:298（三个坑）
import javax.sql.rowset.serial.SerialStruct;
import java.util.*;
import java.util.function.Function;

public class checkR18 {

    // 【1】sortByLength(List<String> list) —— 原地按「长度升序」排；长度一样时按字母升序
    //     必须用 Lambda（list.sort(...) 里直接写 ->），不许写匿名内部类
    //     两个参数时括号不能省
    //
    //     sortByLength(["cat","elephant","on"]) → [on, cat, elephant]
    //     sortByLength(["bb","aa","c"])         → [c, aa, bb]      ← 长度一样时看字母
    static void sortByLength(List<String> list) {
        list.sort((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });
        // 你写
    }

    // 【2】printEach(List<String> list) —— 逐行打印，每行一个
    //     必须用方法引用（list.forEach(...)），不许写 for 循环，不许写 Lambda
    //
    //     printEach(["x","yy"]) →
    //     x
    //     yy
    static void printEach(List<String> list) {
        list.forEach(System.out::println);
        // 你写
    }

    // 【3】toInts(String[] arr) —— 把字符串数字转成 Integer 列表，顺序不变；空数组返空列表
    //     转换这一步必须先接住一个方法引用：
    //         Function<String, Integer> f = …::…;
    //     再用 f.apply(s) 转，不许直接写 Integer.parseInt(s)
    //     （题面不管你怎么循环，只要求"转换是通过那个变量做的"）
    //
    //     toInts(["1","20","300"]) → [1, 20, 300]
    //     toInts([])               → []
    static List<Integer> toInts(String[] arr) {
        Function<String, Integer> f = (Integer::parseInt);
        List<Integer> arr1 = new ArrayList<>();
        for (String s : arr) {
            arr1.add(f.apply(s));
        }
        // 你写


        return arr1;   // 占位，你写完删掉
    }

    // ===== 下面是测试脚手架，不要改 =====

    public static void main(String[] args) {
        List<String> a = new ArrayList<>(Arrays.asList("cat", "elephant", "on"));
        sortByLength(a);
        System.out.println("判据1  " + a + "   期望 [on, cat, elephant]");

        List<String> b = new ArrayList<>(Arrays.asList("bb", "aa", "c"));
        sortByLength(b);
        System.out.println("判据2  " + b + "   期望 [c, aa, bb]");

        System.out.println("判据3  下面应该正好两行 x 和 yy：");
        printEach(Arrays.asList("x", "yy"));

        System.out.println("判据4  " + toInts(new String[]{"1", "20", "300"}) + "   期望 [1, 20, 300]");
        System.out.println("判据5  " + toInts(new String[]{}) + "   期望 []");
    }
}
