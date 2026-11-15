import java.util.*;

class Student36 {
    int id;
    String name;
    String remark;

    Student36(int id, String name, String remark) {
        this.id = id;
        this.name = name;
        this.remark = remark;
    }

    // ① equals：照四步写
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student36)) {
            return false;
        }
        Student36 s = (Student36) o;
        return Objects.equals(s.name, name) && s.id == id;
    }

    // ② hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id,name);
    }

    // ③ toString
    @Override
    public String toString() {
        return "{ name = " + name + " id = " + id + " remark = " + remark + " }";
    }
}

public class checkD36_C {

    public static void main(String[] args) {
        Student36 a = new Student36(1, "张三", "新生");
        Student36 b = new Student36(1, new String("张三"), "复读");
        Student36 c = new Student36(2, "张三", "新生");
        Student36 d = new Student36(1, "李四", "新生");

        System.out.println("1 同号同名不同备注 equals = " + a.equals(b));
        System.out.println("2 两者 hashCode 相等 = " + (a.hashCode() == b.hashCode()));
        System.out.println("3 不同学号 equals = " + a.equals(c));
        System.out.println("4 同名不同姓名 equals = " + a.equals(d));
        System.out.println("5 自己 == 自己 = " + a.equals(a));
        System.out.println("6 跟 null 比 = " + a.equals(null));
        System.out.println("7 跟字符串比 = " + a.equals("张三"));

        Set<Student36> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        System.out.println("8 三只进 HashSet 大小 = " + set.size());

        System.out.println("9 打印一只 = " + a);

        a.remark = "毕业";
        System.out.println("10 改备注后 contains = " + set.contains(a) + "，大小 = " + set.size());

        a.name = "王五";
        System.out.println("11 改姓名后 contains = " + set.contains(a) + "，大小 = " + set.size());
        System.out.println("12 再 add 一次 = " + set.add(a) + "，大小 = " + set.size());
    }
}
