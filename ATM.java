import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }
}

public class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Machine :\n\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void processChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.print("\nEnter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 2:
                System.out.print("\nEnter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;
            case 3:
                System.out.println("\nCurrent balance: " + bankAccount.getBalance());
                break;
            case 4:
                System.out.println("\nExiting...");
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid choice.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(account);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            int choice = scanner.nextInt();
            atm.processChoice(choice, scanner);
        }
    }
}
