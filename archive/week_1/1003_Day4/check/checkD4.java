import java.util.Scanner;

public class checkD4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score = sc.nextInt();
        String Rank = "D";
        if (score >= 90) {
            Rank = "A";
        } else if (score >= 80) {
            Rank = "B";
        } else if (score >= 60) {
            Rank = "C";
        } else {
            Rank = "D";
        }
        System.out.println("Rank: " + Rank);
        }
    }
