// static 变量 / static 方法 —— 第一次学（2026-11-19）
// 三个字段：seq 和 sum 是 static（全类共用一份），id 和 amount 是每个对象自己的。

class Order {
    private static int seq = 0;     // 一共造过几个订单，全类共用
    private static double sum = 0;  // 所有订单金额加起来，全类共用

    private int id;                 // 第几号订单，每个对象自己的（从 1 开始）
    private double amount;          // 这单多少钱，每个对象自己的

    // 构造方法：
    //   ① seq 加 1，把它记进 id（第一单是 1）
    //   ② amount 小于 0 就当 0
    //   ③ 把这一单的金额加进 sum
    Order(double amount) {
        if (amount < 0) {
            amount = 0;
        }

        this.amount = amount;
        seq++;
        id = seq;
        sum += amount;
        // 你写
    }

    public int getId() { return id; }
    public double getAmount() { return amount; }

    // 一共造过几个（用类名调：Order.count()）
    public static int count() {
        // 你写
        return seq;
    }

    // 所有订单总金额
    public static double total() {
        // 你写
        return sum;
    }

    // 平均每单多少钱；一个订单都没有时要返回 0，不能除 0
    public static double avg() {
        if (seq == 0) {
            return 0;
        }
        // 你写
        return sum / seq;
    }
}

public class checkS1 {
    public static void main(String[] args) {
        // 还没造任何订单
        System.out.println(Order.count());          // 0
        System.out.println(Order.total());          // 0.0
        System.out.println(Order.avg());            // 0.0

        Order a = new Order(100);
        Order b = new Order(50);
        Order c = new Order(-30);

        System.out.println(a.getId() + " " + b.getId() + " " + c.getId());  // 1 2 3
        System.out.println(c.getAmount());          // 0.0
        System.out.println(Order.count());          // 3
        System.out.println(Order.total());          // 150.0
        System.out.println(Order.avg());            // 50.0
    }
}
