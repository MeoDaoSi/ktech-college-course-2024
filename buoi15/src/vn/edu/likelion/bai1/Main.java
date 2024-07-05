package vn.edu.likelion.bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);
        arrList.add(5);
        arrList.add(6);
        arrList.add(7);
        arrList.add(8);
        arrList.add(9);
        arrList.add(10);
        arrList.add(12);
        arrList.add(14);
        int even = arrList.stream().filter(a -> a%2==0).mapToInt(a -> a).sum();
        int odd = arrList.stream().filter(a -> a%2!=0).mapToInt(a -> a).sum();
        System.out.println("Sum of even numbers: " + even);
        System.out.println("Sum of odd numbers: " + odd);
    }
}
