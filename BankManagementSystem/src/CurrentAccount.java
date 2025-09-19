public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public boolean checkOverdraft(double amount) {
        return balance + overdraftLimit >= amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && checkOverdraft(amount)) {
            balance -= amount;
            System.out.println("✅ Withdrawn: " + amount);
        } else {
            System.out.println("❌ Overdraft limit exceeded.");
        }
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("📘 Current Account -> " +
                "Account No: " + accountNumber +
                ", Holder: " + accountHolder +
                ", Balance: " + balance +
                ", Overdraft Limit: " + overdraftLimit);
    }
}