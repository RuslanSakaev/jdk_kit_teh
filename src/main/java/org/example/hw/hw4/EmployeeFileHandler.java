package org.example.hw.hw4;

import java.io.*;
import java.util.List;

public class EmployeeFileHandler {
    private static final String FILE_NAME = "employee_directory.txt";

    public static void saveEmployeeData(List<Employee> employees) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(employees);
            System.out.println("Данные сохранены в файле: " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> loadEmployeeData() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME)) ) {
            List<Employee> employees = (List<Employee>) inputStream.readObject();
            System.out.println("Данные загружены из файла: " + FILE_NAME);
            return employees;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

