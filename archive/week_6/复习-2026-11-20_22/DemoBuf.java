import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoBuf {

    static void make(String path, byte[] data) throws IOException {
        try (FileOutputStream out = new FileOutputStream(path)) {
            out.write(data);
        }
    }

    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("java.io.tmpdir") + "bufdemo";
        new File(dir).mkdirs();

        // A：1024 个 'x'，一共 1024 字节（短）
        byte[] a = new byte[1024];
        for (int i = 0; i < 1024; i++) {
            a[i] = (byte) 'x';
        }
        make(dir + "\\A.bin", a);

        // B：1029 个 'x'，一共 1029 字节（长 5 个，而且多出来的也是 'x'）
        byte[] b = new byte[1029];
        for (int i = 0; i < 1029; i++) {
            b[i] = (byte) 'x';
        }
        make(dir + "\\B.bin", b);

        System.out.println("A.bin = 1024 字节（1024 个 x）");
        System.out.println("B.bin = 1029 字节（1029 个 x）—— 后面多 5 个，不是 'y'，照样是 'x'");
        System.out.println();

        try (FileInputStream inA = new FileInputStream(dir + "\\A.bin");
             FileInputStream inB = new FileInputStream(dir + "\\B.bin")) {
            byte[] bufA = new byte[1024];
            byte[] bufB = new byte[1024];
            int round = 1;
            while (true) {
                int nA = inA.read(bufA);
                int nB = inB.read(bufB);
                System.out.println("第 " + round + " 轮：nA = " + nA + "，nB = " + nB);

                boolean same = true;
                for (int i = 0; i < 1024; i++) {
                    if (bufA[i] != bufB[i]) {
                        same = false;
                    }
                }
                System.out.println("  硬比 1024 格 → " + (same ? "相等" : "不相等"));

                System.out.println("  bufA[0]    = " + (char) bufA[0] + "   A 这轮读到的第一个字节");
                System.out.println("  bufA[1023] = " + (char) bufA[1023] + "   A 最后一格");
                System.out.println("  bufB[0]    = " + (char) bufB[0] + "   B 这轮读到的第一个字节");
                System.out.println("  bufB[1023] = " + (char) bufB[1023] + "   B 最后一格");
                System.out.println();

                round++;
                if (nA == -1 && nB == -1) {
                    break;
                }
            }
        }

        System.out.println("结论：第 2 轮 A 已经读完（nA = -1），bufA 里 1024 格全是第 1 轮留下的 'x'；");
        System.out.println("      B 这轮只读到 5 个字节，bubB[5] 之后也是第 1 轮留下的。两边残留相同 → 硬比 1024 格显示“相等”。");
        System.out.println("      可实际是：A 一个字节都没有了，B 还有 5 个。这就是假相等。");
    }
}
