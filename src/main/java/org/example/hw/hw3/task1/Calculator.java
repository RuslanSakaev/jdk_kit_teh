package org.example.hw.hw3.task1;

public class Calculator {
    // Обобщенный метод для сложения
    public static <T extends Number, U extends Number> double sum(T num1, U num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    // Обобщенный метод для умножения
    public static <T extends Number, U extends Number> double multiply(T num1, U num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    // Обобщенный метод для деления
    public static <T extends Number, U extends Number> double divide(T num1, U num2) {
        if (num2.doubleValue() == 0) {
            throw new IllegalArgumentException("Деление на ноль недопустимо");
        }
        return num1.doubleValue() / num2.doubleValue();
    }

    // Обобщенный метод для вычитания
    public static <T extends Number, U extends Number> double subtract(T num1, U num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}