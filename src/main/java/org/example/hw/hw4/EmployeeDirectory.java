package org.example.hw.hw4;

import java.io.*;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDirectory implements Serializable {
    private static final Logger logger = Logger.getLogger(EmployeeDirectory.class.getName());

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<Employee> employees;
    private final Map<String, String> phoneNumbersByName;
    private final Map<Integer, Employee> employeesByEmployeeId;

    public EmployeeDirectory() {
        employees = new ArrayList<>();
        phoneNumbersByName = new HashMap<>();
        employeesByEmployeeId = new HashMap<>();
    }

    public void addEmployee(int employeeId, String phoneNumber, String name, int experience) {
        Employee employee = new Employee(employeeId, phoneNumber, name, experience);
        employees.add(employee);
        phoneNumbersByName.put(name, phoneNumber);
        employeesByEmployeeId.put(employeeId, employee);
    }

    public List<Employee> findEmployeesByExperience(int experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.experience() == experience) {
                result.add(employee);
            }
        }
        result.sort(Comparator.comparingInt(Employee::employeeId));
        return result;
    }

    public String findPhoneNumberByName(String name) {
        return phoneNumbersByName.getOrDefault(name, "Сотрудник с таким именем не найден");
    }

    public Employee findEmployeeByEmployeeId(int employeeId) {
        return employeesByEmployeeId.get(employeeId);
    }

    public void listAllEmployees() {
        for (Employee employee : employees) {
            System.out.println("Табельный номер: " + employee.employeeId());
            System.out.println("Имя: " + employee.name());
            System.out.println("Номер телефона: " + employee.phoneNumber());
            System.out.println("Стаж: " + employee.experience());
            System.out.println();
        }
    }

    public void findAndDisplayEmployeeByName(String name) {
        Employee employee = findEmployeeByEmployeeName(name);
        if (employee != null) {
            System.out.println("Табельный номер: " + employee.employeeId());
            System.out.println("Имя: " + employee.name());
            System.out.println("Номер телефона: " + employee.phoneNumber());
            System.out.println("Стаж: " + employee.experience());
        } else {
            System.out.println("Сотрудник с именем " + name + " не найден.");
        }
    }

    public Employee findEmployeeByEmployeeName(String name) {
        for (Employee employee : employees) {
            if (employee.name().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null;
    }

    public void listAllPhoneNumbers() {
        for (String phoneNumber : phoneNumbersByName.values()) {
            System.out.println("Номер телефона: " + phoneNumber);
        }
    }

    public void findAndDisplayEmployeesWithExperience(int experience) {
        List<Employee> matchingEmployees = findEmployeesByExperience(experience);
        if (matchingEmployees.isEmpty()) {
            System.out.println("Сотрудники со стажем " + experience + " не найдены.");
        } else {
            System.out.println("Сотрудники со стажем " + experience + ":");
            for (Employee employee : matchingEmployees) {
                System.out.println("Табельный номер: " + employee.employeeId());
                System.out.println("Имя: " + employee.name());
                System.out.println("Номер телефона: " + employee.phoneNumber());
                System.out.println("Стаж: " + employee.experience());
                System.out.println();
            }
        }
    }

    public void saveData() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employee_data.ser"))) {
            outputStream.writeObject(this);
            System.out.println("Данные успешно сохранены в файл.");
        } catch (IOException e) {
            // Замените e.printStackTrace() на логирование ошибки
            logger.log(Level.SEVERE, "Ошибка при сохранении данных", e);
        }
    }

    public static EmployeeDirectory loadData() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("employee_data.ser"))) {
            EmployeeDirectory directory = (EmployeeDirectory) inputStream.readObject();
            System.out.println("Данные успешно загружены из файла.");
            return directory;
        } catch (IOException | ClassNotFoundException e) {
            // Замените e.printStackTrace() на логирование ошибки
            logger.log(Level.SEVERE, "Ошибка при загрузке данных", e);
            return null;
        }
    }
}