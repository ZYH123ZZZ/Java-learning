import java.io.*;
import java.util.*;

public class checkD37_C {

    // ===== 下面这段别改 =====
    // 你自己定义的"规则"接口：一个方法，回答"这一行算不算"
    interface Rule {
        boolean ok(String line);
    }
    // =======================

    // 只有一个参数、void、自己打印
    static void screen(String path) throws IOException {
        // 你写
    }

    static void put(String p, String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(p))) {
            for (String s : content.split("\n", -1)) {
                bw.write(s);
                bw.newLine();
            }
        }
    }

    static void prepare() throws IOException {
        new File("data/d37c").mkdirs();
        put("data/d37c/log.txt",
                "2026-11-15 08:00 INFO 启动服务成功\n"
              + "2026-11-15 08:05 ERROR 数据库连接超时, 重试三次仍失败\n"
              + "2026-11-15 08:06 WARN 磁盘剩余空间 12%\n"
              + "ERROR 空指针异常 at checkD36_C.java:25\n"
              + "2026-11-15 08:10 INFO 全部任务处理完成\n"
              + "临时加一行很长的备注文字用来测试长度阈值到底对不对");
        new File("data/d37c/empty.txt").createNewFile();
        put("data/d37c/many.txt", "ERROR 一号\nERROR 二号\nERROR 三号\nERROR 四号\nERROR 五号");
    }

    public static void main(String[] args) throws IOException {
        prepare();
        System.out.println("--- g1 data/d37c/log.txt ---");
        screen("data/d37c/log.txt");
        System.out.println("--- g2 不存在 ---");
        screen("data/d37c/nothing.txt");
        System.out.println("--- g3 空文件 ---");
        screen("data/d37c/empty.txt");
        System.out.println("--- g4 五条 ERROR ---");
        screen("data/d37c/many.txt");
    }
}
