import java.util.Scanner;

public class Day12B {
    public static int[] findSum(int[] Num, int target) {
        for (int i = 0; i < Num.length; i++) {
            for (int j = 0; j < Num.length; j++) {
                if (i != j && Num[j] + Num[i] == target) {
                    int[] Num1 = {Num[i], Num[j]};
                    return Num1;
                }
                }
            }
        return new int[0];
        }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("你的数组里有几个数？： ");
        int n = sc.nextInt();
        System.out.println("请输入你的数组 ");
        int[] Num = new int[n];
        for (int i = 0; i < n; i++) {
            Num[i] = sc.nextInt();
        }

        System.out.println("请输入目标： ");
        int target = sc.nextInt();

        int[] path = findSum(Num, target);
        if (path.length == 0) {
            System.out.println("没找到");
        } else {
            System.out.println(path[0] + " " + path[1]);
        }
    }


}
