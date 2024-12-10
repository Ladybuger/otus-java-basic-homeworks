package ru.otus.java.basic.homeworks.homework11;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    private Map<Long, Person> personMap;
    private Map<Position, Boolean> managerPositions;

    public PersonDataBase() {
        personMap = new HashMap<>();
        managerPositions = new HashMap<Position, Boolean>();
        managerPositions.put(Position.MANAGER, true);
        managerPositions.put(Position.DIRECTOR, true);
        managerPositions.put(Position.BRANCH_DIRECTOR, true);
        managerPositions.put(Position.SENIOR_MANAGER, true);
    }

    public Person findById(Long id) {
        return personMap.get(id);
    }

    public void add(Person person) {
        personMap.put(person.id, person);
    }

    public boolean isManager(Person person) {
        return managerPositions.getOrDefault(person.position, false);
    }

    public boolean isEmployee(Long id) {
        Person person = personMap.get(id);
        return !isManager(person);
    }

}
