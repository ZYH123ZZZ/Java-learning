import java.util.Scanner;

public class Day11A {
    public static String getName(String email) {
        return email.substring(0,email.indexOf("@"));
    }

    public static String getDomain(String email) {
        return email.substring(email.indexOf("@") + 1);
    }

    public static boolean isQQ(String email) {
        return getDomain(email).toLowerCase().equals("qq.com");
    }

    public static boolean isCom(String email) {
        return getDomain(email).toLowerCase().contains(".com");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入邮箱：");
        String email = sc.nextLine();

        System.out.println("用户名： " + getName(email));
        System.out.println("域名： " + getDomain(email));
        System.out.println("是 QQ 邮箱吗：" + isQQ(email));
        System.out.println("是 .com 邮箱吗：" + isCom(email));

    }
}
