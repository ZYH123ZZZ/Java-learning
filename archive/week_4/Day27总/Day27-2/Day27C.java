import java.util.ArrayList;
import java.util.Scanner;

public class Day27C {
    public static int sum(ArrayList<Integer> a, int n) {//递归加和
        if (n <= 0) {//保底
            return 0;
        }
        return sum(a, n - 1) + a.get(n - 1);//累加
    }

    public static int max(ArrayList<Integer> a, int n,int max) {//求最大值
        if (n <= 0) {
            return max;//保底
        }
        if (max < a.get(n - 1)) {//打擂台
            max = a.get(n - 1);
        }
        return max(a, n - 1, max);//调用n - 1的max方法
    }

    public static int isOu(ArrayList<Integer> a, int n,int i1) {//偶数多少个
        if (n <= 0) {//保底
            return i1;//输出加合值
        }
        if (a.get(n - 1) % 2 == 0) {//如果是偶数就加一
            i1++;
        }
        return isOu(a, n - 1, i1);//输出以循环
    }

    public static void upside(ArrayList<Integer> a, int n,int f) {//倒打
        if (n <= 0) {//保底
            return;
        }
        if (!(f == n)) {//加空格 不加头尾 后面n变了就加
            System.out.print(" ");
        }
        System.out.print(a.get(n - 1));//输出 -1是为了对齐下标
        upside(a,n - 1,f);//循环
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       ArrayList<Integer> a = new ArrayList<>();

       int n = sc.nextInt();//数字的个数
       for (int i = 0; i < n; i++) {
           a.add(sc.nextInt());//输入数列
       }
        int max = 0;
        if (n > 0) {
            max = a.get(0);
        }//初始化max
            int i1 = 0;//偶数个数初始值
            int f = n;//判断是否加括号初始值
//        System.out.println(sum(a,n));//sum探针（保留）
//        System.out.println(max(a,n,max));//max探针（保留）
//        System.out.println(isOu(a, n, i1));//偶数探针（保留）
//        upside(a, n, f);  //倒打探针(保留）
            System.out.printf("%s %d%n", "总和：", sum(a, n));
            System.out.printf("%s %d%n", "最大值:", max(a, n, max));
            System.out.printf("%s %d%n", "偶数个数:", isOu(a, n, i1));
            System.out.print("倒着打: ");
            upside(a, n, f);
        }
}
