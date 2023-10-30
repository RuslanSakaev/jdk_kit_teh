package org.example.seminar.sem3.ex1;

import java.util.Arrays;

public class MyArray<T> {
    private Object[] objects = new Object[10];
    private int size;

    public void add(T t){
        if (size >= objects.length){
            Object[] objects1 = new Object[objects.length * 2];
            System.arraycopy(objects, 0, objects1, 0, objects.length);
            objects = objects1;
        }
        objects[size++] = t;
    }

    public void remove(int index){
        //проверку индекса
        for (int i = index + 1; i < size; i++) {
            objects[i - 1] = objects[i];
        }
        size--;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            stringBuilder.append(objects[i]);
            stringBuilder.append(", ");
        }
        stringBuilder.append(objects[size-1]);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
