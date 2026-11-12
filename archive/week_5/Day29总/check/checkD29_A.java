import java.util.ArrayList;
import java.util.List;

public class checkD29_A {
    public static <T> T last(ArrayList<T> test) {
        if (test.size() == 0) {
            return null;
        }
        return test.getLast();
    }

    public static <T> String join(ArrayList<T> test) {
        if (test.size() == 0) {
            return "空";
        }
        String a1 = "";
        for (int i = 0; i < test.size(); i++) {
            if (i < test.size() - 1) {
                a1 = a1 + test.get(i) + ",";
            }
            if (i == test.size() - 1) {
                a1 = a1 + test.get(i);
            }
        }
        return a1;
    }

    public static <T> int findIndex(ArrayList<T> test,T target) {
        for (int i = 0; i < test.size(); i++) {
            if (test.get(i).equals(target)) {//看到输出错误改用equals
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(List.of("张三", "李四", "王五"));
        ArrayList<Integer> nums = new ArrayList<>(List.of(3, 1200, 47, 1200));
        ArrayList<String> empty = new ArrayList<>();
        System.out.println(last(names));
        System.out.println(last(nums));
        System.out.println(last(empty));
        System.out.println(join(names));
        System.out.println(join(nums));
        System.out.println(join(empty));
        System.out.println(findIndex(nums, 1200));
        System.out.println(findIndex(names,"赵六"));

    }
}
