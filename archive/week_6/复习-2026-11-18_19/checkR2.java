// 复习 2 · indexOf / lastIndexOf / substring（待复习清单第 2 条，B 档，11-18）
// 目标 15 分钟。闭卷。
// 禁用：split、File、Paths、正则。只准 indexOf / lastIndexOf / substring / length / charAt。
public class checkR2 {

    // 【1】ext(String path) —— 取扩展名（最后一个点后面那段），没有点返回 ""（空字符串）
    //     "data/archive.txt" → "txt"
    //     "a.b.txt"          → "txt"        ← 要最后一个点，不是第一个
    //     "README"           → ""
    //     ".gitignore"       → "gitignore"  ← 点在位置 0，也算有扩展名（这行是分水岭）
    static String ext(String path) {
        int a1 = path.lastIndexOf(".");
//        try {
//            String ext1 = path.substring(a1 + 1);//不知道咋处理null
//            return ext1;
//        } catch (StringIndexOutOfBoundsException e) {
//            return "";
//        }//为什么输出不正确？
        if (a1 == -1) {
            return "";
        }
        String ext1 = path.substring(a1 + 1);//不知道咋处理null
            return ext1;
        // 你写
    }

    // 【2】base(String path) —— 取纯文件名（最后一个 / 后面那段），没有 / 就原样返回
    //     "data/archive.txt" → "archive.txt"
    //     "README"           → "README"
    //     "a/b/c.java"       → "c.java"
    static String base(String path) {
        int a1 = path.lastIndexOf("/");
        if (a1 == -1) {
            return path;
        }
        String lastpath = path.substring(a1 + 1);
        // 你写
        return lastpath;
    }

    public static void main(String[] args) {
        System.out.println(ext("data/archive.txt"));  // txt
        System.out.println(ext("a.b.txt"));           // txt
        System.out.println(ext("README"));            // （空）
        System.out.println(ext(".gitignore"));        // gitignore
        System.out.println("---");
        System.out.println(base("data/archive.txt")); // archive.txt
        System.out.println(base("README"));           // README
        System.out.println(base("a/b/c.java"));       // c.java
    }
}
