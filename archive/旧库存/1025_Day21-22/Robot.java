public class Robot {
    String name;

    public Robot() {
        this("null");
    }
    public Robot(String name) {
        this.name = name;
    }
    public void work() {
        System.out.println(name + " 正在工作");
    }

    public void charge() {
        System.out.println(name + "充电中 需要俩小时");
    }
}