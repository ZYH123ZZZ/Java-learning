public abstract class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double salary();

    public abstract String kind();
}
