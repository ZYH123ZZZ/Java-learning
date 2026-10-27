public class Student {
    String name;
    int score;


    public void printInfo() {
        System.out.println(name + " " + score);
    }

    public Student(String n, int sc) {
        name = n;
        score = sc;
    }
}
