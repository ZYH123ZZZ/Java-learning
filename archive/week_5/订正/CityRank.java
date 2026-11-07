import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CityRank {
    public static void main(String[] args) {
        HashMap<String, Integer> sales = new HashMap<>();
        sales.put("shanghai", 12);
        sales.put("beijing", 12);
        sales.put("zhengzhou", 7);
        sales.put("wuhan", 7);
        sales.put("xian", 3);
        sales.put("chengdu", 3);
        ArrayList<String> ar = new ArrayList<>(sales.keySet());

        Collections.sort(ar,(a,b) ->{
            int d1 = sales.get(b) - sales.get(a);//a和b都是String 需要调用哈希
            if (d1 != 0) {
                return d1;//输出一个数字去让sort排序
            }
            return a.compareTo(b);
        });
        for (int i = 0; i < ar.size(); i++) {
            String m = ar.get(i);
            System.out.println((i + 1)+ ". " + m + " " + sales.get(m));
        }
    }
}
