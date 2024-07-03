package vn.edu.likelion.bai1;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        // Method checks if a number is a prime number using a lambda expression.
        Predicate<Integer> primeFactor = (num) -> {
            if(num == 1 ){
                return false;
            }
            if( num == 2){
                return true;
            }
            if( num%2 == 0 ){
                return false;
            }
            for( int i=3 ; i<num ; i++){
                if(num%i == 0){
                    return false;
                }
            }
            return true;
        };
        for( int i=number/2 ; i>1 ; i-- ){
            // Checks if a number is a Prime and if it is the greatest divisor of the given number.
            if(primeFactor.test(i) && number%i==0){
                System.out.println(i);
                break;
            }
        }
    }
}