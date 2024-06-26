package vn.edu.likelion.bai1;

public class Main {
    public static void main(String[] args){

        System.out.println("Savings Account: ");
        System.out.println("Initial Deposit: $1000.00");
        System.out.println("Interest rate: 1.25%");

        System.out.println("Current Account: ");
        System.out.println("Initial Deposit: $5000.00");
        System.out.println("OverdraftLimit: $1000.00");

        Account savingsAccount = new SavingsAccount(1000);
        Account currentAccount = new CurrentAccount(5000);

        System.out.println("Now deposit $100 to Savings Account.");
        System.out.println("Now deposit $500 to Current Account.");
        System.out.println("Withdraw $150 from Savings Account.");

        savingsAccount.deposit(100);
        currentAccount.deposit(500);
        savingsAccount.withdraw(150);

        System.out.println("Savings A/C and Current.:");

        savingsAccount.showBalance();
        currentAccount.showBalance();

        savingsAccount.showBalanceAYear();
        currentAccount.showBalance();
    }
}
