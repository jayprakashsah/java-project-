public abstract class Account {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Deposit must be greater than zero!");
            return;
        }
        balance += amount;
        System.out.println("✅ Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Withdrawal must be greater than zero!");
            return;
        }
        if (amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawn: " + amount);
        } else {
            System.out.println("❌ Insufficient balance.");
        }
    }

    public abstract void displayAccountInfo();
}