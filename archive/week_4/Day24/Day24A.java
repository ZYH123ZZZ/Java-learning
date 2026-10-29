import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day24A {
    public static void main(String[] args) {
        ArrayList<Animal> a = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("现在输入狗 两只");
        for (int i = 0; i < 2; i++) {
//            Dog[] d = new Dog[2];
//            d[i].name = sc.nextLine();
//            d[i].age = sc.nextInt();
            a.add(new Dog(sc.next(),sc.nextInt()));
        }

        System.out.println("现在输入猫 两只");
        for (int i = 0; i < 2; i++) {
//            Cat[] c = new Cat[2];
//            c[i].name = sc.nextLine();
//            c[i].age = sc.nextInt();
            a.add(new Cat(sc.next(),sc.nextInt()));
        }

        System.out.println("现在输入鸟 一只 ");
        Bird b = new Bird(sc.next(), sc.nextInt());
        a.add(b);

//        int dm = 0;
//        int cm = 0;
//        int bm = 0;
//        for (Animal x : a) {
//            x.eat();
//            if (x instanceof Dog) {
//                dm++;
//            }
//            if (x instanceof Cat) {
//                cm++;
//            }
//            if (x instanceof Bird) {
//                bm++;
//            }
//        }
        HashMap<String, Integer> count = new HashMap<>();

        for (Animal x : a) {
            count.put(x.kind(), count.getOrDefault(x.kind(), 0) + 1);
        }

        for (String k : count.keySet()) {
            System.out.println(k + " " + count.get(k) + " 只");
        }
//        System.out.println("狗" + dm);
//        System.out.println("猫" + cm);
//        System.out.println("鸟" + bm);

        int max = a.get(0).age;//改进
        String maxName = "";
        for (Animal x : a) {
            if (max < x.age) {
                max = x.age;
                maxName = x.name;
            }
        }
        System.out.println(maxName);
        for (Animal x : a) {
            if (x instanceof Bird) {
                Bird b1 = (Bird) x;  //忘记加Bird最后补上了
                b1.fly();
            }
        }
    }

}
