import java.io.File;

public class checkD31_C {
    public static boolean deleteAll(String path) {
        File f1 = new File(path);
        if (!f1.exists()) {
            return false;
        }
        if (f1.isFile()) {
            return f1.delete();
        }
        File[] dir1 = f1.listFiles();
        if (dir1 == null) {//null不太熟
            return false;
        }
        for (File x : dir1) {
            if (x.isDirectory()) {
                deleteAll(x.getAbsolutePath());
            } else if (x.isFile()) {
                if (x.delete()) {
                    System.out.println("删除成功 -> " + x.getAbsolutePath());
                }
            }
        }
        return f1.delete();
    }
}
