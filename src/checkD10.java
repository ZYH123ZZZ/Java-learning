public class checkD10 {
    public static int countVowel(String s) {
        int sum = 0;
        String[] s1 = s.split("");
        for (int i = 0; i < s1.length; i++) {
            if ((s1[i] == "a") || (s1[i] == "e") || (s1[i] == "i") || (s1[i] == "o") || (s1[i] == "u")) {
                sum++;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(countVowel("aeiou"));
    }
}
