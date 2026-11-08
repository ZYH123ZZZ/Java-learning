import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day37 {
    public static void listJava(String dirPath) {
            File dir1 = new File(dirPath);
            String[] names = dir1.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
//                    if (name.endsWith(".java")) {
//                        System.out.println("字节数: " + dir.length());//dir指向那个被扫描的文件夹
//                    }
                    return name.endsWith(".java");
                }
            });
            if (names == null) {//先null再判断 不要让catch抓住异常 要不然根本不会判断
                System.out.println("文件夹不存在");
            } else if (names.length <= 0) {
                System.out.println("这个文件夹里面没有.Java文件");
            } else {
                for (int i = 0; i < names.length; i++) {
                    File f = new File(dir1, names[i]);//父类加子类名字
                    System.out.println(f.getName() + " " + f.length());
                }
            }

    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("cat", "elephant", "on"));

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Collections.sort(list, (a, b) -> a.length() - b.length());
        System.out.println(list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o = o1.length() - o2.length();
                if (o == 0) {
                    return o2.compareTo(o1);
                }
                return o;
            }
        });

    }
}
