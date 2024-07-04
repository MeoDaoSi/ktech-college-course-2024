package vn.edu.likelion.bai1;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Predicate<StringBuilder> isPalindrome = str -> {
            String temp = str.toString();
            return str.reverse().toString().equals(temp);
        };
        System.out.println("Madam is a palindrome? " + isPalindrome.test(new StringBuilder("Madam")));
        System.out.println("radar is a palindrome? " + isPalindrome.test(new StringBuilder("radar")));
        System.out.println("defied is a palindrome? " + isPalindrome.test(new StringBuilder("defied")));
    }
}
