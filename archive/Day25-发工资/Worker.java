public class Worker extends Employee {
    public Worker(String name) {
        super(name);
    }
    @Override
    public double salary() {
        return 4000;
    }
    @Override
    public String kind() {
        return "工人";
    }
}
