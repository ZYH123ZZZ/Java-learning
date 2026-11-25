// 复习 16 · equals / hashCode / toString（待复习清单第 16 条，B 档，11-21 起）
// 目标 25 分钟。闭卷。禁用：IDEA 的 Alt+Insert 自动生成、Lombok。
//
// 教材：E:\dsh\java\第六周练习.md:71（Day36 一节）
//       equals 四步 :93-103 ／ hashCode :107-116 ／ toString :118-125
//       四步验证表 :127 ／ 四个常见坑 :138-143
//
// 原题：archive\week_6\Day36总\check\BookD36.java（你 11-07 写的 33 行）
// 这次重写，字段顺序照原题：id 在前、name 在后。
import java.util.HashSet;
import java.util.Objects;

public class checkR16 {

    // 【1】实体类 Book —— 字段、构造已经给你，三个方法全部自己写
    //
    //     equals(Object o)   四步一步不能少：① this == o ② instanceof ③ 强转 ④ 逐字段比
    //                        参数类型必须照教材写，写窄了就不是重写而是重载（常见坑 3）
    //     hashCode()         算的字段必须和 equals 比的一模一样（教材 :116）
    //     toString()         必须输出 Book{id=1, name=Java} 这个格式（冒号、逗号、空格都对上）
    //
    //     判据会这样用：
    //       new Book("Java", 1).equals(new Book("Java", 1))  → true
    //       new Book("Java", 1).equals(new Book("Java", 23)) → false
    //       new Book("Java", 1).hashCode() == new Book("Java", 1).hashCode() → true
    //       System.out.println(new Book("Java", 1))          → Book{id=1, name=Java}
    static class Book {
        int id;
        String name;

        Book(String name, int id) {
            this.name = name;
            this.id = id;
        }

        // 你写 equals
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Book)) {
                return false;
            }
            Book b = (Book) o;
            return (Objects.equals(b.name,name)) && b.id == id;
        }

        // 你写 hashCode
        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }

        // 你写 toString
        @Override
        public String toString() {
            return "Book{id=" + id + ", name=" + name + "}";
        }
    }

    // ===== 下面是测试脚手架，不要改 =====

    public static void main(String[] args) {
        Book b1 = new Book("Java", 1);
        Book b2 = new Book("Java", 1);
        Book b3 = new Book("Java", 23);

        System.out.println("判据1  b1.equals(b2) → " + b1.equals(b2) + "   期望 true");
        System.out.println("判据1  b1.equals(b3) → " + b1.equals(b3) + "   期望 false");

        System.out.println("判据2  hashCode 相等 → " + (b1.hashCode() == b2.hashCode()) + "   期望 true");

        HashSet<Book> hs = new HashSet<>();
        hs.add(b1);
        hs.add(b2);
        hs.add(b3);
        System.out.println("判据3  HashSet 大小 → " + hs.size() + "   期望 2");

        String s = String.valueOf(b1);
        System.out.println("判据4  println(b1) → [" + s + "]");
        System.out.println("判据4  字符串严格相等 → " + s.equals("Book{id=1, name=Java}")
                + "   期望 true（形如 Book@1b6d3586 就是没重写）");
    }
}
