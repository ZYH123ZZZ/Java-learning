// 复习 10 · Iterator 边界 + 单行道（待复习清单第 10 条，B 档，11-20）
// 目标 20 分钟。闭卷。禁用：removeIf、for 循环里直接 list.remove()、类级 static。
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class checkR10 {

    // 【1】trimBelowAvg(List<Integer> list) —— 原地删掉「小于平均值」的元素，返回删掉几个
    //     平均值 = 这趟里所有数的和 ÷ 个数（表是空的就别算）
    //     表必须原地变（不是另建一个返回），返回值只是「删了几个」
    //     必须用 Iterator 删，不许 removeIf、不许 for 里直接 list.remove()
    //     教材：Iterator 骨架 E:\dsh\java\第五周练习.md:326-332
    //           「it.remove() 必须紧跟 next()」:335
    //           元素个数 size() 第三周练习.md:672
    //
    //     trimBelowAvg([90, 85, 100, 70, 60]) → 返回 2，表变成 [90, 85, 100]（平均 81，删掉 70 和 60）
    //     trimBelowAvg([]) → 返回 0
    static int trimBelowAvg(List<Integer> list) {
        int countIterator = 0;
        int sum = 0;
        for (int x : list) {
            sum += x;
        }
        double avg = (double)sum / list.size();

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int x1 = it.next();
            if (x1 < avg) {
                it.remove();
                countIterator++;
            }
        }
        // 你写（下面这行是占位，写完删掉）
        return countIterator;
    }

    public static void main(String[] args) {
        // 判据 1：正常路径 —— 删对、原地变
        List<Integer> a = new ArrayList<>();
        a.add(90);
        a.add(85);
        a.add(100);
        a.add(70);
        a.add(60);
        System.out.println("判据1 删掉 " + trimBelowAvg(a) + " 个，剩下 " + a
                + "   期望 2 个 / [90, 85, 100]");

        // 判据 2：边界 —— 空表，不许崩、不许除零
        List<Integer> b = new ArrayList<>();
        System.out.println("判据2 空表 删掉 " + trimBelowAvg(b) + " 个   期望 0（不许崩）");

        // 判据 3：边界 —— 全都等于平均值时，一个都不该删
        List<Integer> c = new ArrayList<>();
        c.add(5);
        c.add(5);
        c.add(5);
        System.out.println("判据3 [5, 5, 5] 删掉 " + trimBelowAvg(c) + " 个，剩下 " + c
                + "   期望 0 个 / [5, 5, 5]");

        // 判据 4：这张表还能接着用吗 —— 同一张表再调一次，得按当前内容重算
        System.out.println("判据4 同一张表再调一次 删掉 " + trimBelowAvg(a) + " 个，剩下 " + a
                + "   期望 2 个 / [100]");
    }
}
