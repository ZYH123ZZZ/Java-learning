import java.util.ArrayList;

public class Day29A {
    public static <T> void printAll(ArrayList<T> list) {
        for (T x : list) {
            System.out.println("* " + x);
        }
    }

    public static <T> T last(ArrayList<T> list) {
        if (list.size() <= 0) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T> int count(ArrayList<T> list,T target) {
        int count = 0;
        for (T x : list) {
            if (x.equals(target)) {//== 和 target的区别
                count++;
            }
        }
        return count;
    }

    public static int sum(int... nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int sum = 0;
        for (int x : nums) {
            sum = sum + x;
        }
        return sum;
    }

    public static double avg(int... nums) {
        if (nums.length <= 0) {
            return 0;
        }
        return (double)sum(nums) / nums.length;
    }
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> test = new ArrayList<>();

        fruits.add("苹果");
        fruits.add("香蕉");
        fruits.add("苹果");

        nums.add(1000);
        nums.add(20);
        nums.add(1000);

        printAll(fruits);
        String last = last(fruits);
        System.out.println("最后一个：" + last);
        System.out.println(last + " 出现 " + count(fruits,last) + " 次");

        printAll(nums);
        int lastnum = last(nums);
        System.out.println("最后一个：" + lastnum);
        System.out.println(lastnum + " 出现 " + count(nums,lastnum) + " 次");

        System.out.println("sum(1,2,3) = " + sum(1, 2, 3));
        System.out.printf("%s%.2f%n","avg(4,5,6) = ",avg(4, 5, 6));
        System.out.printf("%s%.2f%n","avg() = ",avg());
//        System.out.println(last(test));
        Integer tail = last(test);
        if (tail == null) {
            System.out.println("空列表：无");
        } else {
            System.out.println(tail);
        }
    }
}
