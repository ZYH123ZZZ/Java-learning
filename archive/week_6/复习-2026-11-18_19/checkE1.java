// 封装 / private —— 第一次学（2026-11-19）
// 规矩：字段一律 private，外面只能通过方法读写；所有校验写在类里面，不许在外面挡。

class Account {
    private String owner;
    private double balance;

    // 构造方法：owner 为空或 null → 用 "无名"；balance 小于 0 → 用 0
    Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        if (owner == null || owner.isEmpty()) {
            this.owner = "无名";
        }
        if (balance < 0) {
            this.balance = 0;
        }
        // 你写
    }

    public String getOwner() {
        // 你写
        return owner;
    }

    public double getBalance() {
        // 你写
        return balance;
    }

    // 名字为空或 null → 不改，打印 名字不能为空
    public void setOwner(String owner) {
        if (owner == null || owner.isEmpty()) {
            System.out.println("名字不能为空");
            return;
        }

        this.owner = owner;
        // 你写
    }

    // 余额小于 0 → 不改，打印 余额不能为负
    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("余额不能为负");
            return;
        }

        this.balance = balance;
        // 你写
    }

    // 金额 <= 0 → 不改，打印 存款金额必须大于 0；否则加上去
    public void deposit(double money) {
        if (money <= 0) {
            System.out.println("存款金额必须大于0");
            return;
        }

        this.balance += money;
        // 你写
    }

    // 金额 <= 0 → 打印 取款金额必须大于 0；金额 > 余额 → 打印 余额不足；否则扣掉
    public void withdraw(double money) {
        if (money <= 0) {
            System.out.println("取款金额必须大于 0");
            return;
        }
        if (this.balance < money) {
            System.out.println("余额不足");
            return;
        }

        this.balance -= money;
        // 你写
    }

    // 打印：名字 余额 数字   （例：张三 余额 1000.0）
    void show() {
        System.out.println(this.owner + " 余额 " + this.balance);
        // 你写
    }
}

public class checkE1 {
    public static void main(String[] args) {
        Account a = new Account("张三", 1000);
        a.show();                        // 张三 余额 1000.0
        a.setOwner("");                  // 名字不能为空
        a.show();                        // 张三 余额 1000.0
        a.setBalance(-50);               // 余额不能为负
        a.show();                        // 张三 余额 1000.0
        a.deposit(500);
        a.show();                        // 张三 余额 1500.0
        a.deposit(-100);                 // 存款金额必须大于 0
        a.withdraw(2000);                // 余额不足
        a.show();                        // 张三 余额 1500.0
        a.withdraw(500);
        a.show();                        // 张三 余额 1000.0
        System.out.println(a.getOwner() + " 的钱：" + a.getBalance());  // 张三 的钱：1000.0

        Account b = new Account("", -10);
        b.show();                        // 无名 余额 0.0
    }
}
