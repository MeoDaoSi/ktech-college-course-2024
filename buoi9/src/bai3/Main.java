package bai3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // Method check number of digits in integer
    public static int getFirstElement(int input){
        int copyInput = input;
        while (copyInput != 0){
            if( copyInput / 10 != 0 ){
                copyInput = copyInput / 10;
            }else{
                return copyInput;
            }
        }
        return copyInput;
    }
    public static void main(String[] args){
        int a = -123;
        List<Integer> arr = new ArrayList<Integer>();
        System.out.printf("botd %d %s", 1 - 1,"sadas");
    }
}