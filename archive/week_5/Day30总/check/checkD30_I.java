import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class checkD30_I {
    public static void method1(List<Integer> a) {
        if (a.size() < 3) {
            System.out.println("人数不够");
            return;
        }
        Iterator<Integer> it = a.iterator();
        int imax = a.get(0);
        int imin = a.get(0);
        while (it.hasNext()) {
            int i = it.next();
            if (i > imax) {
                imax = i;
            }
            if (i < imin) {
                imin = i;
            }
        }
        Iterator<Integer> it1 = a.iterator();
        while (it1.hasNext()) {
            int i = it1.next();
            if (i == imax) {
                it1.remove();
                break;
            }
        }
        Iterator<Integer> it2 = a.iterator();
        while (it2.hasNext()) {
            int i = it2.next();
            if (i == imin) {
                it2.remove();
                break;
            }
        }
        int sum = 0;
        double avg = 0;
        for (int x : a) {
            sum = sum + x;
        }
        avg = (double)sum / a.size();
        System.out.printf("%s%.2f%n","平均值: ",avg);
    }
    public static void main(String[] args) {
        ArrayList<Integer> s1 = new ArrayList<>();
        s1.add(90); s1.add(85); s1.add(100); s1.add(70); s1.add(60);

        ArrayList<Integer> s2 = new ArrayList<>();
        s2.add(1); s2.add(2); s2.add(3);

        ArrayList<Integer> s3 = new ArrayList<>();   // 两个人
        s3.add(5); s3.add(5);

        ArrayList<Integer> s4 = new ArrayList<>();   // 空表

        ArrayList<Integer> s5 = new ArrayList<>();
        s5.add(7); s5.add(7); s5.add(7); s5.add(7);  // 四个人全一样

        ArrayList<Integer> s6 = new ArrayList<>();
        s6.add(10); s6.add(20); s6.add(30);
        method1(s1);
        method1(s2);
        method1(s3);
        method1(s4);
        method1(s5);
        method1(s6);
    }
}
