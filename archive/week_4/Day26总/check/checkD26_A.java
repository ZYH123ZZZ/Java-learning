public class checkD26_A {
    public static int collectString(String a, String b) throws MyArithmeticException {
        if (b.equals("0")) {//还是用== 忘记用equal 提示了才想起来
            throw new MyArithmeticException("除数不能为0： " + b);
        }
        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        return (a1 / b1);
    }
    public static void main(String[] args) {
        try {
            System.out.println(collectString("10", "2"));
            System.out.println(collectString("10", "0"));
            System.out.println(collectString("abc", "2"));
        } catch (MyArithmeticException e) {
            System.out.println(e.getMessage());
        }catch (NumberFormatException e) {
            System.out.println("不是数字: " + e.getMessage());
        }  finally {
            System.out.println("跑完");
        }

    }
}
