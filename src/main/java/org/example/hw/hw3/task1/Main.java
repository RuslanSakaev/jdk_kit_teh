package org.example.hw.hw3.task1;

public class Main {
    public static void main(String[] args) {
        // Используем разные типы данных T и U
        int intResult = (int) Calculator.sum(5, 3.0);
        double doubleResult = Calculator.multiply(2, 4.0);
        float floatResult = (float) Calculator.divide(10.0f, 2);
        long longResult = (long) Calculator.subtract(8L, 3);

        System.out.println("Сумма: " + intResult);
        System.out.println("Умножение: " + doubleResult);
        System.out.println("Деление: " + floatResult);
        System.out.println("Вычитание: " + longResult);
    }
}