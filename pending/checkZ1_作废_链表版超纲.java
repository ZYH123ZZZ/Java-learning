// 练手 1.1 —— 门牌号（先预测，再跑）
//
// 硬规则：先把下面三行预测填上，再点运行。预测没中 = 没学会，跟输出对不对无关。
//   预测① ______99   预测② ______77   预测③ ______77
//
public class checkZ1 {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        Node a = head;            // a 抄了一份 head 手里的门牌号
        a.val = 99;               // 按 a 的门牌进屋，改墙上的字
        System.out.println(head.val);       // ①

        a = a.next;               // a 换了一张纸（head 那张没动）
        a.val = 77;
        System.out.println(head.next.val);  // ②

        head.next = null;         // 把 head 手里的"下一个人"擦掉
        System.out.println(a.val);          // ③
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}
