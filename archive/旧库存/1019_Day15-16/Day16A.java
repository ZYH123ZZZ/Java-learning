import java.util.HashMap;
import java.util.Scanner;

public class Day16A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Double,String> s = new HashMap<>();

        Book1[] b = new Book1[3];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Book1(sc.next(), sc.nextDouble());//这里忘记写new了
            s.put(b[i].price, b[i].name);
        }

        double max = b[0].price;//B是一本完整的书本 不是单一价格

        for (int i = 0; i < b.length; i++) {
//            System.out.println();
            b[i].infoPrint();//忘记格式
            if (max < b[i].price) {
                max = b[i].price;
            }
        }
        System.out.println(s.get(max));
    }
}
