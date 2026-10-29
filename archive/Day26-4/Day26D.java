import java.util.ArrayList;
import java.util.Scanner;

public class Day26D {
//    public static boolean isTrue(ArrayList<Student> a) {//不会构造方法抛出值 //抛出错误（抄的）
//        for (Student x : a) {//遍历每一个人的每一个数值
//            if (x.scoreE > 100) {
//                throw new IllegalArgumentException("英语" + x.scoreE + "超出范围"); //不会写throw new
//            }
//            if (x.scoreM > 100) {
//                throw new IllegalArgumentException("数学" + x.scoreM + "超出范围");
//            }
//            if (x.scoreC > 100) {
//                throw new IllegalArgumentException("语文" + x.scoreC + "超出范围");
//            }
//        }
//        return true;
//    }

    public static void check(int c, int mm, int e) {//新的检查
        if (c < 0 || c > 100)   throw new IllegalArgumentException("语文" + c + "超出范围");
        if (mm < 0 || mm > 100) throw new IllegalArgumentException("数学" + mm + "超出范围");
        if (e < 0 || e > 100)   throw new IllegalArgumentException("英语" + e + "超出范围");
    }

    public static double avgSumScore(ArrayList<Student> a) {
        double sum = 0;
        for (Student x : a) {
            sum = sum + x.scoreC + x.scoreM + x.scoreE;
        }
        return sum / a.size();//又是有效数据和无效数据的区分
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> a = new ArrayList<>();

        int n = sc.nextInt();//输入“n”个学生
//        try {
//            int ok = 0;//记录有效数据
//            int fail = 0;//及记录无效数据（抄的）
//
//            String[] s = new String[n];//创建数列去装分割
//            for (int i = 0; i < n; i++) {
//                s[i] = sc.nextLine();//输入一句话
//                String[] m = s[i].split(",");//按逗号切分//不同族之间不能用（）强制转换
//                a.add(new Student(m[0], Integer.parseInt(m[1]),
//                        Integer.parseInt(m[2]), Integer.parseInt(m[3])));//用parse转换String为Integer存入数列
//                ok++;
//            }
//        } catch (NumberFormatException e) {//抓住两个错误
//            System.out.println("第" + (i + 1) + "行：数字格式不对，跳过");//复制的
//        } catch (IllegalArgumentException e) {
//            System.out.println("第" + (i + 1) + "行：" + e.getMessage());//复制的
//        }//两个报错
//
        sc.nextLine();//nextLine前要检查是否会有东西吃掉回车
        int ok = 0;
        int fail = 0;
//        String[] s = new String[n];//数组不用 直接在循环里切就行
//        for (int i = 0; i < n; i++) {//为了在错误时不停止 要把Try放到循环里面
//            s[i] = sc.nextLine();//输入一句话
//            String[] m = s[i].split(",");//按逗号切分//不同族之间不能用（）强制转换
//            try {
//                a.add(new Student(m[0], Integer.parseInt(m[1]),
//                        Integer.parseInt(m[2]), Integer.parseInt(m[3])));//用parse转换String为Integer存入数列
//                ok++;
//            } catch (NumberFormatException e) {
//                System.out.println("第" + (i + 1) + "行：数字格式不对，跳过");
//            } catch (IllegalArgumentException e) {
//                System.out.println("第" + (i + 1) + "行：" + e.getMessage());
//            }
//        }
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            try {
                String[] m = line.split(",");
                if (m.length != 4) {
                    throw new IllegalArgumentException("段数不够");
                }
                int c  = Integer.parseInt(m[1]);
                int mm = Integer.parseInt(m[2]);
                int e  = Integer.parseInt(m[3]);
                check(c,mm,e);//要先检查再进数组 要不然错误数据一并排进去就完蛋了
                a.add(new Student(m[0], c, mm, e));//用parse转换String为Integer存入数列
//                isTrue(a);
                ok++;


                // ① 先查段数：m.length != 4 → 抛 IllegalArgumentException
                // ② parseInt（可能抛 NumberFormatException）
                // ③ 查 0~100（可能抛 IllegalArgumentException）
                // ④ new Student(...) 加进列表，ok++

            } catch (NumberFormatException e) {
                System.out.println("第" + (i + 1) + "行：数字格式不对，跳过");
                fail++;
            } catch (IllegalArgumentException e) {
                System.out.println("第" + (i + 1) + "行：" + e.getMessage());
                fail++;
            }
        }
        // 循环结束之后
        if (a.isEmpty()) {
            System.out.printf("成功 %d 条，失败 %d 条，平均分 ——（无有效数据）%n", ok, fail);//为了消除0/0
        } else {
            System.out.printf("成功 %d 条，失败 %d 条，平均分 %.2f%n", ok, fail, avgSumScore(a));
        }
// 循环外：打印 ok / fail / 总分
    }
}
