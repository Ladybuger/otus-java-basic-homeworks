package ru.otus.java.basic.homeworks.homework10;

import java.util.*;

public class MainApplication {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Ivanov Ivan Ivanoovich", 666666);
        pb.add("Petrov Petr Petrovich", 777777);
        pb.add("Vasiliev Vasiliy Vasilievich", 888888);
        pb.info();
        pb.find("Petrov Petr Petrovich");
        pb.containsPhoneNumber(888888);
    }
}
