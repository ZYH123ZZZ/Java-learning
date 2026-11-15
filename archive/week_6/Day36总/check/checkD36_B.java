import java.util.*;

class Book {
    int id;
    String name;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return id == b.id && Objects.equals(name, b.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


    @Override
    public String toString() {
        return "Book{id=" + id + ", name=" + name + "}";
    }
}

public class checkD36_B {

    // 只有一个参数，void，自己打印
    static void count(List<Book> shelf) {
        if (shelf.size() == 0) {
            System.out.println("空书架");
            return;
        }
        ArrayList<Book> ar1 = new ArrayList<>();
        for (Book x : shelf) {
            if (ar1.contains(x)) {
                continue;
            }
            ar1.add(x);
        }
        HashMap<Book, Integer> hm1 = new HashMap<>();
        for (Book x : shelf) {
            hm1.put(x, hm1.getOrDefault(x, 0) + 1);
        }
        for (Book x : ar1) {
            System.out.println(x.toString() + " 出现 " + hm1.get(x) + " 次");
        }
        System.out.println("共 " + hm1.size() + " 种, " + shelf.size() + " 本");
        // 你写
    }

    public static void main(String[] args) {
        List<Book> g1 = new ArrayList<>();
        g1.add(new Book(1, "Java"));
        g1.add(new Book(1, new String("Java")));
        g1.add(new Book(2, "IO"));
        g1.add(new Book(2, "IO"));
        g1.add(new Book(2, new String("IO")));
        g1.add(new Book(3, "Net"));
        count(g1);

        List<Book> g2 = new ArrayList<>();
        count(g2);

        List<Book> g3 = new ArrayList<>();
        g3.add(new Book(1, "Java"));
        count(g3);

        List<Book> g4 = new ArrayList<>();
        g4.add(new Book(1, "Java"));
        g4.add(new Book(1, "IO"));
        count(g4);

        List<Book> g5 = new ArrayList<>();
        Book same = new Book(7, "SQL");
        g5.add(same);
        g5.add(same);
        g5.add(same);
        count(g5);
    }
}
