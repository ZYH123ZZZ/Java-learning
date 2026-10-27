import java.util.Scanner;

public class Day15B {
    public static double costSum(Book[] books) {                //不知道填什么
        double sum = 0;
        for (int i = 0; i < books.length; i++) {
            sum = sum + books[i].cost;
        }
        return sum;
    }

    public static String maxCost(Book[] books) {
        double max = books[0].cost;
        String maxName = books[0].name;
        for (int i = 1; i < books.length; i++) {
            if (max < books[i].cost) {
                max = books[i].cost;
                maxName = books[i].name;
            }
     }
        return maxName;
}

    public static int more300(Book[] books) {
        int sum1 = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].page > 300) {
                sum1++;
            }
        }
        return sum1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            books[i] = new Book();
            books[i].name = sc.next();
            books[i].cost = sc.nextDouble();
            books[i].page = sc.nextInt();
        }
        System.out.printf("%.2f%n", costSum(books));
        System.out.println(maxCost(books));
        System.out.println(more300(books));
    }
}
