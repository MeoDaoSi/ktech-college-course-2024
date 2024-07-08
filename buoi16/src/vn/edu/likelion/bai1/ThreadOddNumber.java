package vn.edu.likelion.bai1;

public class ThreadOddNumber implements Runnable{
    public void printOddNumber() throws InterruptedException{
        for( int i=1 ; i<=20 ; i+=2 ){
            Thread.sleep(500);
            System.out.println("Odd Number from oddThread: " + i);
        }
    }
    public void run(){
        try{
            printOddNumber();
        }catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
