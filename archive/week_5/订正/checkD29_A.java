import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class checkD29_A {
    public static ArrayList<String> com(ArrayList<String> a1) {
        Collections.sort(a1,(a,b)-> {
            int d1 = Integer.parseInt(b.substring(b.indexOf(":") + 1)) - Integer.parseInt(a.substring(a.indexOf(":") + 1));
                if (d1 == 0) {
                    return a.compareTo(b);
                }
                return d1;
        });
        return a1;
    }

    public static void max(ArrayList<String> a1) {
        int[] a2 = new int[a1.size()];
        int i = 0;
        for (String x : a1) {
            String[] s1 = x.split(":");
            a2[i] = Integer.parseInt(s1[1]);
            i++;
        }
        int max = a2[0];
        for (int x : a2) {
            if (x > max) {
                max = x;
            }
        }
        int countMax = 0;
        for (int x : a2) {
            if (x == max) {
                countMax++;
            }
        }
        System.out.println("最高分 " + max + " 分，共 " + countMax + " 人");
    }

    public static void main(String[] args) {
        ArrayList<String> recs = new ArrayList<>(List.of(
                "张三:85", "李四:92", "王五:85", "赵六:78", "钱七:92", "孙八:100", "周九:78"));
        ArrayList<String> recs1 = com(recs);
        for (int i = 0; i < recs1.size(); i++) {
            System.out.println((1 + i) + ". " + recs1.get(i));
        }
        max(recs1);
    }
}
