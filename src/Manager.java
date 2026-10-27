public class Manager extends Employee implements Bonus {
    public Manager(String name) {
        super(name);
    }

    @Override
    public double salary() {
        return 8000;
    }

    @Override
    public String kind() {
        return "经理";
    }

    @Override
    public double getBonus() {
        return 2000;
    }

    @Override
    public String bonusTitle() {
        return "年终奖";
    }
}
