public class Director extends Employee implements Bonus {
    public Director(String name) {
        super(name);
    }

    @Override
    public double salary() {
        return 12000;
    }

    @Override
    public String kind() {
        return "总监";
    }

    @Override
    public double getBonus() {
        return 5000;
    }

    @Override
    public String bonusTitle() {
        return "绩效奖";
    }
}
