package vn.edu.likelion.bai1;

import vn.edu.likelion.bai1.Interface.AccountService;

public class SavingsAccount extends Account implements AccountService {
    private double interestRate;

    // Constructor
    public SavingsAccount(double balance){
        this.balance = balance;
        this.interestRate = 1.25;
    }
    // ----- Getter -----
    public double getBalance() {
        return balance;
    }
    public double getInterestRate() {
        return interestRate;
    }
    // ----- Getter -----

    // ----- Setter -----
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    // ----- Setter -----

    // Interface
    public void deposit(double amount){
        this.balance+=amount;
    }
    public void withdraw(double amount){
        if( this.balance < amount ){
            System.out.println("Số Tiền Không Hợp Lệ!");
        }
        this.balance-=amount;
    }
    public double calculatorInterest(int year){
        return (this.balance * this.interestRate) / 100;
    }
    public void showBalance(){
        System.out.println("Account balance: " + this.balance);
    }

    public void showBalanceAYear(){
        System.out.println("Account balance: " + (this.balance + this.calculatorInterest(1)));
    }
}
