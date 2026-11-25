// 题 learn1_5A（1.5 用新东西之前先问"它按什么算一样"，约 25 分钟）
//
// 背景：下面这个 Name 类**没有重写 equals**。
// 它手里只有 Object 给的那个 equals —— 那个 equals 比的是"是不是同一间屋"，不是"内容一不一样"。
//
// 你要做两件事：
//   A. 填 5 行预测（跑之前填，空格里写 true / false）
//   B. 写一个 sameName 方法：两个 Name 的 name 内容一样就返回 true，不一样返回 false
//
// 硬规则（4 条）：
//   1. 先填 5 行预测，再点运行；空着交 = 不算
//   2. 不许改 Name 类，不许用 Objects.equals / Objects.hash，不许用 Stream
//   3. sameName 里不许用 == 去比两个字（== 比的是门牌号）
//   4. 只写 sameName 这一个方法，别的地方一个字都不许动
//
public class learn1_5A {

    static class Name {
        String name;

        Name(String name) {
            this.name = name;
        }
    }

    // 你写
    static boolean sameName(Name x, Name y) {
        return x.name.equals(y.name);
    }

    // ===== 下面不用改 =====
    public static void main(String[] args) {
        Name n1 = new Name("张三");
        Name n2 = new Name("张三");
        Name n3 = new Name("李四");

        // 预测① n1 == n2            →  false
        // 预测② n1.equals(n2)       →  true
        // 预测③ "张三".equals(n2.name) →  true
        // 预测④ sameName(n1, n2)    →  true// 这里不对
        // 预测⑤ sameName(n1, n3)    →  false

        System.out.println("判据1 n1 == n2:               " + (n1 == n2) + "      期望 false");
        System.out.println("判据2 n1.equals(n2):          " + n1.equals(n2) + "      期望 false（Name 没重写 equals）");
        System.out.println("判据3 \"张三\".equals(n2.name):  " + "张三".equals(n2.name) + "       期望 true（String 重写过）");
        System.out.println("判据4 sameName(n1, n2):       " + sameName(n1, n2) + "       期望 true");
        System.out.println("判据5 sameName(n1, n3):       " + sameName(n1, n3) + "      期望 false");
    }
}
