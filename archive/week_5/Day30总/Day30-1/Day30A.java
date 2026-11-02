import java.util.*;

public class Day30A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Member> list = new ArrayList<>();   // 仓库：全部收进来
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(new Member(sc.next(), sc.nextInt()));   // 不判、不跳，全收
        }
        System.out.println("报名 " + list.size() + " 条");
        System.out.println();
        HashSet<Integer> h = new HashSet<>();
        ArrayList<Member> list1 = new ArrayList<>();//添加一个新的数列用来存排除后的以及用来输出
        for (Member x : list) {
            if (!h.contains(x.num)) {
                h.add(x.num);
                list1.add(x);
            }
        }
        int m = 0;
        for (Member o1 : list1) {
            System.out.println(o1.name + " " + o1.num);//不会写
        }
        System.out.println();


        Iterator<Member> it = list1.iterator();
        while (it.hasNext()) {
            Member x = it.next();
                if (x.num < 100) {
                    it.remove();
            }
        }
        System.out.println();
        for (int i = 0; i < list1.size(); i++) {
            Member o = list1.get(i);
            System.out.println(o.name + " " + o.num);
        }
        HashMap<String, Integer> h1 = new HashMap<>();
        for (Member x : list) {
            String x1 = x.name;
            h1.put(x1, h1.getOrDefault(x1, 0) + 1);
        }

        System.out.println();

        HashSet<String> printed = new HashSet<>();//这段还是不太理解
        for (Member m1 : list) {
            if (printed.add(m1.name)) {     // 第一次遇到这个名字
                System.out.println(m1.name + " " + h1.get(m1.name) + " 次"); // 打印 m.name + " " + cnt.get(m.name) + " 次"
            }
        }


        // ① 打印 "报名 n 条"
        // ② 去重：HashSet<Integer> 判断学号见没见过，没见过的按顺序收集起来输出
        // ③ 用迭代器从 list 里删掉 num < 100 的，输出剩几个、剩下谁
        // ④ HashMap<String,Integer> 数报名次数（key 用姓名）
    }
}

