import java.util.Arrays;
import java.util.Iterator;

interface Priced {
    int price();
}

class Item {
    String name;

    Item(String name) {
        this.name = name;
    }

}

class Book extends Item implements Priced {
    int p;

    Book(String n, int p) {
        super(n);
        this.p = p;
    }

    public int price() {
        return p;
    }
}

class Pen extends Item implements Priced {
    int p;

    Pen(String n, int p) {
        super(n);
        this.p = p;
    }

    public int price() {
        return p;
    }
}

class Cup extends Item {          // 不实现 Priced

    Cup(String n) {
        super(n);
    }
}

public class checkR5B {

    // 题 1：所有能算价的价格之和。一个都没有 → 0。
    static int total(Item[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] instanceof Priced) {
                sum += ((Priced) a[i]).price();
            }
        }
        // 你写
        return sum;
    }

    // 题 2：把实现了 Priced 的挑出来，按价格从低到高排好，返回名字数组。
    //      一个都没有 → 返回空数组。
    //      排序自己写冒泡，不许 Arrays.sort。
    static String[] byPrice(Item[] a) {
        int count = 0;
        for (Item x : a) {
            if (x instanceof Priced) {
                count++;
            }
        }
        String[] n1 = new String[count];
        Item[] a2 = new Item[count];
        if (count == 0) {
            return n1;
        }
        int m = 0;
        int m2 = 0;
        for (Item x : a) {
            m2++;
            if (x instanceof Priced) {
                a2[m] = x;
                m++;
            }
        }
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (((Priced) a2[j]).price() > ((Priced) a2[j + 1]).price()) {
                    Item tmp = a2[j + 1];
                    a2[j + 1] = a2[j];
                    a2[j] = tmp;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            n1[i] = a2[i].name;
        }
        // 你写
        return n1;
    }

    public static void main(String[] args) {
        Item[] g1 = {
            new Book("Java", 59),
            new Cup("杯子"),
            new Pen("钢笔", 12),
            new Book("算法", 88),
            new Pen("铅笔", 3)
        };
        Item[] g2 = { new Cup("甲"), new Cup("乙") };
        Item[] g3 = { new Pen("钢笔", 12) };
        Item[] g4 = { new Book("A", 10), new Pen("B", 10), new Book("C", 5) };

        Item[][] gs = { g1, g2, g3, g4 };
        String[] names = { "混装", "全不实现", "单个", "同价" };

        for (int i = 0; i < gs.length; i++) {
            System.out.println("--- " + names[i] + " ---");
            System.out.println("总价 " + total(gs[i]));
            System.out.println(Arrays.toString(byPrice(gs[i])));
        }
    }
}
