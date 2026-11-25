// 题 Y2 —— 泛型类（一个类能装不同东西）
// 你写 class Box<E>：一个私有字段、一个构造方法、一个 get()。
// main 已经写好了，一个字都不用改。
//
// 硬规则（3 条）：
//   1. 先照文档 2.1 抄一遍，跑通；再关掉文档自己写第二遍
//   2. 不许把 String 写死在类里
//   3. 现在这个文件会报错（4 个），报的就是你还空着的那几处
public class checkY2 {

    // ===== 下面不用改 =====
    public static void main(String[] args) {
        Box<String> s = new Box<>("hi");
        Box<Integer> n = new Box<>(7);
        System.out.println("你写出来的： " + s.get() + " / " + n.get());
        System.out.println("期望：       hi / 7");
    }
}

class Box<E> {
    // 你写：private 字段 v；构造方法 Box(E v)；方法 E get()
}
