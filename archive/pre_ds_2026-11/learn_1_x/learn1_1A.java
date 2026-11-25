// 题 learn1_1A（1.1 基础，数组版）—— 门牌号
//
// 只用你已经会的：变量 + 数组。没有链表、没有 next。
// 硬规则：先把下面三行预测填上，再点运行。预测没中 = 没学会。
//   预测① ______99   预测② ______99   预测③ ______5
//
public class learn1_1A {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = a;                    // b 抄了一份 a 手里的门牌号// a与b之间有联系 改一个另一个也会跟着改

        b[0] = 99;                      // 按 b 的门牌进屋，改第一格//a也改了
        System.out.println(a[0]);       // ①

        b = new int[]{7, 8};            // b 换了一张新纸，指向另一间屋子//b完全换新值
        b[0] = 5;                       //改b a不会收到影响
        System.out.println(a[0]);       // ②
        System.out.println(b[0]);       // ③
    }
}
