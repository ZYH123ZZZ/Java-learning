public class CleanRobot extends Robot {
    public CleanRobot(String name) {
        super(name);
    }
    @Override
    public void work() {
        super.work();
        System.out.println(name + " 顺便扫地");
    }
}
