import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n🏦 Bank Management System");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Show Accounts");
            System.out.println("6. Add Interest (Savings)");
            System.out.println("7. Transfer Funds");
            System.out.println("8. Exit");
            System.out.print("👉 Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Account No: ");
                    String accNo = sc.next();
                    System.out.print("Enter Holder Name: ");
                    String holder = sc.next();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    System.out.print("Enter Interest Rate: ");
                    double rate = sc.nextDouble();
                    bank.createAccount(new SavingsAccount(accNo, holder, bal, rate));
                }
                case 2 -> {
                    System.out.print("Enter Account No: ");
                    String accNo = sc.next();
                    System.out.print("Enter Holder Name: ");
                    String holder = sc.next();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    System.out.print("Enter Overdraft Limit: ");
                    double limit = sc.nextDouble();
                    bank.createAccount(new CurrentAccount(accNo, holder, bal, limit));
                }
                case 3 -> {
                    System.out.print("Enter Account No: ");
                    String accNo = sc.next();
                    Account acc = bank.getAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter Amount: ");
                        double amt = sc.nextDouble();
                        acc.deposit(amt);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Account No: ");
                    String accNo = sc.next();
                    Account acc = bank.getAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter Amount: ");
                        double amt = sc.nextDouble();
                        acc.withdraw(amt);
                    }
                }
                case 5 -> bank.displayAllAccounts();
                case 6 -> {
                    System.out.print("Enter Savings Account No: ");
                    String accNo = sc.next();
                    Account acc = bank.getAccount(accNo);
                    if (acc instanceof SavingsAccount sa) {
                        sa.addInterest();
                    } else {
                        System.out.println("❌ Not a Savings Account.");
                    }
                }
                case 7 -> {
                    System.out.print("Enter Sender Account No: ");
                    String fromAcc = sc.next();
                    System.out.print("Enter Receiver Account No: ");
                    String toAcc = sc.next();
                    System.out.print("Enter Amount to Transfer: ");
                    double amt = sc.nextDouble();
                    bank.transferFunds(fromAcc, toAcc, amt);
                }
                case 8 -> {
                    System.out.println("👋 Thank you for using the system!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice!");
            }
        }
    }
}