import java.util.HashSet;
import java.util.Scanner;

public class Day36 {
    public static void type1(Dog2 dt1, Dog2 dt2) {//1
        if (dt1.equals(dt2)) {
            System.out.println("这两只狗是一样的");
        } else {
            System.out.println("这两只狗不一样");
        }
        System.out.println("哈希: " + dt1.hashCode() + " vs " + dt2.hashCode());
    }

    //2 怎么调用hashCode看哈希？
    public static int type2(Dog2... dt) {
        HashSet<Dog2> hs = new HashSet<>();
        for (Dog2 x : dt) {
            hs.add(x);
        }
        return hs.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入两只狗");
        Dog2 dt1 = new Dog2(sc.next(), sc.nextInt());
        Dog2 dt2 = new Dog2(sc.next(), sc.nextInt());
        type1(dt1, dt2);
        System.out.println("请输入所有的狗,先输入有几只：");
        int dogn = sc.nextInt();
        Dog2[] dts1 = new Dog2[dogn];
        for (int i = 0; i < dogn; i++) {
            dts1[i] = new Dog2(sc.next(), sc.nextInt());
        }
        System.out.println("一共有 " + type2(dts1) + " 只狗");
        System.out.println(dt1);
    }
}
