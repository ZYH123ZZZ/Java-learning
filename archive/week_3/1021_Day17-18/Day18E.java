import java.util.Scanner;

public class Day18E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ticketBought p1 = new ticketBought(sc.next(), sc.nextDouble(), sc.nextInt());
        p1.allPrint();          //下次注意输出要有一个具体的值 new的值就可以
    }
}
