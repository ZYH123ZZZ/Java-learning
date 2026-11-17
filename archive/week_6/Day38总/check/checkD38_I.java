import java.util.*;

public class checkD38_I {

    // 你只写这个：一个参数、void、自己打印
    static void runAll(List<Runnable> jobs) {
        int count1 = 0;
        int count2 = 0;
        for (Runnable x : jobs) {
            count1++;
            System.out.println(count1 + " 开始");
            try {
                x.run();
                System.out.println(count1 + " 完成");
                count2++;
            } catch (RuntimeException e) {
                System.out.println(count1 + " 失败: " + e.getMessage());
            }
        }

        System.out.println("共 " + count1 + " 个任务，成功 " + count2 + " 个");
        // 你写
    }

    public static void main(String[] args) {
        List<String> bag = new ArrayList<>(List.of("a"));
        List<Runnable> jobs = new ArrayList<>();
        jobs.add(() -> System.out.println("  正在备份"));
        jobs.add(bag::clear);
        jobs.add(() -> { throw new RuntimeException("磁盘满了"); });

        System.out.println("--- i1 ---");
        runAll(jobs);
        System.out.println("bag 现在: " + bag);
        System.out.println("--- i2 空表 ---");
        runAll(new ArrayList<>());
    }
}
