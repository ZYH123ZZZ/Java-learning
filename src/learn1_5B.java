// 题 learn1_5B（1.5 第二道：谁在点号前面，就由谁说了算，约 20 分钟）
//
// 这题不用写代码，只做判断 + 说理由。八行输出，全部先预测再运行。
//
// 硬规则（3 条）：
//   1. 八行预测全填 true / false，填完再运行；空着交 = 不算
//   2. 每一行后面写一句理由，格式固定："因为 ______ 在调 equals" 或 "因为 == 只比 ______"
//   3. 不许改 main 里的任何一个字，也不许改 Shop 类
//
public class learn1_5B {

    static class Shop {
        String name;

        Shop(String name) {
            this.name = name;
        }
    }

    // ===== 你要填的 =====
    //
    // 预测① a1 == a2                        → true   理由：因为==左右两边全是integer就不是比地址//纠正 false
    // 预测② a1.equals(a2)                   → false   理由： 地址不一样 //纠正 true
    // 预测③ s1 == s2                        → false   理由：地址不一样 == 比的是地址
    // 预测④ s1.equals(s2)                   → true   理由： 因为头部是String 所以调用String里面的equals 比的内容//我还想问还有啥类写过equals
    // 预测⑤ p1 == p2                        → false   理由： 比地址
    // 预测⑥ p1.equals(p2)                   → false   理由： 没有重写过equals
    // 预测⑦ p1.name.equals(p2.name)         → true   理由： name把String取出来了 比的是String的equals
    // 预测⑧ p1.toString().equals(p2.toString()) → false   理由：toString出来的是哈希值
    //
    // 最后一问（一句话）：要让两个 Shop 的"内容一样"被判成一样，你会让谁去调 equals？
    // 答：


    // ===== 下面不用改 =====
    public static void main(String[] args) {
        Integer a1 = 1200;
        Integer a2 = 1200;

        String s1 = new String("hi");
        String s2 = new String("hi");

        Shop p1 = new Shop("苹果");
        Shop p2 = new Shop("苹果");

        System.out.println("① a1 == a2                          → " + (a1 == a2));
        System.out.println("② a1.equals(a2)                     → " + a1.equals(a2));
        System.out.println("③ s1 == s2                          → " + (s1 == s2));
        System.out.println("④ s1.equals(s2)                     → " + s1.equals(s2));
        System.out.println("⑤ p1 == p2                          → " + (p1 == p2));
        System.out.println("⑥ p1.equals(p2)                     → " + p1.equals(p2));
        System.out.println("⑦ p1.name.equals(p2.name)           → " + p1.name.equals(p2.name));
        System.out.println("⑧ p1.toString().equals(p2.toString()) → " + p1.toString().equals(p2.toString()));
    }
}
