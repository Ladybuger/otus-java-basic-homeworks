package ru.otus.java.basic.homeworks.homework9;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static List<String> getEmployeeNames(List<Employee> employees) {
        List<String> names = new ArrayList<>();

        for (Employee employee: employees) {
            names.add(employee.getName());
        }
        return names;
    }

    public static List<Employee> filterEmployeesByMinAge(List<Employee> employees, int minAge) {
        List<Employee> names = new ArrayList<>();

        for (Employee employee: employees) {
            if (employee.getAge() >= minAge) {
                names.add(employee);
            }
        }
        return names;
    }

    public static boolean averageAgeExceeds(List<Employee> employees, int minAge) {
        int totalAge = 0;

        for (Employee employee: employees) {
            totalAge += employee.getAge();
        }

        int averageAge = totalAge / employees.size();
        return averageAge > minAge;
    }

    public static Employee getYoungestEmployee(List<Employee> employees) {
        Employee youngestEmployee = employees.get(0);

        for (Employee employee : employees) {
            if (employee.getAge() < youngestEmployee.getAge()) {
                youngestEmployee = employee;
            }
        }

        return youngestEmployee;
    }



}
