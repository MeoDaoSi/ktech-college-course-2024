package vn.edu.likelion.bai2;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 7, 18, 25, 77, 300, 101};

        // Tìm phần tử nhỏ nhất
        OptionalInt minElement = Arrays.stream(array).min();

        if (minElement.isPresent()) {
            System.out.println("Phần tử nhỏ nhất: " + minElement.getAsInt());
        } else {
            System.out.println("Mảng trống");
        }

        // Tìm phần tử lớn thứ hai
        Optional<Integer> secondLargestElement = Arrays.stream(array)
                .distinct()
                .boxed()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst();

        if (secondLargestElement.isPresent()) {
            System.out.println("Phần tử lớn thứ hai: " + secondLargestElement.get());
        } else {
            System.out.println("Mảng không có đủ phần tử để tìm phần tử lớn thứ hai");
        }
    }
}
