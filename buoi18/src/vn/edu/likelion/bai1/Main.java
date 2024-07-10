package vn.edu.likelion.bai1;

import java.util.Arrays;

public class Main {
    public static void swap(int[] arr, int i, int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int[] arr, int low, int high){

        int pivot = arr[high];
        int left = low - 1;

        for( int right = low ; right < high ; right++ ){
            if( arr[right] < pivot ){
                left++;
                swap(arr,left,right);
            }
        }
        swap(arr,left + 1,high);
        return (left + 1);
    }
    public static void sortArray(int[] nums, int left, int right){
        if( left < right ){
            int pivot = partition(nums,left,right);
            sortArray(nums,left,pivot - 1);
            sortArray(nums,pivot + 1, right);
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{8,2,4,7,1,3,9,6,5};
        System.out.println(Arrays.toString(nums));
        sortArray(nums,0,nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
