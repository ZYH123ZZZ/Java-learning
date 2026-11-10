import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day39 {
    public static List<Integer> a0(List<String> names) {
        List<Integer> lens = names.stream()
                .filter(s -> s.length() >= 3)
                .map(String::length)
                .collect(Collectors.toList());
        return lens;
    }

    public static void a1(List<String> names) {
        List<String> names1 = names.stream().filter(s -> s.length() >= 4)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println(names1);
    }

    public static void a2(List<String> names) {
        List<String> names1 = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(names1);
    }

    public static void a3(List<String> names) {
        List<String> names1 = names.stream().filter(s -> s.startsWith("r"))
                .collect(Collectors.toList());
        System.out.println(names1.size());
    }

    public static void a4(List<String> names) {
        System.out.println(names.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
    }

    public static void main(String[] args) {
        List<String> words = List.of("java", "io", "stream", "file", "buffered", "a", "reader", "go", "code");
        System.out.println(a0(words));
        //这些全部是用来练习的 作废但是我不想删除
//        words.stream().sorted().collect(Collectors.toList());
//
//        words.stream()
//                .sorted(Comparator.comparingInt(String::length).reversed())
//                .collect(Collectors.toList());
//
//        words.stream().filter(s -> s.length() >= 3).count();
//        words.stream().anyMatch(s -> s.startsWith("j"));
//        words.stream().limit(3).collect(Collectors.joining(";"));
//        words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
// 从这里结束
        a1(words);
        a2(words);
        a3(words);
        a4(words);
    }
}
