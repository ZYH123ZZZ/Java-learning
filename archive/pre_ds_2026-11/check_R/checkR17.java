// 复习 17 · 匿名内部类 + effectively final（待复习清单第 17 条，B+ 档，11-22 起）
// 目标 30 分钟。闭卷。禁用：Lambda（`->`）、方法引用（`::`）—— 这题就是考匿名内部类的写法。
// 也不许用 Stream / Files.readAllLines。
//
// 教材：E:\dsh\java\第六周练习.md:147（Day37 一节）
//       匿名内部类写法 :170、:179 ／ 动手任务 :197-243 ／ 常见坑 :247-249
//       坑 2 原文 :248「匿名内部类里要用外面的变量，那个变量必须是 final 或"事实上不变"」
//
// 原题：archive\week_6\Day37总\check\checkD37_C.java（你 11-08 写的 109 行，
//       当年问题：结构走偏——两个匿名类写出来了，但"该打印什么"没按判据走）
//       配套 checkD37_E.java（band 分区间，73 行）
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class checkR17 {

    // ===== 下面这段别改 =====
    // 你自己定义的「规则」接口：一个方法，回答「这一行算不算」
    interface Rule {
        boolean ok(String line);
    }
    // =======================

    // 【1】screen(String path, String keyword, int maxLen) —— 逐行扫一个文本文件
    //
    //   要求：
    //     ① 必须写两个匿名内部类（实现 Rule），一个判「这一行含 keyword」，一个判「这一行长度 > maxLen」
    //        —— 两个都要在方法里 new 出来，不许另写具名类、不许写成 Lambda
    //     ② 两个匿名类里都要直接用到 keyword / maxLen 这两个参数
    //        （这就是 effectively final：参数进了匿名类，就不能再给它赋值）
    //     ③ 文件不存在 → 打印「文件不存在」并 return
    //        文件是 0 字节 → 打印「空文件」并 return
    //     ④ 命中「含 keyword」的行，按行号打印，最多 3 条，格式：
    //            第 2 行: 2026-11-15 08:05 ERROR 数据库连接超时, 重试三次仍失败
    //        多于 3 条时，最后再补一行：  还有 2 条
    //     ⑤ 最后一行统计，格式：
    //            含 ERROR 2 条，超长 1 条
    //        （keyword 是什么就打什么）
    //
    //   判据会这样用：
    //      screen(".../log.txt", "ERROR", 30)  → 含 ERROR 2 条，超长 2 条（第 2、4 行各一条）
    //      screen(".../many.txt", "ERROR", 30) → 含 ERROR 5 条，超长 0 条 + 前 3 条 + 「还有 2 条」
    //      screen(不存在的路径, "ERROR", 30)   → 文件不存在
    //      screen(空文件, "ERROR", 30)         → 空文件
    static void screen(String path, String keyword, int maxLen) throws IOException {
        int count = 0;
        int countR1 = 0;
        int countR2 = 0;
        Rule R1 = new Rule() {
            @Override
            public boolean ok(String line) {
                return line.contains(keyword);
            }
        };

        Rule R2 = new Rule() {
            @Override
            public boolean ok(String line) {
                return line.length() > maxLen;
            }
        };

        File F1 = new File(path);
        if (!F1.exists()) {
            System.out.println("文件不存在");
            return;
        }

        if (F1.length() == 0) {
            System.out.println("空文件");
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                count++;
                if (R2.ok(line)) {
                    countR2++;
                }
                if (R1.ok(line) && countR1 < 3) {
                    System.out.println("第 " + count + " 行: " + line);
                    countR1++;
                    continue;
                }
                if (R1.ok(line)) {
                    countR1++;
                }

            }
            if (countR1 > 3) {
                System.out.println("还有 " + (countR1 - 3) + " 条");
            }
        }
        System.out.println("含 " + keyword + " " + countR1 + " 条，超长 " + countR2 + " 条");
        // 你写
    }

    // ===== 下面是测试脚手架，不要改 =====

    static void put(String p, String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(p))) {
            for (String s : content.split("\n", -1)) {
                bw.write(s);
                bw.newLine();
            }
        }
    }

    static void prepare(String base) throws IOException {
        new File(base).mkdirs();
        put(base + "\\log.txt",
                "2026-11-15 08:00 INFO 启动服务成功\n"
              + "2026-11-15 08:05 ERROR 数据库连接超时, 重试三次仍失败\n"
              + "2026-11-15 08:06 WARN 磁盘剩余空间 12%\n"
              + "ERROR 空指针异常 at A.java:25\n"
              + "2026-11-15 08:10 INFO 全部任务处理完成\n"
              + "临时加一行很长的备注文字用来测试长度阈值到底对不对");
        put(base + "\\many.txt", "ERROR 一号\nERROR 二号\nERROR 三号\nERROR 四号\nERROR 五号");
        new File(base + "\\empty.txt").createNewFile();
    }

    public static void main(String[] args) throws IOException {
        String base = System.getProperty("java.io.tmpdir") + "r17";
        prepare(base);

        System.out.println("判据1 log.txt / ERROR / 30");
        screen(base + "\\log.txt", "ERROR", 30);

        System.out.println("判据2 不存在的文件");
        screen(base + "\\nothing.txt", "ERROR", 30);

        System.out.println("判据3 空文件");
        screen(base + "\\empty.txt", "ERROR", 30);

        System.out.println("判据4 many.txt / ERROR / 30");
        screen(base + "\\many.txt", "ERROR", 30);

        System.out.println("判据5 同一文件换关键词 WARN / 200（换参数结果必须跟着变，说明没硬编码）");
        screen(base + "\\log.txt", "WARN", 200);

        System.out.println("判据6 log.txt 再来一次（结果必须和判据1 完全一样，说明没有 static 残留）");
        screen(base + "\\log.txt", "ERROR", 30);
    }
}
