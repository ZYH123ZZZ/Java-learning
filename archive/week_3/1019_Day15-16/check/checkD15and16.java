import java.util.ArrayList;
import java.util.List;

public class checkD15and16 {
    public static void main(String[] args) {
        List<Goods_D15and16> L1 = new ArrayList<>();
        L1.add(new Goods_D15and16("name1", 1));
        L1.add(new Goods_D15and16("name2", 2));
        L1.add(new Goods_D15and16("name3", 3));
        //调用show不太熟
        for (Goods_D15and16 x : L1) {
            x.show();
        }
    }
}
