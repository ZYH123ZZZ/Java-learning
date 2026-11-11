public class checkD10andD11_B {
    public static String a1(String s) {
        if (s.lastIndexOf(".") > 0) {
            s = s.substring(s.lastIndexOf(".") + 1, s.length());
        } else {
            return "没有后缀";
        }
        return s;
    }
    public static void main(String[] args) {
        String[] files = {"a.txt", "Main.java", "README", "archive.tar.gz"};
        for (String x : files) {
            System.out.println(a1(x));
        }
    }
}
