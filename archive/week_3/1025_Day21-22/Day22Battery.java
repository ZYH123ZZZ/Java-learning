public class Day22Battery {
    public static void main(String[] args) {
        Battery b1 = new Battery();
        Battery b2 = new Battery(20);
        System.out.println(b1.level);
        System.out.println(b2.level);
        System.out.println(b1);
        System.out.println(b2);
    }
}
