package org.example.seminar.sem3;

public class Main {
    /*
    Описать собственную коллекцию – список на основе массива. Коллекция должна иметь
    возможность хранить любые типы данных, иметь методы добавления и удаления элементов.
     */
    public static void main(String[] args) {
        seminar.ex2.MyArray<String> array = new seminar.ex2.MyArray<>();
        array.add("1");
        array.add("2");
        array.add("3");
        array.add("4");
        System.out.println(array);

        array.remove(1);
        System.out.println();
        System.out.println(array);

        seminar.ex2.MyArray<seminar.ex2.Person> array1 = new seminar.ex2.MyArray<>();
    }
}
