package bai1;

import java.util.Arrays;

public class Main {

    public static void move(int[] arr){
        int left = 0;
        for( int right=1 ; right<arr.length ; right++ ){
            if( arr[right]!=0 ){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
        }
    }
    public static void main(String[] args) {

        int[] array = {0,0,1,0,3,0,5,0,6};
        move(array);
        System.out.println(Arrays.toString(array));

    }
}