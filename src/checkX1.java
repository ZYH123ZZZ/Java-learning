// checkX1  盲区诊断① 引用改链 / 别名陷阱
//
// 硬规则（违反就不算这题的结果）
//   1) 第 1 步不许运行、不许加 println、不许改 rebuild / cutSecond 的代码：
//      先在纸上画出每一步之后 a / b / head 各指向哪个对象（栈里谁存箭头、堆里几个框）。
//   2) 预测写进下面的「预测」注释里，写完才允许运行 main 核对。预测没中算没过，哪怕输出最后是对的。
//   3) 第 3 步 removeByValue 闭卷写。代码上方补一行不变量注释：head / prev / cur 各代表什么。
//
// 预测（先填，别先跑）
//   rebuild(a) 之后：   a 指向 ____ ，b 指向 ____
//   cutSecond(a) 之后：从 a 遍历输出 ____，从 b 遍历输出 ____
//   一句话：rebuild 里 new 的对象为什么影响不到 a，cutSecond 改 next 却影响了 a？

public class checkX1 {

    static class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
    }

    // 以下两个方法不要改，它们是题面
    static void rebuild(Node head) {
        head = new Node(9);
        head.next = null;
    }

    static void cutSecond(Node head) {
        head.next = head.next.next;
    }

    static Node removeByValue(Node head, int target) {
        // 你写：删第一个值等于 target 的节点，返回新的头
        //   target 在头节点 → 要换头
        //   找不到 → 返回原链（原链一个节点都不许少）
        //   空链 → 返回 null
        return null;
    }

    static Node build(int... vals) {
        Node head = null;
        for (int i = vals.length - 1; i >= 0; i--) {
            Node n = new Node(vals[i]);
            n.next = head;
            head = n;
        }
        return head;
    }

    static void print(Node head) {
        if (head == null) { System.out.println("null"); return; }
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(' ');
            head = head.next;
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        Node b = a.next;

        rebuild(a);
        cutSecond(a);

        System.out.print("判据1 a 链: ");
        print(a);
        System.out.print("判据1 b 链: ");
        print(b);

        System.out.print("判据2 删 2:     ");
        print(removeByValue(build(1, 2, 3), 2));
        System.out.print("判据2 删 1:     ");
        print(removeByValue(build(1, 2, 3), 1));
        System.out.print("判据2 删 9:     ");
        print(removeByValue(build(1, 2, 3), 9));

        System.out.print("隐藏1 空链:     ");
        print(removeByValue(null, 1));
        System.out.print("隐藏2 单节点删它: ");
        print(removeByValue(build(7), 7));
        System.out.print("隐藏3 删尾部:   ");
        print(removeByValue(build(1, 2, 3), 3));
    }
}
