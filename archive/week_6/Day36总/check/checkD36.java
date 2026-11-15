import java.util.HashSet;

public class checkD36 {
    public static void main(String[] args) {
        BookD36 b1 = new BookD36("Java", 1);
        BookD36 b2 = new BookD36("Java", 1);
        BookD36 b3 = new BookD36("Java", 23);
        HashSet<BookD36> hs1 = new HashSet<>();
        hs1.add(b1);
        hs1.add(b2);
        hs1.add(b3);
        System.out.println(hs1.size());
        System.out.println(hs1.toString());
    }
}
