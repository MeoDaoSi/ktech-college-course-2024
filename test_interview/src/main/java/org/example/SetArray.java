package org.example;

//  Please create a class representing a Set with the following methods:
//        - initialize(elements) to set initial elements to the set.
//        - add(element) to add a new element to the set.
//        - remove(element) to remove an existing element from the set.
//        - check_exist(element) to determine if an element exists within the set.

import java.sql.Array;

public class SetArray {
    private int[] arr = new int[100];
    private static int count = 0;

    public int[] getArray(){
        return arr;
    }
    public void setArray(int[] arr){
        this.arr = arr;
    }

    // method add
    public void addElement(int num){
        if (!existElement(num)) {
            arr[count] = num;
            count++;
        }
    }
    public void removeElement(int num){
        for( int i=0 ; i<count ; i++ ){
            if ( arr[i] == num ) {
                arr[i] = arr[arr.length - 1];
                count--;
                break;
            }
        }
    }
    public boolean existElement(int num){
        for( int e: arr ){
            if ( e == num ) {
                return true;
            }
        }
        return false;
    }
}
