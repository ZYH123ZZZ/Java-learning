public class checkD26 {
    public static void Throwing(int age) throws Exception {
        if (age < 0) {
            throw new AgeException_D26();//括号里面不知道干啥
        }
    }
    public static void main(String[] args) {
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
        }finally {
        }
    }
}
