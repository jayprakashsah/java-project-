import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void createAccount(Account account) {
        accounts.add(account);
        System.out.println("✅ Account Created Successfully.");
    }

    public Account getAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        System.out.println("❌ Account not found.");
        return null;
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("⚠️ No accounts available.");
        } else {
            for (Account acc : accounts) {
                acc.displayAccountInfo();
            }
        }
    }

    public void transferFunds(String fromAccNo, String toAccNo, double amount) {
        Account fromAcc = getAccount(fromAccNo);
        Account toAcc = getAccount(toAccNo);

        if (fromAcc == null || toAcc == null) {
            System.out.println("❌ One or both accounts not found.");
            return;
        }

        if (amount <= 0) {
            System.out.println("❌ Transfer amount must be greater than zero.");
            return;
        }

        if (fromAcc instanceof CurrentAccount ca ? ca.checkOverdraft(amount) : fromAcc.getBalance() >= amount) {
            fromAcc.withdraw(amount);
            toAcc.deposit(amount);
            System.out.println("💸 Transfer Successful: " + amount + " from " + fromAccNo + " to " + toAccNo);
        } else {
            System.out.println("❌ Insufficient funds for transfer.");
        }
    }
}