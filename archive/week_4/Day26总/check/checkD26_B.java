public class checkD26_B {
    public static void Ex(int a) {
            if (a > 100 || a < 0) {
                throw new BeyondnumException("成绩不能低于0分或者高于100");
            }

    }
    public static void main(String[] args) {
        int[] a1 = {88, -5, 60, 120, 90};//这里不要try包裹循环 要循环包裹try
            for (int i = 0; i < a1.length; i++) {
                try {
                    Ex(a1[i]);
                } catch (BeyondnumException e) {
                    System.out.println("第 " + (i + 1) + " 个" + e.getMessage() + " " + a1[i]);
                } finally {
                    System.out.println("第 " + (i + 1) + " 个审完" + " " + a1[i]);
                }
            }
    }
}
