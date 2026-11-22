// 复习 13B · 逐块比较（换骨架：返回第一个不同的位置）（11-20 加练）
// 目标 25 分钟。闭卷。禁用：Files.mismatch / Files.readAllBytes；必须 byte[1024] 逐块。
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class checkR13B {

    // 【1】firstDiff(String pathA, String pathB) —— 找两个文件第一个内容不同的字节，返回它的位置
    //     位置从 0 开始数；完全相同返回 -1
    //     一个文件是另一个的前缀（前面全一样、只是短了），返回「短的那个的长度」
    //     一次读 1024 字节，位置要跨块往后累加
    //     教材：标准搬运 E:\dsh\java\第五周练习.md:603-608；「n 是实际读到的字节数」:618
    //
    //     firstDiff(a, b) 两个都是 "0123456789" → -1
    //     firstDiff("012X456789", "0123456789") → 3
    static long firstDiff(String pathA, String pathB) {
        long countByte = 0;
        try (FileInputStream InA = new FileInputStream(pathA);
             FileInputStream InB = new FileInputStream(pathB)) {
            byte[] bA = new byte[1024];
            byte[] bB = new byte[1024];
            int nA;//不会
            int nB;//不会
            do {
                nA = InA.read(bA);
                nB = InB.read(bB);

                int m = nA;
                if (nB < m) {
                    m = nB;
                }

                if (nA != -1 && nB != -1) {
                    for (int i = 0; i < m; i++) {
                        if (bA[i] != bB[i]) {
                            return countByte;
                        }
                        countByte++;
                    }
                }

                if (nA != nB) {
                    return countByte;
                }

                if (nA == -1 && nB == -1) {
                    return -1;
                }
            } while (true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 你写
    }


    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("java.io.tmpdir") + "r13bcheck";
        new File(dir).mkdirs();

        byte[] ten = "0123456789".getBytes("UTF-8");
        byte[] tenX = "012X456789".getBytes("UTF-8");
        byte[] three = "012".getBytes("UTF-8");
        byte[] bigA = new byte[3000];
        for (int i = 0; i < bigA.length; i++) {
            bigA[i] = (byte) (i % 251);
        }
        byte[] bigB = bigA.clone();
        bigB[2000] = (byte) 'X';
        try (FileOutputStream o1 = new FileOutputStream(dir + "\\same.bin");
             FileOutputStream o2 = new FileOutputStream(dir + "\\sameX.bin");
             FileOutputStream o3 = new FileOutputStream(dir + "\\short.bin");
             FileOutputStream o4 = new FileOutputStream(dir + "\\big1.bin");
             FileOutputStream o5 = new FileOutputStream(dir + "\\big2.bin")) {
            o1.write(ten);
            o2.write(tenX);
            o3.write(three);
            o4.write(bigA);
            o5.write(bigB);
        }

        // 判据 1：完全一样 → -1
        System.out.println("判据1 一样 → " + firstDiff(dir + "\\same.bin", dir + "\\same.bin")
                + "   期望 -1");

        // 判据 2：第 4 个字节不同（位置 3）→ 3
        System.out.println("判据2 第4个字节不同 → " + firstDiff(dir + "\\sameX.bin", dir + "\\same.bin")
                + "   期望 3");

        // 判据 3：3000 字节，差异在第 2000 个 → 2000（位置要跨块累加）
        System.out.println("判据3 跨块差异 → " + firstDiff(dir + "\\big1.bin", dir + "\\big2.bin")
                + "   期望 2000");

        // 判据 4：10 字节 vs 它的前 3 字节 → 3（短的那个的长度）
        System.out.println("判据4 前缀关系 → " + firstDiff(dir + "\\same.bin", dir + "\\short.bin")
                + "   期望 3");
    }
}
