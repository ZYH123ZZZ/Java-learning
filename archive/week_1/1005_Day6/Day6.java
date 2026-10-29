public class Day6 {
    public static void main(String[] args) {
        int[] scores = {88, 92, 75, 100, 61};

        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            System.out.println("第 " + (i + 1) + " 个成绩：" + scores[i]);
            sum = sum + scores[i];
        }

        double avg = sum / (double) scores.length;
        System.out.println("总分：" + sum);
        System.out.println("平均分：" + avg);

        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        System.out.println("最高分：" + max);

        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        System.out.println("最小值是 " + min);

    }
}
