package ru.otus.java.basic.homeworks.homework10;

import java.util.*;

public class PhoneBook {
    private Map<String, Set<Integer>> phoneBook = new HashMap<>();

    public Map<String, Set<Integer>> add(String name, int phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } else {
            Set<Integer> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
        return phoneBook;
    }

    public void find(String name) {
        Set<Integer> values = phoneBook.get(name);
        for (Integer value : values) {
            System.out.println("У " + name + " номер телефона " + value);
        }
    }

    public void containsPhoneNumber(int phoneNumber) {
        for (Map.Entry<String, Set<Integer>> entry : phoneBook.entrySet()) {
            String key = entry.getKey();
            Set<Integer> values = entry.getValue();
            for (Integer value : values) {
               if (phoneNumber == value) {
                   System.out.println("Номер телефона " + phoneNumber + " есть в справочнике");
               }
            }
        }
    }


    public void info() {
        for (Map.Entry<String, Set<Integer>> entry : phoneBook.entrySet()) {
            String key = entry.getKey();
            Set<Integer> values = entry.getValue();
            for (Integer value : values) {
                System.out.println(key + ", " + value);
            }
        }
    }

}
