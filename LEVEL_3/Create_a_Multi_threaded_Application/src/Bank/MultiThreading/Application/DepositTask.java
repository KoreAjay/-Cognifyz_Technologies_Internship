package Bank.MultiThreading.Application;

public class DepositTask implements Runnable {
    private BankAccount account;
    private double amount;

    public DepositTask(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.deposit(amount);
    }
}

