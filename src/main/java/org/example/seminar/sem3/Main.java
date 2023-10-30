package org.example.seminar.sem3;

import org.example.seminar.sem3.ex1.MyArray;
import org.example.seminar.sem3.ex1.Person;

public class Main {
    /*
    Описать собственную коллекцию – список на основе массива. Коллекция должна иметь
    возможность хранить любые типы данных, иметь методы добавления и удаления элементов.
     */
    public static void main(String[] args) {
        MyArray<String> array = new MyArray<>();
        array.add("1");
        array.add("2");
        array.add("3");
        array.add("4");
        System.out.println(array);

        array.remove(1);
        System.out.println();
        System.out.println(array);

        MyArray<Person> array1 = new MyArray<>();
    }
}
