package vn.edu.likelion.bai2;

import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args){
        Function<Integer,Integer> tranferToBinary = (a) -> {
            if( a < 1 ){
                return 0;
            }
            StringBuilder str = new StringBuilder();
            while( a > 0 ){
                int c = a % 2;
                str.insert(0,c);
                a /= 2;
            }
            return Integer.parseInt(str.toString());
        };
        System.out.println("Enter Number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(tranferToBinary.apply(number));
    }
}
