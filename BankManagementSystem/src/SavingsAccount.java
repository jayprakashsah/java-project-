public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("💰 Interest Added: " + interest);
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("📘 Savings Account -> " +
                "Account No: " + accountNumber +
                ", Holder: " + accountHolder +
                ", Balance: " + balance +
                ", Interest Rate: " + interestRate + "%");
    }
}