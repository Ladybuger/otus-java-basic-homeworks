package ru.otus.java.basic.homeworks.homework9;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        int minAge = 35;

        ArrayList<Integer> result = createSequenceNumbers(3,10);
        System.out.println(result);

        System.out.println(sumListItems(result));

        rewriteListCell(79, result);
        System.out.println(result);

        increaseListItem(2, result);
        System.out.println(result);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Olga", 30));
        employees.add(new Employee("Igor", 35));
        employees.add(new Employee("Rita", 40));
        employees.add(new Employee("Nadya", 50));
        employees.add(new Employee("Vitya", 6));

        List<String> employeeNames = Employee.getEmployeeNames(employees);
        System.out.println(employeeNames);

        List<Employee> employeeNamesByMinAge = Employee.filterEmployeesByMinAge(employees, minAge);
        for (Employee employee: employeeNamesByMinAge) {
            System.out.println(employee.getName() + " - " + employee.getAge());
        }

        boolean result2 = Employee.averageAgeExceeds(employees, minAge);

        if (result2) {
            System.out.println("Average age of employees exceeds the minimum" + minAge);
        } else {
            System.out.println("Average age of employees does not exceed the minimum " + minAge);
        }

        Employee youngest = Employee.getYoungestEmployee(employees);

        if (youngest != null) {
            System.out.println("Youngest employee: " + youngest.getName() + " - " + youngest.getAge() + " years old");
        } else {
            System.out.println("No employees in the list");
        }


    }

    public static ArrayList<Integer> createSequenceNumbers(int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    public static int sumListItems(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 5) {
                sum += list.get(i);
            }
        }
        return sum;
    }

    public static void rewriteListCell(int number, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, number);
        }
    }

    public static void increaseListItem(int number, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + number);
        }
    }







}
