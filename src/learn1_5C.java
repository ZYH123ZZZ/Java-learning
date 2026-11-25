// 题 learn1_5C（1.5 收尾，约 20 分钟）—— 给类里那个"比内容"的规矩补上
//
// 你这个类 Shop 里已经有一个 equals 了，但它是错的：
//     参数写的是 Shop（不是 Object）→ 它根本没重写到 Object 的那个 equals，
//     只是一个名字碰巧叫 equals 的新方法；里面还用 == 比字符串。
//
// 你要做的：把这个 equals 改对，让 6 条判据全过。
//
// 硬规则（4 条）：
//   1. 只许改 Shop 里的那个 equals（可以加 @Override、加 if、加局部变量）；
//      不许改 main，不许再加上第二个 equals
//   2. 必须给它加 @Override —— 写完编译一次，它会替你检查"这到底算不算重写"
//   3. 不许用 Objects.equals（第六周练习.md:101 有，但今天要你自己处理 null）
//   4. 先把下面三行预测填了，再点运行
//
// 工具说明（不考）：list.contains(x) = 拿 x 去一个个调 equals 比元素，
//   有一个 true 就返回 true（教材没讲这一招，今天只当工具用）。
//
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class learn1_5C {

    static class Shop {
        String name;

        Shop(String n) {
            this.name = n;
        }

        // ↓↓↓ 这个 equals 是错的，改成对的 ↓↓↓
        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof Shop)) {
                return false;
            }
            Shop s = (Shop) other;
            if (s.name == null && name == null) {
                return true;
            }
            if (s.name == null || name == null) {
                return false;
            }
            return name.equals(s.name);
        }
    }

    // ===== 下面不用改 =====
    public static void main(String[] args) {
        String a = new String("苹果");
        String b = new String("苹果");
        Shop p1 = new Shop(a);
        Shop p2 = new Shop(b);
        Shop p3 = new Shop("香蕉");

        List<Shop> list = new ArrayList<>();
        list.add(p1);

        // 预测① p1.equals(p2)                          = true
        // 预测② list.contains(new Shop(new String("苹果"))) = true
        // 预测③ p1.equals(null)                        = false（崩了就直接写"崩"）

        System.out.println("判据1 内容一样的两个对象 p1.equals(p2)           " + p1.equals(p2) + "    期望 true");
        System.out.println("判据2 内容不同的 p1.equals(p3)                   " + p1.equals(p3) + "    期望 false");
        System.out.println("判据3 表里找一个内容相同的 list.contains(new Shop(new String(\"苹果\")))  "
                + list.contains(new Shop(new String("苹果"))) + "    期望 true");
        System.out.println("判据4 用 Object 类型调 p1.equals((Object) p2)     " + p1.equals((Object) p2) + "    期望 true");
        try {
            System.out.println("判据5 p1.equals(null)                          " + p1.equals(null) + "    期望 false");
        } catch (Exception e) {
            System.out.println("判据5 p1.equals(null)                          崩了：" + e.getClass().getSimpleName() + "    期望 false");
        }
        System.out.println("判据6 p1.equals(\"苹果\")                        " + p1.equals("苹果") + "    期望 false");
    }
}
