public class checkD10andD11_A {
    public static boolean ishui(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(ishui(s));
        System.out.println(ishui("aasd"));
        System.out.println(ishui("a"));
        System.out.println(ishui(""));
        System.out.println(ishui("ab"));
    }
}
