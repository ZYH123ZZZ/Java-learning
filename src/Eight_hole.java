public class Eight_hole {
    public static void Hole_one() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append(i);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        String result = sb.toString();
        System.out.println(result);
    }

    public static void check(int age) throws AgeException {
        if (age < 0 || age > 150) {
            throw new AgeException("年龄不合理: " + age);
        }
        System.out.println("年龄为: " + age);
    }

    public static void main(String[] args) {
        Hole_one();
        try {
            check(6);
            check(-5);
        } catch (AgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
