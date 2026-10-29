public class ThrowDemo {

    public static void main(String[] args) {
        System.out.println("=== 正常传参 ===");
        setAge(20);

        System.out.println();
        System.out.println("=== 传了个负数，被接住 ===");
        try {
            setAge(-5);
            System.out.println("这行不会执行");
        } catch (IllegalArgumentException e) {
            System.out.println("  抓到了: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== 传了 200，没接住 ===");
        setAge(200);
        System.out.println("这行也不会执行");
    }

    static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("年龄不能是负数: " + age);
        }
        if (age > 150) {
            throw new IllegalArgumentException("年龄太大了: " + age);
        }
        System.out.println("  年龄设为 " + age);
    }
}