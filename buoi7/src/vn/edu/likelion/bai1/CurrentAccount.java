package vn.edu.likelion.bai1;

import vn.edu.likelion.bai1.Interface.AccountService;

public class CurrentAccount extends Account implements AccountService {
    private double overDraftLimit;

    // Constructor
    public CurrentAccount(double balance){
        this.balance = balance;
        this.overDraftLimit = 1000.00;
    }
    // ----- Getter -----
    public double getDeposit() {
        return balance;
    }
    public double getOverDraftLimit() {
        return overDraftLimit;
    }
    // ----- Getter -----

    // ----- Setter -----
    public void setDeposit(double balance) {
        this.balance = balance;
    }
    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }
    // ----- Setter -----


    public void send(double amount){
        this.balance+=amount;
    }
    public void withdraw(double amount){
        if( this.balance < amount ){
            System.out.println("Số Tiền Không Hợp Lệ!");
        }
        if( amount > this.overDraftLimit ){
            System.out.println("Gio Han Rut Tien La: 1000");
        }
        this.balance-=amount;
    }
    public void showBalance(){
        System.out.println("Account Balance: " + this.balance);
    }
}
