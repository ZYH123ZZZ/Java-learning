import java.util.Scanner;

public class Day16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] student = new Student[3];
        for (int i = 0; i < student.length; i++) {
            student[i] = new Student(sc.next(), sc.nextInt());
        }

        for (int i = 0; i < student.length; i++) {
            student[i].printInfo();
        }
    }
}
