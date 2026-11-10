import java.util.ArrayList;
import java.util.List;

public class checkD17 {
    public static void main(String[] args) {
        List<String> L1 = new ArrayList<>();
        L1.add("jasdg");
        L1.add("1123233");
        L1.add("akshd");
        System.out.println(L1.get(0));
        System.out.println(L1.size());
        System.out.println(L1.contains("1123233"));
        System.out.println(L1.contains("akdh"));
        L1.remove("1123233");
        for (String x : L1) {
            System.out.println(x);
        }
    }
}
