package org.example.hw.hw3.task2;

import java.util.Arrays;

public class ArrayComparator {
    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        // Проверяем, что массивы не равны null и имеют одинаковую длину
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return false;
        }

        // Сортируем оба массива
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Сравниваем отсортированные массивы
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Integer[] intArray1 = {1, 2, 3, 4, 5};
        Integer[] intArray2 = {5, 4, 3, 2, 1};
        String[] strArray1 = {"apple", "banana", "cherry"};
        String[] strArray2 = {"cherry", "banana", "apple"};

        boolean intArraysEqual = compareArrays(intArray1, intArray2);
        boolean strArraysEqual = compareArrays(strArray1, strArray2);

        System.out.println("Integer массивы одинаковы: " + intArraysEqual);
        System.out.println("String массивы одинаковы: " + strArraysEqual);
    }

}
