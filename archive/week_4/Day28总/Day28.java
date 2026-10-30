import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Day28 {
    public static ArrayList<Book> cost(ArrayList<Book> a) {
        for (Book x : a) {//遍历提取杂志
            if (x.kind.equals("杂志")) {
                x.price = x.price * 0.8;//打八折 这里直接把数据改掉了
//                a.add(new Book(x.kind,x.name,x.price,x.page));//不能边遍历边add
            }
        }
        return a;
    }

    public static double sumPrice(ArrayList<Book> a, int n) {//求价格和
//        double sum = 0;//总和赋初始值（不加a = cost是因为main里面替换了）
//        for (Book x : a) {
//            sum = sum + x.price;//遍历求和
//        }
//        return sum;
        if (n <= 0) {//这种不熟悉
            return 0;
        }
        return sumPrice(a, n - 1) + a.get(n - 1).price;//真假数据分
    }

    public static Book maxPrice(ArrayList<Book> a, int n) {//最大值
        if (n <= 0) {
            return null;
        }               //防止0
        Book max = a.get(0);
        for (Book x : a) {
            if (max.price < x.price) {
                max = x;//打擂台
            }
        }
        return max;
    }

    public static HashMap<String, Integer> h1(ArrayList<Book> a, HashMap<String, Integer> h) {//累计
        for (Book x : a) {
            h.put(x.kind, h.getOrDefault(x.kind, 0) + 1);//标准累计种类
        }
        return h;
    }

    public static int sumPage(ArrayList<Book> a, int n,int sum) {//求总页数//不会
//        int sum = 0;//赋值初始
//        for (Book x : a) {
//            sum = sum + x.page;//遍历相加
//        }
//        return sum;
        if (n <= 0) {
            return sum;
        }
        return sumPage(a, n - 1,sum) + a.get(n - 1).page;//不用从1开始加 只用加完就行了
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> a = new ArrayList<>();

        int n = sc.nextInt();//几本书
        for (int i = 0; i < n; i++) {
            try {//跳过坏的
                String kind  = sc.next();
                String name  = sc.next();
                double price = sc.nextDouble();
                int page     = sc.nextInt();

                if (page < 0) {
                    throw new IllegalArgumentException("页数不能为负数");
                }
                a.add(new Book(kind, name, price, page));//给AL添加数据
            } catch (IllegalArgumentException e) {//跳过坏的
                System.out.println("第 " + (i + 1) + " 行，" + e.getMessage());//不会写这个
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("第 " + (i + 1) + " 行，价格不是数字");
                sc.nextLine();//忘记收回值
            }
        }
        a = cost(a);//打八折
        for (Book x : a) {
            System.out.printf("%s %.2f%n",x.name,x.price);//输出书的部分数据
        }
        System.out.printf("%s %.2f%n","总价:",sumPrice(a, a.size()));
        System.out.println("最贵: " + maxPrice(a, a.size()).name);

        HashMap<String, Integer> h = new HashMap<>();
        h = h1(a, h);

        for (String x : h.keySet()) {//输出
            System.out.print(x + " " + h.get(x) + " 本 ");
        }
        System.out.println();
        System.out.println("总页数: " + sumPage(a, a.size(),0));//传真数据 因为假数据被抓走扔掉了
    }
}
//BUG1 先add后检查
//BUG2 有效和无效数据
//BUG3 坏数据不录入 极容易越界 要分清楚
//BUG4 循环忘记