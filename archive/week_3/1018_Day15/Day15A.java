public class Day15A {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();

        p1.name = "姚明";
        p1.height = 226;
        p2.name = "我";
        p2.height = 181;

        System.out.println(p1.name + " " + p1.height);
        System.out.println(p2.name + " " + p2.height);
        if (p1.height > p2.height) {
            System.out.println(p1.name);
        } else if (p1.height < p2.height) {
            System.out.println(p2.name);
        } else {
            System.out.println(p1.name + p2.name);
        }

    }

}
