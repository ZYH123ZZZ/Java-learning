public class Battery {
    int level;

    @Override
    public String toString() {
        return "" + level;
    }

    public Battery(int level) {
        this.level = level;
    }

    public Battery() {
        this(100);
    }
}

