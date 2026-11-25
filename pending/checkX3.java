// checkX3  盲区诊断③ 泛型类 / Comparable 契约
//
// 注意：第 1 部分没写完之前，这份文件编译不过 —— 报错行就是你还没写的泛型类成员，这是故意的。
//
// 硬规则
//   1) 第 1 部分闭卷写，不许查笔记；可以查 API 文档。
//   2) 第 2 部分是「只读只预测」：先把 3 个预测写进下面的「预测」注释，再运行核对。预测没中算没过。
//   3) compareTo 已经给你了，不许改 —— 它故意只比 points，不比 name。

// 预测（第 2 部分，先填再跑）
//   P1  Collections.sort 之后列表顺序：______________
//   P2  再执行 comparingInt(Score::getPoints).reversed() 之后：______________（谁生效、顺序是什么）
//   P3  两个 80 分（不同名字）都 add 进 TreeSet，剩几个：______，为什么：______________

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class checkX3 {

    // ── 第 1 部分：泛型类（教材没教过，先看这三行，再自己写）─────────────────
    //   class 类名<E> { private E item; }     ← 类名后面挂 <E>，字段类型就能写 E
    //   new Box<String>("a")                   ← 用的时候 E 换成具体类型
    //   和你已经会的泛型方法 <T> void printAll(List<T>) 是同一件事：
    //   E 和 T 都只是「到时候再定的类型」，挂的位置不同（一个挂类名，一个挂方法名）。
    static class Box<E> {
        // 你写：private 字段 E item；构造接收 E；E get() 返回 item；void set(E item) 赋值
    }

    static <E> Box<E> firstBox(List<E> list) {
        // 你写：装第一个元素；空表装 null（注意 size() == 0 时别 get(0)）
        return null;
    }

    // ── 第 2 部分：契约（这段不要改）─────────────────────────────────────
    static class Score implements Comparable<Score> {
        String name;
        int points;

        Score(String n, int p) {
            name = n;
            points = p;
        }

        public int compareTo(Score o) {
            return points - o.points;
        }

        int getPoints() {
            return points;
        }

        public String toString() {
            return "(" + name + "," + points + ")";
        }
    }

    public static void main(String[] args) {
        // 判据1~3：Box + firstBox 三组
        List<String> empty = new ArrayList<>();
        List<String> single = new ArrayList<>();
        single.add("x");
        List<String> multi = new ArrayList<>();
        multi.add("y");
        multi.add("z");

        Box<String> b0 = firstBox(empty);
        System.out.println("判据1 空表装的是: " + (b0 == null ? "null" : b0.get()));
        Box<String> b1 = firstBox(single);
        System.out.println("判据2 单元素:     " + (b1 == null ? "null" : b1.get()));
        Box<String> b2 = firstBox(multi);
        System.out.println("判据3 多元素取第一: " + (b2 == null ? "null" : b2.get()));

        // 判据4~6：只读预测
        List<Score> list = new ArrayList<>();
        list.add(new Score("b", 90));
        list.add(new Score("a", 80));
        list.add(new Score("c", 80));

        Collections.sort(list);
        System.out.println("判据4 Collections.sort 之后: " + list);

        list.sort(Comparator.comparingInt(Score::getPoints).reversed());
        System.out.println("判据5 再按分数降序之后:      " + list);

        // 事实（TreeSet 教材只在表里出现过，这里先给你两行）：
        //   TreeSet 会按 compareTo 边排边去重；判重的依据是 compareTo 返回 0，不看 equals。
        TreeSet<Score> set = new TreeSet<>();
        set.add(new Score("a", 80));
        set.add(new Score("c", 80));
        System.out.println("判据6 TreeSet 剩几个:        " + set.size());
    }
}
