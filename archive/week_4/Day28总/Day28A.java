import java.util.ArrayList;
import java.util.Scanner;

public class Day28A {
    public static double[] chuqinlv(ArrayList<Student1> s, double a[]) {//算各个出勤率
        for (int i = 0; i < s.size(); i++) {
            a[i] = ((double)s.get(i).daynum / s.get(i).sdaynum) * 100;
        }
        return a;
    }

    public static double avgchuqinlv(ArrayList<Student1> s, double a[],double sum) {
        for (double x : chuqinlv(s, a)) {
            sum = sum + x;
        }
        return sum / s.size();
    }

    public static String maxChuqin(ArrayList<Student1> s, double a[]) {
        if (s.size() == 0) {
            return "无";
        }
        double max = chuqinlv(s, a)[0];
        String maxname = s.get(0).name;
        int i = 0;
        for (Student1 x : s) {
            if (max < chuqinlv(s, a)[i]) {
                max = chuqinlv(s, a)[i];
                maxname = s.get(i).name;
            }
            i++;
        }
        return maxname;
    }

    public static int quanqin(ArrayList<Student1> s,double[] a) {
        int num1 = 0;
        int i = 0;
        for (Student1 x : s) {
            if (chuqinlv(s, a)[i] == 100) {
                num1++;
            }
            i++;
        }
        return num1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student1> s = new ArrayList<>();//创建学生数列

        int n = sc.nextInt();//有几组数据
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            try {
                String sentence = sc.nextLine();//检查段数必须用分割
                String[] t = sentence.split(" ");
                if (t.length != 4) {//检查段数
                    throw new IllegalArgumentException("必须正好四段");
                }
                String name = t[0];
                int num = Integer.parseInt(t[1]);
                if (t[1].length() != 8) {
                    throw new IllegalArgumentException("必须八位数字");//检查数字长度
                }
                int daynum = Integer.parseInt(t[2]);
                if (daynum < 0 || daynum > 31) {
                    throw new IllegalArgumentException("出勤天数必须为0~31");//
                }
                int sdaynum = Integer.parseInt(t[3]);
                if (sdaynum < 1 || sdaynum > 31) {
                    throw new IllegalArgumentException("总天数必须为1~31");//
                }
                if (daynum > sdaynum) {
                    throw new IllegalArgumentException("出勤天数不能大于等于总天数");//
                }
                s.add(new Student1(name, num, daynum, sdaynum));//忘记加这个了
            } catch (NumberFormatException e) {
                System.out.println("第 " + (i + 1) + " 行：出勤天数不是数字");
            } catch (IllegalArgumentException e) {
                System.out.println("第" + (i + 1) + "行： " + e.getMessage());//
            }
        }
        double[] a = new double[s.size()];//这个不小心写循环里面了
        double sum = 0;
//        System.out.println(chuqinlv(s,a));//逐个打印
//        System.out.println(avgchuqinlv(s,a,sum));
//        System.out.println(maxChuqin(s,a));
//        System.out.println(quanqin(s, a));
        System.out.println("=== 出勤率 ===");
        for (int i = 0; i < s.size(); i++) {
            System.out.printf("%s %.1f%s%n",s.get(i).name,chuqinlv(s,a)[i],"%");
        }
        System.out.println();
        System.out.println("=== 平均出勤率 ===");
        if (s.size() == 0) {
            System.out.printf("%.1f%s%n", 0.0, "%");
        } else {
            System.out.printf("%.1f%s%n", avgchuqinlv(s, a, sum),"%");
        }
//        System.out.printf("%.1f%s%n", avgchuqinlv(s, a, sum),"%");
        System.out.println();
        System.out.println("=== 出勤率最高 ===");
        if (s.size() == 0) {
            System.out.println("无");
        } else {
            System.out.println(maxChuqin(s, a));
        }
//        System.out.println(maxChuqin(s, a));
        System.out.println();
        System.out.println("=== 全勤人数 ===");
        System.out.printf("%d %s%n",quanqin(s,a),"人");
    }
}
