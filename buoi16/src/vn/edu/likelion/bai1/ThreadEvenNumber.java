package vn.edu.likelion.bai1;

public class ThreadEvenNumber implements Runnable{
    public void printEvenNumber() throws InterruptedException{
        for( int i=2 ; i<=20 ; i+=2 ){
            System.out.println("Even Number from oddThread: " + i);
            Thread.sleep(500);
        }
    }
    public void run(){
        try{
            printEvenNumber();
        }catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
