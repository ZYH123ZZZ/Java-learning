import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day26D {
    public static Book maxPage(ArrayList<Book> a) {//最厚的(这次知道用Book了)
//        Book max = new Book("", 0,0);//创建一个max 后面用来覆盖
//        max.page = a.get(0).page;//给max赋予数列中本来就拥有的值（害怕忘记原理）
//        max.page = a.get(0).page;
//        max.name = a.get(0).name;
        Book max = a.get(0);
        for (Book x : a) {//遍历挑最大
            if (max.page < x.page) {//打擂台
                max = x;//覆盖为最大
            }
        }
        return max;
    }

    public static Book maxTime(ArrayList<Book> a) {//最热门的
//        Book max = new Book("", 0, 0);//同上：6
//        max.time = a.get(0).time;
//        max.page = a.get(0).page;
//        max.name = a.get(0).name;
        Book max = a.get(0);
        for (Book x : a) {
            if (max.time < x.time) {
                max = x;
            }
        }
        return max;//基本同上
    }

    public static String kind(Book x) {//给各种图书分类//还是不会
        // 下面没错 这段错了 遍历在下面 这里单个对单个 仅仅用于判断

            if (x.time >= 15) {//分频率
                return "高频";
            } else if (x.time >= 8) {
                return "中频";
            } else if (x.time < 8) {
                return "低频";
            }

        return "没有这个频率";//错误输出
    }

    public static int sumPage(ArrayList<Book> a) {//总页数
        int sum = 0;
        for (Book x : a) {
            sum = sum + x.page;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> a = new ArrayList<>();

        int n = sc.nextInt();//书的数量
        for (int i = 0; i < n; i++) {//从外部输入书名，页数，借阅次数
            a.add(new Book(sc.next(), sc.nextInt(), sc.nextInt()));
        }

        System.out.println("=== 图书清单 ===");
        for (Book x : a) {//输出图书清单（遍历）
            System.out.printf("%s %d%s %s%d%s%n",x.name,x.page,"页","借",x.time,"次");
        }

        System.out.println("=== 最厚的 ===");
        Book t = maxPage(a);
        System.out.printf("%s %d%s%n",t.name,t.page,"页");//输出最厚的页数

        System.out.println("=== 最热门的 ===");
        Book t2 = maxTime(a);
        System.out.printf("%s %d%s%n",t2.name,t2.time,"次");//输出最热门的书（基本同上）

        HashMap<String, Integer> h = new HashMap<>();

        for (Book x : a) {//遍历用来给Hashmap赋值
            h.put(kind(x), h.getOrDefault(kind(x), 0) + 1);  //计数
        }

        System.out.println("=== 借阅分布 ===");

        for (String x : h.keySet()) {//用来输出（遍历）
            System.out.printf("%s %d %s%n",x,h.get(x),"本");
        }

        System.out.println("=== 总页数 ===");
        System.out.println(sumPage(a));//输出总页数
    }
}
