import java.util.*;

public class checkD38_H {

    static class Stu38 { String name; int score; Stu38(String n, int s) { name = n; score = s; }}

    // 你只写这个：一个参数、void、自己打印
    static void ranking(List<Stu38> list) {
        if (list.isEmpty()) {
            System.out.println("没有学生");
            return;
        }

        List<Stu38> list1 = new ArrayList<>(list);
        Collections.sort(list1, new Comparator<Stu38>() {
            @Override
            public int compare(Stu38 o1, Stu38 o2) {
                if (o1.score == o2.score) {
                    return o1.name.compareTo(o2.name);
                }
                return o2.score - o1.score;
            }
        });

        int count = 0;
        for (Stu38 x : list1) {
            count++;
            System.out.println(count + ". " + x.name + " " + x.score);
        }

        Stu38 max = list1.getFirst();
        Stu38 min = list1.getFirst();
        for (Stu38 x : list1) {
            if (max.score < x.score) {
                max = x;
            }
            if (min.score > x.score) {
                min = x;
            }
        }
        System.out.println("最高 " + max.score + " 最低 " + min.score);
        // 你写
    }

    public static void main(String[] args) {
        System.out.println("--- h1 ---");
        ranking(new ArrayList<>(List.of(new Stu38("张三", 92), new Stu38("李四", 60),
                                        new Stu38("王五", 92), new Stu38("赵六", 75))));
        System.out.println("--- h2 空表 ---");
        ranking(new ArrayList<>());
    }
}
