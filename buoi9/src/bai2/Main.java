package bai2;

import java.util.Scanner;

public class Main {
    // Return true if every digit of the integer is even
    public static boolean check(int input){
        int copyInput = input;
        while (copyInput != 0){
            int check = copyInput % 10; // get element at end of input
            if( check%2 == 0 ){
                return false;
            }
            copyInput = copyInput / 10;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(check(input));
    }
}
