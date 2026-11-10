import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class checkD3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }
        System.out.println(list.toString());
    }
}
