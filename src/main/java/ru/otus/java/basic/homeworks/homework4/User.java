package ru.otus.java.basic.homeworks.homework4;

public class User {
    String surname;
    String name;
    String patronymic;
    int birthYear;
    String email;

    public User (String surname, String name, String patronymic, int birthYear, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthYear = birthYear;
        this.email = email;
    }

    public void outputUserInfo() {
        System.out.println("ФИО: " + surname + " " + name + " " + patronymic);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("email: " + email);
    }


}
