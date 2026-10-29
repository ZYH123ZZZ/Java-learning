public class FastRobot extends Robot {

    public FastRobot(String name) {
        super(name);
    }
    @Override
    public void charge() {
        System.out.println(name + " 快充 5分钟搞定");
    }
}
