import java.util.Scanner;

public class Day26B {
    public static boolean isTrue(String password) {
        if (password.trim().length() < 6 && password.trim().length()!=0) {
            throw new RuntimeException("密码长度不能小于6位" + "(当前" + password.trim().length() + "位）");
        }
        if (password.trim().length() == 0) {
            throw new RuntimeException(" 密码不能全是空格");
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            try {
                String password = sc.nextLine();
                isTrue(password);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("成功设置密码");
    }
}
