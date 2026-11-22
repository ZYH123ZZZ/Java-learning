// 复习 13 · 逐块比较两个文件（待复习清单第 13 条，C 档，11-20）
// 目标 20 分钟。闭卷。禁用：Files.mismatch / Files.readAllBytes（一次性读满）；必须 byte[1024] 逐块。
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class checkR13 {

    // 【1】isCompareTrue(String pathA, String pathB) —— 两个文件内容完全一样返回 true，否则 false
    //     一次读一块 1024 字节比，不许整个文件读进内存
    //     大小不同就是 false（不用比内容）；长度相等还要一字节一字节确认
    //     教材：复制标准写法 E:\dsh\java\第五周练习.md:603-608
    //           「n 是实际读到的字节数，不是 1024」:618
    //
    //     isCompareTrue(a.txt, b.txt) → 内容一样就 true
    //     isCompareTrue(10字节文件, 同前缀的3字节文件) → false
    static boolean isCompareTrue(String pathA, String pathB) {
        File A1 = new File(pathA);
        File B1 = new File(pathB);

        if (A1.length() != B1.length()) {
            return false;
        }

        try (FileInputStream InA1 = new FileInputStream(A1);
        FileInputStream InB1 = new FileInputStream(B1)) {
            byte[] bufA = new byte[1024];//还是不理解字节流的工作原理 实际上是把读取到的字节暂时存入byte[]里面
            byte[] bufB = new byte[1024];
            int nA;
            int nB;
            while (((nA = InA1.read(bufA)) != -1)&&((nB = InB1.read(bufB)) != -1)) {
                for (int i = 0; i < bufA.length; i++) {
                    if (bufA[i] != bufB[i]) {//一个字节一个字节比 还是因为当时不理解工作原理
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 你写（下面这行是占位，写完删掉）
        return true;
    }

    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("java.io.tmpdir") + "r13check";
        new java.io.File(dir).mkdirs();

        // 造测试文件：same1/same2 一样；short 是 same1 的前 3 字节；big1 3000 字节；big2 只有第 2000 字节不同
        byte[] ten = "0123456789".getBytes("UTF-8");
        byte[] three = "012".getBytes("UTF-8");
        byte[] bigA = new byte[3000];
        for (int i = 0; i < bigA.length; i++) {
            bigA[i] = (byte) (i % 251);
        }
        byte[] bigB = bigA.clone();
        bigB[2000] = (byte) 'X';
        try (FileOutputStream o1 = new FileOutputStream(dir + "\\same1.bin");
             FileOutputStream o2 = new FileOutputStream(dir + "\\same2.bin");
             FileOutputStream o3 = new FileOutputStream(dir + "\\short.bin");
             FileOutputStream o4 = new FileOutputStream(dir + "\\big1.bin");
             FileOutputStream o5 = new FileOutputStream(dir + "\\big2.bin")) {
            o1.write(ten);
            o2.write(ten);
            o3.write(three);
            o4.write(bigA);
            o5.write(bigB);
        }

        // 判据 1：一样就是 true（10 字节）
        System.out.println("判据1 same1 vs same2 → " + isCompareTrue(dir + "\\same1.bin", dir + "\\same2.bin")
                + "   期望 true");

        // 判据 2：大小不同 → false（前面内容一样也不行）
        System.out.println("判据2 same1 vs short → " + isCompareTrue(dir + "\\same1.bin", dir + "\\short.bin")
                + "   期望 false");

        // 判据 3：3000 字节跨三块，差异只在第 2000 字节 → false
        System.out.println("判据3 big1 vs big2 → " + isCompareTrue(dir + "\\big1.bin", dir + "\\big2.bin")
                + "   期望 false");

        // 判据 4：3000 字节跨三块，完全一样 → true（只比第一块就漏了）
        System.out.println("判据4 big1 vs big1 → " + isCompareTrue(dir + "\\big1.bin", dir + "\\big1.bin")
                + "   期望 true");
    }
}
