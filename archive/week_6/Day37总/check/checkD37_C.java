import java.io.*;
import java.nio.charset.StandardCharsets;
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
        File f1 = new File(path);
        if (!f1.exists()) {
            System.out.println("文件不存在");
            return;
        }
        if (f1.length() == 0) {
            System.out.println("空文件");
            return;
        }
        Rule isErr = new Rule() {
            @Override
            public boolean ok(String line) {
                if (line.contains("ERROR")) {
                    return true;
                }
                return false;
            }
        };
        Rule isLongErr = new Rule() {
            @Override
            public boolean ok(String line) {
                if (line.length() > 30) {
                    return true;
                }
                return false;
            }
        };
        int lineNo = 0;
        ArrayList<Integer> a1r = new ArrayList<>();
        ArrayList<String> a2r = new ArrayList<>();
        int LongNo = 0;
        List<String> f1l = new ArrayList<>();
        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br1.readLine()) != null) {
                f1l.add(line);
                lineNo++;
                if (isErr.ok(line)) {
                    a1r.add(lineNo);
                    a2r.add(line);
                }
                if (isLongErr.ok(line)) {
                    LongNo++;
                }
            }
        }
        int i1 = 0;
        for (String x : a2r) {
            if (i1 < 3) {
                System.out.println("第 " + a1r.get(i1) + " 行: " + x);
                i1++;
            }
        }
        if (a2r.size() > 3) {
            System.out.println("还有 " + (a2r.size() - 3) + " 条");
        }
        System.out.println("ERROR " + a2r.size() + " 条，长行 " + LongNo + " 条");
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
