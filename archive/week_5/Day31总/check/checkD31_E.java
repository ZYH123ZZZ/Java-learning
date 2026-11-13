import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class checkD31_E {
    static List<String> list = new ArrayList<>();
    public static List<String> method1(String dirPath, String keyWord) {
        File f1 = new File(dirPath);
        if (f1.isFile()) {
            if (f1.getName().contains(keyWord)) {
                list.add(f1.getPath());
            }
        }
        if (f1.isDirectory()) {
            File[] dir1 = f1.listFiles();
            if (dir1 == null) {
                return list;
            }
            for (File x : dir1) {
//                if (x.getName().contains(keyWord)) {
//                    list.add(x.getPath());
//                }
                method1(x.getPath(), keyWord);
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
