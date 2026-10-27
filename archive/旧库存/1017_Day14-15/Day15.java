public class Day15 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();

        s1.score = 85;
        s2.score = 91;
        s1.name = "zyh";
        s2.name = "hyz";
        s1.age = 15;
        s2.age = 18;

        Student[] arr = {s1, s2};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].name + " " + arr[i].score + " " + arr[i].age);

        }
    }
}
