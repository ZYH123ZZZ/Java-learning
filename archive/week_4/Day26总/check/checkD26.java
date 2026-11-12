public class checkD26 {
    public static void Throwing(int age) throws AgeException_D26 {
        if (age < 0) {
            throw new AgeException_D26("年龄不能是负数: " + age);
            //new AgeException_D26("年龄不能是负数: -1")
//        ↓ 括号里的话先交给「自定义异常」的构造方法
//            super(msg)  往上传
//        ↓
//            Exception 存住
//        ↓ catch 时 e.getMessage() 取回
        }
        System.out.println(age);
    }
    public static void main(String[] args) {
        try {
            Throwing(8);
            Throwing(-1);
            Throwing(9);
        } catch (AgeException_D26 e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("这条一定会执行");
        }

        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("永远执行");
        }

        try {
            return;
        } finally {
            System.out.println("execute anytime");
        }
    }
}
