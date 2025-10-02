import java.util.*;

// Class to represent account holder details and opening an account
// Single Responsibility Principle: This class only handles account holder data and creation
class AccountOpening {
    String name;
    String mobileNumber;
    String address;
    Random random = new Random();
    int accountNumber;

    // Constructor initializes profile and generates random account number
    AccountOpening(String name, String mobileNumber, String address) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.address = address;
        // Generate account number between 1000 and 9999
        this.accountNumber = 1000 + random.nextInt(9000);
    }

    // Display account profile details
    // Encapsulation: Details displayed through this public method instead of direct variable access
    void displayProfile() {
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: Saving Account");
        System.out.println("Address: " + address);
    }
}

// Interface defining account operations (Interface Segregation Principle - ISP)
// Keeps interface focused on account operations only
interface AccountOperations {
    void deposit(double amount);

    void withdraw(double amount);

    double getBalance();
}

// Abstract class implementing AccountOperations (Promotes Liskov Substitution Principle - LSP)
// Base class ensures concrete accounts can substitute it
abstract class Account implements AccountOperations {
    protected int accountNo;
    protected double balance;

    public Account(int accountNo, double initialBalance) {
        this.balance = initialBalance;
        this.accountNo = accountNo;
    }

    // Deposit money, simple validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    // Abstract withdraw method allows different behaviors in subclasses
    public abstract void withdraw(double amount);
}

// Concrete SavingAccount inherits from Account (Liskov Substitution Principle - LSP holds)
// Implements withdrawal rules specific to saving accounts
class SavingAccount extends Account {
    public SavingAccount(int accountNo, double initialBalance) {
        super(accountNo, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds or invalid amount value.");
        }
    }
}

// Service class handling loan-related operations (SRP: single responsibility for loan calculations)
// Open/Closed Principle (OCP): can extend loan operations for new loan types without modifying existing code
class LoanOperations {
    int emiPerYear = 12;

    // Calculate EMI using amortization formula (OCP)
    public double calculateEMI(double principal, int tenureYears, double loanInterestRate) {
        double monthlyInterestRate = loanInterestRate / (emiPerYear * 100); // Convert annual rate to monthly decimal
        int totalEMIs = tenureYears * emiPerYear;

        double emi = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalEMIs))
                / (Math.pow(1 + monthlyInterestRate, totalEMIs) - 1);

        return emi;
    }
}

public class Main {
    // Holds current active account, managing a single account (SRP can be improved here)
    private static Account savingAccount = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        // Main program loop for user interaction (encapsulation of program flow)
        while (!exit) {
            System.out.println("1. Open Account\n2. Deposit Money\n3. Withdraw Money\n4. Check Balance\n5. Loan\n6. Exit");
            int a = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (a) {
                case 1:
                    // Single Responsibility: `accountOpen()` handles all details related to account creation
                    savingAccount = accountOpen();
                    break;

                case 2:
                    if (savingAccount == null) {
                        System.out.println("Please open an account first.");
                        break;
                    }
                    System.out.println("Enter Amount to deposit:");
                    double depositAmount = sc.nextDouble();
                    savingAccount.deposit(depositAmount);
                    break;

                case 3:
                    if (savingAccount == null) {
                        System.out.println("Please open an account first.");
                        break;
                    }
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = sc.nextDouble();
                    savingAccount.withdraw(withdrawAmount);
                    break;

                case 4:
                    if (savingAccount == null) {
                        System.out.println("Please open an account first.");
                        break;
                    }
                    System.out.println("Current Balance: " + savingAccount.getBalance());
                    break;

                case 5:
                    loanMethod();
                    break;

                case 6:
                    exit = true;
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }

    // Creates account and returns the linked SavingsAccount (SRP: only opening account logic here)
    public static Account accountOpen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Full Name:");
        String name = sc.nextLine();
        System.out.println("Enter Your Mobile Number:");
        String mobileNumber = sc.nextLine();
        System.out.println("Enter Your Address:");
        String address = sc.nextLine();

        AccountOpening acc1 = new AccountOpening(name, mobileNumber, address);
        acc1.displayProfile();

        // Return account object linked with new account number
        return new SavingAccount(acc1.accountNumber, 0.0);
    }

    // Calculates loan EMI and interest (SRP: loan calculation only, OCP allows adding loan types)
    public static void loanMethod() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Loan amount:");
        double principal = sc.nextDouble();
        System.out.println("Time period in years:");
        int tenureYears = sc.nextInt();
        System.out.println("1. Home Loan\n2. Gold Loan");
        int choices = sc.nextInt();

        LoanOperations loan = new LoanOperations();
        double interestRate = (choices == 1) ? 8.5 : 6.5;
        double emi = loan.calculateEMI(principal, tenureYears, interestRate);
        double totalAmountPaid = emi * tenureYears * 12;
        double totalInterest = totalAmountPaid - principal;

        System.out.printf("Monthly EMI: %.2f\n", emi);
        System.out.printf("Total Interest Paid: %.2f\n", totalInterest);
    }
}
