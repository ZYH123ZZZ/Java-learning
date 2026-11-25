// 题 checkR19（复习台账 #19 方法引用三形态，闭卷，约 40 分钟）
//
// 三处占位都写了假的 lambda（-1 / 空动作），你要把三处全换成"方法引用"写法。
// 最终交上来的文件里，这三处不许再出现 -> ，只许出现 :: 。
//
// 三种形态：
//   ① 静态方法引用      —— 用"类名"调一个 static 方法
//   ② 指定对象的实例方法 —— 用"已经存在的那个对象"调它的实例方法
//   ③ 未绑定实例方法引用 —— 用"类名::实例方法"，第一个参数当调用者
//
// 硬规则（4 条）：
//   1. 只改三个占位行，main 里一个字都不许动
//   2. 三处最终都必须是 :: 写法，不许用 lambda、不许写匿名类
//   3. 先填下面三行预测，再点运行
//   4. 闭卷：不翻文档、不问我；卡住就在这行注释里写"卡在哪"
//
// 不许自己加判据、不许新建测试类，交上来我自己编译跑。
//
import java.util.function.Consumer;
import java.util.function.Function;

public class checkR19 {

    // ① 把 "42" 变成 42       —— 你写（现在是假 lambda）
    static Function<String, Integer> toInt =(Integer::parseInt);

    // ② 往 sb 里追加           —— 你写（现在是空动作）
    static StringBuilder sb = new StringBuilder();
    static Consumer<String> appendToSb = sb::append;

    // ③ "hello" 变成 5        —— 你写（现在是假 lambda）
    static Function<String, Integer> len =(String::length);

    // ===== 下面不用改 =====
    public static void main(String[] args) {

        // 预测① toInt.apply("42") = ______42
        // 预测② appendToSb.accept("ab") 之后，sb 里是 ______ab ；再 sb.append("!") 之后是 ______ab!
        // 预测③ len.apply("hello") = ______5

        System.out.println("判据1 ①静态方法引用:   " + toInt.apply("42") + "    期望 42");

        appendToSb.accept("ab");
        System.out.println("判据2 ②对象实例引用:   " + sb + "    期望 ab");

        sb.append("!");
        System.out.println("判据3 用完还能接着用: " + sb + "    期望 ab!");

        System.out.println("判据4 ③未绑定实例引用: " + len.apply("hello") + "    期望 5");
    }
}
