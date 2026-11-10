import java.util.HashSet;
import java.util.List;

public class checkD20 {
    public static void main(String[] args) {
        List<String> l1 = List.of("a", "b", "a", "c");
        HashSet<String> hs1 = new HashSet<>();
        for (String x : l1) {
            hs1.add(x);
        }
        System.out.println(hs1);
        //List是一个列表，set是一个无重复的列表（后面会有重写要不然会有重复发class）Map是一个二元表 键与值对应
    }
}
