// 复习 5 · 接口方法的强转调用（待复习清单第 5 条，B 档，11-18）
// 目标 15 分钟。闭卷。
// 教材：E:\dsh\java\第五周练习.md（接口与多态那一节）、查漏清单第 9 题 9-B

interface Scalable {
    void scale(int k);
}

class Shape {                       // 父类，没有 scale 方法
    String name;

    Shape(String name) {
        this.name = name;
    }
}

class Circle extends Shape implements Scalable {
    int r;

    Circle(int r) {
        super("圆");
        this.r = r;
    }

    public void scale(int k) {      // 半径乘 k
        r = r * k;
    }
}

class Rect extends Shape {          // 只继承 Shape，没实现 Scalable
    int w, h;

    Rect(int w, int h) {
        super("矩形");
        this.w = w;
        this.h = h;
    }
}

public class checkR5 {

    // scaleAll(Shape[] a, int k) —— 遍历数组
    //     能缩放的（实现了 Scalable 的）调 scale(k)，不能缩放的跳过
    //     返回「真正缩放了几个」
    //
    //     注意：a[i] 的编译期类型是 Shape，Shape 里没有 scale 方法
    //          直接 a[i].scale(k) 编译不过 —— 要强转
    static int scaleAll(Shape[] a, int k) {
        int truein = 0;
        for (Shape x : a) {
            if (x instanceof Scalable) {
                ((Scalable) x).scale(k);
                truein++;
            }
        }
        // 你写
        return truein;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(2);
        Circle c2 = new Circle(5);
        Rect r1 = new Rect(3, 4);

        Shape[] arr = {c1, r1, c2};                          // 混装：2 个能缩放、1 个不能
        System.out.println("缩放了 " + scaleAll(arr, 3) + " 个");

        System.out.println("圆1 半径 " + c1.r);              // 期望 6
        System.out.println("圆2 半径 " + c2.r);              // 期望 15
        System.out.println("矩形 " + r1.w + "x" + r1.h);     // 期望 3x4（没被动过）
    }
}
