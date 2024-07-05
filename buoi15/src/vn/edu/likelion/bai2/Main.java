package vn.edu.likelion.bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();
        arrList.add(10);
        arrList.add(23);
        arrList.add(22);
        arrList.add(23);
        arrList.add(24);
        arrList.add(24);
        arrList.add(33);
        arrList.add(15);
        arrList.add(26);
        arrList.add(15);
        List<Integer> newList = arrList.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);
    }
}
