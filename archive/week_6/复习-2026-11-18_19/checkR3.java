// 复习 3 · 嵌套循环（待复习清单第 3 条，B 档，11-18）
// 目标 15 分钟。闭卷。禁用：String.repeat（自己算次数）。
public class checkR3 {

    // 【1】table(int n) —— 打印乘法表的下三角，共 n 行（写法照教材 E:\dsh\java\第二周练习.md:342）
    //     第 i 行打印 i 个式子，第 j 个写成：j×i=i*j
    //     要求：外层循环管「行」（i 从 1 到 n），内层循环管「这一行有几个」（j 从 1 到 i）
    //     同行内用 print 连着打、一个空格隔开；这一行打完再换行
    //
    //     table(3) 的期望输出：
    //     1×1=1
    //     1×2=2 2×2=4
    //     1×3=3 2×3=6 3×3=9
    static void table(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "x" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
        // 你写
    }

    // 【2】stars(int h) —— 打印 h 层金字塔，每层先打空格再打星
    //     第 i 层（i 从 1 开始）：空格 h-i 个，星 2*i-1 个
    //     边界：h <= 0 时什么都不打印（不报错、不打空行）
    //
    //     stars(3) 的期望输出（行尾不能有看不见的多余修正，空格数量要对）：
    //       *
    //      ***
    //     *****
    static void stars(int h) {
        if (h == 0) {
            return;
        }
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= h - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 你写
    }

    public static void main(String[] args) {
        table(3);
        System.out.println("---");
        stars(3);
        System.out.println("---");
        stars(0);          // 什么都不打
        System.out.println("=== 上面这行后面不该有内容 ===");
        table(1);
    }
}
