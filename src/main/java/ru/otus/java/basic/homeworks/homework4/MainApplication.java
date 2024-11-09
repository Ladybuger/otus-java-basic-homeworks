package ru.otus.java.basic.homeworks.homework4;

public class MainApplication {
    public static void main(String[] args) {
        User[] users = {
                new User("Иванов", "Иван", "Иванович", 1998, "ivanov@ya.ru"),
                new User("Петров", "Петр", "Петрович", 1988, "petrov@ya.ru"),
                new User("Васильев", "Василий", "Васильевич", 1978, "vasiliev@ya.ru"),
                new User("Игорев", "Игорь", "Игоревич", 1968, "igorev@ya.ru"),
                new User("Александров", "Александр", "Александрович", 1958, "aleksandrov@ya.ru"),
                new User("Данилов", "Даниил", "Даниилович", 1997, "danilov@ya.ru"),
                new User("Кириллов", "Кирилл", "Кириллович", 1987, "kirillov@ya.ru"),
                new User("Михайлов", "Михаил", "Михайлович", 1977, "mikhailov@ya.ru"),
                new User("Егоров", "Егор", "Егорович", 1967, "egorov@ya.ru"),
                new User("Савельев", "Савелий", "Савельевич", 1957, "savelyev@ya.ru")
        };

        for (int i = 0; i < users.length; i++) {
            if (2024 - users[i].getBirthYear() > 40) {
                users[i].outputUserInfo();
                System.out.println();
            }
        }

        //Задача с с коробкой

        Box box = new Box(2,3,4, "Red", true);

        box.info();
        System.out.println();
        box.repaint("Yellow");
        System.out.println();
        box.info();
        System.out.println();

        box.open();
        box.put();
        box.close();
        box.put();
        box.open();
        box.get();

    }
}
