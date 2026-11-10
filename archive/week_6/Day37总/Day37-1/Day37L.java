import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Day37L {
    public static void a1(String dirPath) {
        File dir1 = new File(dirPath);
        String[] names = dir1.list((folder, name) -> name.endsWith(".java"));
        System.out.println(Arrays.toString(names));
    }

    public static void a2(String dirPath) {
        File dir1 = new File(dirPath);
        String[] names = dir1.list(new FilenameFilter() {
            @Override//省掉了这个
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        System.out.println(Arrays.toString(names));
    }
    public static void main(String[] args) {
        a1("C:/Users/Administrator/Desktop/test/archive/week_6/杂项-0");
        a2("C:/Users/Administrator/Desktop/test/archive/week_6/杂项-0");
    }
}
