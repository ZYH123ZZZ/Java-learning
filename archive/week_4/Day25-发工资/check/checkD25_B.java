public class checkD25_B {
    public static void main(String[] args) {
        Shape_D25[] shapes = {
                new Circle_D25("圆", 1),
                new Rectangle_D25("矩形", 2, 3),
                new Circle_D25("大圆", 5)
        };

        for (Shape_D25 x : shapes) {
            x.show();
        }
        System.out.println();


        for (Shape_D25 x : shapes) {
            Scalable_D25 s = (Scalable_D25) x;//这个不太熟悉
            s.scale(2);
        }

        for (Shape_D25 x : shapes) {
            x.show();
        }
    }
}
