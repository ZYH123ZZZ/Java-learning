import java.util.Objects;

public class BookD36 {
    int id;
    String name;

    public BookD36(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BookD36)) {
            return false;
        }
        BookD36 b = (BookD36) o;
        return b.id == id && Objects.equals(b.name,name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "BookD36{id=" + id + ", name=" + name + "}";
    }
}
