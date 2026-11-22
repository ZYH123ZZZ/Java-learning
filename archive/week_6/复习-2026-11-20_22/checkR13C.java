// 单点题 23 · read 返回值和缓冲区残留（待复习清单第 23 条，B 档，11-21）
// 目标 10 分钟。闭卷。禁用：Arrays.equals / Files.mismatch（这题考的是"能比几格"）。

public class checkR13C {

    // 【1】firstDiffInBlock(byte[] a, byte[] b, int nA, int nB) —— 这一块里第一个不同字节的下标
    //     a、b 是两个大小 1024 的缓冲区（这题只看前几格，长度给 5 方便数）
    //     nA、nB 是这一轮 read 各自返回的字节数（-1 表示读完了，这题里不会传进来）
    //     只比前 min(nA, nB) 格 —— 第 min 格往后是上一轮残渣，不许碰
    //     前 min(nA, nB) 格全相同 → 返回 -1
    //
    //     教材：E:\dsh\java\第五周练习.md:618「n 是实际读到的字节数，不是 1024」
    //
    //     firstDiffInBlock(new byte[]{x,x,x,x,x}, new byte[]{x,x,x,x,x}, 5, 5) → -1
    static int firstDiffInBlock(byte[] a, byte[] b, int nA, int nB) {
        int min = nA;
        if (min > nB) {
            min = nB;
        }

        int count = 0;
        for (int i = 0; i < min; i++) {
            if (a[i] != b[i]) {
                return count;
            }
            count++;
        }
        // 你写
        return -1;
    }

    static byte[] fill(int len) {
        byte[] x = new byte[len];
        for (int i = 0; i < len; i++) {
            x[i] = (byte) 'x';
        }
        return x;
    }

    public static void main(String[] args) {
        byte[] a = fill(5);
        byte[] b = fill(5);

        System.out.println("判据1 两个 5 格全相同            → " + firstDiffInBlock(a, b, 5, 5) + "   期望 -1");

        byte[] a2 = fill(5);
        a2[2] = (byte) 'q';
        System.out.println("判据2 第 2 格不同                → " + firstDiffInBlock(a2, b, 5, 5) + "   期望 2");

        byte[] a3 = fill(5);
        a3[3] = (byte) 'z';
        a3[4] = (byte) 'z';
        System.out.println("判据3 a 只有前 3 格有效，后面是残渣 → " + firstDiffInBlock(a3, b, 3, 5) + "   期望 -1");

        byte[] a4 = fill(5);
        a4[4] = (byte) 'w';
        System.out.println("判据4 最后一格不同               → " + firstDiffInBlock(a4, b, 5, 5) + "   期望 4");
    }
}
