package vn.edu.likelion.bai1;

public class Account {
    protected double balance;

    public void deposit(double amount){
        this.balance+=amount;
    }
    public void withdraw(double amount){
        if( this.balance < amount ){
            System.out.println("Số Tiền Không Hợp Lệ!");
        }
        this.balance-=amount;
    }
    public void showBalance(){
        System.out.println("Account balance: " + this.balance);
    }

    public void showBalanceAYear(){

    };

}
