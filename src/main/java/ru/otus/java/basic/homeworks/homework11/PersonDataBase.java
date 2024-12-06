package ru.otus.java.basic.homeworks.homework11;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    private Map<Long, Person> personMap = new HashMap<>();

    public Person findById(Long id) {
        return personMap.get(id);
    }

    public void add(Person person) {
        personMap.put(person.id, person);
    }

    public boolean isManager(Person person) {
        if (person.position == Position.MANAGER || person.position == Position.DIRECTOR ||
            person.position == Position.SENIOR_MANAGER || person.position == Position.BRANCH_DIRECTOR) {
            return true;
        }
        return false;
    }

    public boolean isEmployee(Long id) {
        Person person = personMap.get(id);
        if (person.position != Position.MANAGER && person.position != Position.DIRECTOR &&
            person.position != Position.SENIOR_MANAGER && person.position != Position.BRANCH_DIRECTOR) {
            return true;
        }
        return false;
    }

}
