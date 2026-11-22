import java.util.ArrayList;
import java.util.Arrays;

interface Priced2 {
    int price();
}

class Item2 {
    String name;

    Item2(String name) {
        this.name = name;
    }
}

class Book2 extends Item2 implements Priced2 {
    int p;

    Book2(String n, int p) {
        super(n);
        this.p = p;
    }

    public int price() {
        return p;
    }
}

class Pen2 extends Item2 implements Priced2 {
    int p;

    Pen2(String n, int p) {
        super(n);
        this.p = p;
    }

    public int price() {
        return p;
    }
}

class Cup2 extends Item2 {          // 不实现 Priced2

    Cup2(String n) {
        super(n);
    }
}

public class checkR5C {

    // 题 1：最便宜的那个名字。一个能算价的都没有 → "(无)"
    static String cheapest(Item2[] a) {
        ArrayList<Item2> a1 = new ArrayList<>();
        for (Item2 x : a) {
            if (x instanceof Priced2) {
                a1.add(x);
            }
        }

        if (a1.isEmpty()) {
            return "(无)";
        }

        Item2 cheapEst = a1.getFirst();
        for (Item2 x : a1) {
            if (((Priced2) x).price() < ((Priced2) cheapEst).price()) {
                cheapEst = x;
            }
        }
        // 你写
        return cheapEst.name;
    }

    // 题 2：价格超过 50 的有几个。
    static int over50(Item2[] a) {
        ArrayList<Item2> a1 = new ArrayList<>();
        int overPrice50 = 0;
        for (Item2 x : a) {
            if (x instanceof Priced2) {
                if (((Priced2) x).price() > 50) {
                    overPrice50++;
                }
            }
        }
        // 你写
        return overPrice50;
    }

    public static void main(String[] args) {
        Item2[] g1 = { new Book2("Java", 59), new Cup2("杯子"), new Pen2("钢笔", 12) };
        Item2[] g2 = { new Cup2("甲") };
        Item2[] g3 = { new Pen2("铅笔", 3), new Book2("算法", 88) };

        Item2[][] gs = { g1, g2, g3 };

        for (int i = 0; i < gs.length; i++) {
            System.out.println("--- " + (i + 1) + " ---");
            System.out.println("最便宜 " + cheapest(gs[i]));
            System.out.println("超过 50 的 " + over50(gs[i]) + " 个");
        }
    }
}
