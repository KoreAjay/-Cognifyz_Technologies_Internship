package Bank.MultiThreading.Application;

public class BankSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);

        Thread depositThread1 = new Thread(new DepositTask(account, 200.0), "DepositThread1");
        Thread depositThread2 = new Thread(new DepositTask(account, 300.0), "DepositThread2");
        Thread withdrawThread1 = new Thread(new WithdrawTask(account, 150.0), "WithdrawThread1");
        Thread withdrawThread2 = new Thread(new WithdrawTask(account, 500.0), "WithdrawThread2");

        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        withdrawThread2.start();

        try {
            depositThread1.join();
            depositThread2.join();
            withdrawThread1.join();
            withdrawThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
