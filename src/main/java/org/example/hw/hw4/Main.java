package org.example.hw.hw4;

import java.util.Scanner;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = EmployeeDirectory.loadData();
        if (directory == null) {
            directory = new EmployeeDirectory();
        }

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить сотрудника");
            System.out.println("2. Вывести список всех сотрудников");
            System.out.println("3. Поиск сотрудника по имени");
            System.out.println("4. Вывести список всех номеров телефонов");
            System.out.println("5. Поиск сотрудника по стажу");
            System.out.println("6. Поиск сотрудника по табельному номеру");
            System.out.println("7. Поиск номера телефона по имени");
            System.out.println("8. Завершить программу");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Табельный номер: ");
                    int employeeId = scanner.nextInt();
                    System.out.print("Номер телефона: ");
                    String phoneNumber = scanner.next();
                    System.out.print("Имя: ");
                    String name = scanner.next();
                    System.out.print("Стаж: ");
                    int experience = scanner.nextInt();
                    directory.addEmployee(employeeId, phoneNumber, name, experience);
                    System.out.println("Сотрудник успешно добавлен.");
                    break;

                case 2:
                    directory.listAllEmployees();
                    break;

                case 3:
                    System.out.print("Введите имя сотрудника: ");
                    String nameToFind = scanner.next();
                    directory.findAndDisplayEmployeeByName(nameToFind);
                    break;

                case 4:
                    directory.listAllPhoneNumbers();
                    break;

                case 5:
                    System.out.print("Введите стаж для поиска: ");
                    int experienceToFind = scanner.nextInt();
                    directory.findAndDisplayEmployeesWithExperience(experienceToFind);
                    break;

                case 6:
                    System.out.print("Введите табельный номер для поиска: ");
                    int employeeIdToFind = scanner.nextInt();
                    Employee foundEmployee = directory.findEmployeeByEmployeeId(employeeIdToFind);
                    if (foundEmployee != null) {
                        System.out.println("Найден сотрудник: " + foundEmployee.name());
                    } else {
                        System.out.println("Сотрудник с таким табельным номером не найден.");
                    }
                    break;

                case 7:
                    System.out.print("Введите имя для поиска номера телефона: ");
                    String nameForPhoneNumberSearch = scanner.next();
                    String phoneNumberForName = directory.findPhoneNumberByName(nameForPhoneNumberSearch);
                    System.out.println("Номер телефона: " + phoneNumberForName);
                    break;

                case 8:
                    directory.saveData();
                    isRunning = false;
                    break;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, повторите.");
                    break;
            }
        }
    }
}






