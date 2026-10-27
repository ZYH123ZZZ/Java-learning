public class Clerk extends Employee {
    public Clerk(String name) {
        super(name);
    }
    @Override
    public double salary() {
        return 5000;
    }
    @Override
    public String kind() {
        return "文员";
    }
}
