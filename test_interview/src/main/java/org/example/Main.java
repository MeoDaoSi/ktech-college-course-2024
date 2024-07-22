package org.example;

public class Main {
    public static boolean checkString(String[] arr, int index){
        int len = arr.length;
        if ( len == 0 ) {
            return false;
        }
        if ( index > len-index-1 ) {
            return true;
        }

        if ( arr[index].equals(arr[len-index-1]) ) {
            return checkString(arr,++index);
        } else {
            return false;
        }

    }
    public static void main(String[] args){
        String[] arr = {"t"};
        System.out.println(checkString(arr,0));
    }
}