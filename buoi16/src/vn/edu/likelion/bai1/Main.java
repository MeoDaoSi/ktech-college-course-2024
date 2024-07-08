package vn.edu.likelion.bai1;

public class Main{
    public static void main(String[] args) {
        Runnable evenNumber = new ThreadEvenNumber();
        Runnable oddNumber = new ThreadOddNumber();
        Thread thread1 = new Thread(evenNumber);
        Thread thread2 = new Thread(oddNumber);
        thread1.start();
        thread2.start();

    }
}
