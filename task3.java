import java.util.Scanner;

public class task3 {
    private double balance;
    private final int accountNumber; // Store the account number

    public task3(double initialBalance, int accountNumber) {
        this.balance = initialBalance;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
        } else {
            balance += amount;
            System.out.println("Deposit successful. Current balance: " + balance);
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return false;
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
            return true;
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public static void main(String[] args) {
        task3 userAccount = new task3(1000, 98343); // Initial balance of 1000, account number is 98343
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}

class ATM {
    private task3 account;

    public ATM(task3 account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM-Interface!");
        System.out.println("Your account number is: " + account.getAccountNumber()); // Display the account number
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your account number: ");
                    int enteredAccountNumber = scanner.nextInt();
                    if (enteredAccountNumber == account.getAccountNumber()) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Incorrect account number.");
                    }
                    break;
                case 2:
                    System.out.print("Enter your account number: ");
                    enteredAccountNumber = scanner.nextInt();
                    if (enteredAccountNumber == account.getAccountNumber()) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Incorrect account number.");
                    }
                    break;
                case 3:
                    System.out.print("Enter your account number: ");
                    enteredAccountNumber = scanner.nextInt();
                    if (enteredAccountNumber == account.getAccountNumber()) {
                        System.out.println("Current balance: " + account.getBalance());
                    } else {
                        System.out.println("Incorrect account number.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
