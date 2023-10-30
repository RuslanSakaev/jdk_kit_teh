package org.example.seminar.sem3.ex1;

import java.io.DataInput;
import java.io.InputStream;

/*
Создать обобщенный класс с тремя параметрами (T, V, K). Класс содержит три переменные
типа (T, V, K), конструктор, принимающий на вход параметры типа (T, V, K), методы
возвращающие значения трех переменных. Создать метод, выводящий на консоль имена
классов для трех переменных класса. Наложить ограничения на параметры типа: T должен
реализовать интерфейс Comparable (классы оболочки, String), V должен реализовать
интерфейс DataInput и расширять класс InputStream, K должен расширять класс
Number.
 */
public class MyClass<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    T t;
    V v;
    K k;

    public MyClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void print(){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("K: " + k.getClass().getName());
        System.out.println("V: " + v.getClass().getName());
    }
}
