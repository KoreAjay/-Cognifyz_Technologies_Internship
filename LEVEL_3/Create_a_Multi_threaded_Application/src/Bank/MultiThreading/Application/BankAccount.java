package Bank.MultiThreading.Application;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        double newBalance = balance + amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New balance: " + newBalance);
        balance = newBalance;
    }

    public synchronized void withdraw(double amount) {
        if (amount <= balance) {
            double newBalance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". New balance: " + newBalance);
            balance = newBalance;
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + ". Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}
