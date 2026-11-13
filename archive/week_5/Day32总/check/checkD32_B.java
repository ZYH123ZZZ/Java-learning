import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class checkD32_B {
    public static boolean isCompareTrue(String pathA, String pathB) {
        File A = new File(pathA);
        File B = new File(pathB);
        if (!A.isFile() || !B.isFile() || (!A.exists()) || (!B.exists())) {
            return false;
        }
        try (FileInputStream inA = new FileInputStream(pathA);
             FileInputStream inB = new FileInputStream(pathB)) {
            byte[] bufA = new byte[1024];//一个buf只能存一份数据
            byte[] bufB = new byte[1024];
            int nA = inA.read(bufA);
            int nB = inB.read(bufB);

            while (nA != -1 && nB != -1) {
                for (int i = 0; i < nA; i++) {
                    if (!(bufA[i] == bufB[i])) {
                        return false;
                    }
                }
                nA = inA.read(bufA);
                nB = inB.read(bufB);
                if (nA != nB) {
                    return false;
                }
            }
        } catch (RuntimeException e) {//这他妈给我自动补全的什么东西
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
