// 封装 · 第二道（2026-11-19）—— 和 checkE1 换个骨架：
// ① 没有 setter，数量只能通过 add / take 改
// ② 校验失败不打印，靠 return 值告诉外面成没成
// ③ low() / gap() 是"现算"的派生值，不许另外加字段存

class Stock {
    private String name;   // 商品名，空或 null → "未命名"
    private int qty;       // 库存数量，小于 0 → 0
    private int warn;      // 警戒线，小于 0 → 0

    // 构造方法：三个字段都要兜底，参照 checkE1 最后那版"先赋再修"
    Stock(String name, int qty, int warn) {
        this.name = name;
        this.qty = qty;
        this.warn = warn;
        if (name == null || name.isEmpty()) {
            this.name = "未命名";
        }
        if (qty < 0) {
            this.qty = 0;
        }
        if (warn < 0) {
            this.warn = 0;
        }

        // 你写
    }

    public String getName() { return name; }
    public int getQty() { return qty; }
    public int getWarn() { return warn; }

    // 入库：n <= 0 → 返回 false、数量不变；否则加上去返回 true
    public boolean add(int n) {
        if (n <= 0) {
            return false;
        }

        this.qty += n;
        // 你写
        return true;
    }

    // 出库：n <= 0 → false；n > qty → false（数量不变）；否则扣掉返回 true
    public boolean take(int n) {
        if (n <= 0 || n > this.qty) {
            return false;
        }

        this.qty -= n;
        // 你写
        return true;
    }

    // 派生：数量已经到警戒线或更低
    public boolean low() {
        if (this.qty <= this.warn) {
            return true;
        }
        // 你写
        return false;
    }

    // 派生：离警戒线还差多少（可能为负，负数表示超了）
    public int gap() {
        // 你写
        return this.warn - this.qty;
    }

    // 打印：名字 库存 数字  到了警戒线就在后面加 " [低]"
    void show() {
        if (low()) {
            System.out.println("名字: " + this.name + " 库存：" + this.qty + " [低]");
            return;
        }
        System.out.println("名字: " + this.name + " 库存：" + this.qty);

        // 你写
    }
}

public class checkE2 {
    public static void main(String[] args) {
        Stock s = new Stock("键盘", 3, 5);
        s.show();                          // 键盘 库存 3 [低]
        System.out.println(s.add(10));     // true
        s.show();                          // 键盘 库存 13
        System.out.println(s.take(5));     // true
        s.show();                          // 键盘 库存 8
        System.out.println(s.take(100));   // false
        System.out.println(s.take(0));     // false
        s.show();                          // 键盘 库存 8
        System.out.println(s.low());       // false
        System.out.println(s.gap());       // -3

        Stock t = new Stock("", 0, 2);
        t.show();                          // 未命名 库存 0 [低]
        System.out.println(t.add(-5));     // false
        System.out.println(t.gap());       // 2
    }
}
