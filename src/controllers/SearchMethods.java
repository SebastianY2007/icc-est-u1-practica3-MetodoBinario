package controllers;

import models.Person;

public class SearchMethods {
    public Person binarySearchByAge(Person[] persons, int age) {
        int bajo = 0;
        int alto = persons.length - 1;
        
        while (bajo <= alto) {
            int centro = bajo + (alto - bajo) / 2;
            if (persons[centro].getAge() == age) {
                return persons[centro];
            }
            if (persons[centro].getAge() > age) {
                alto = centro - 1;
            } else {
                bajo = centro + 1;
            }
        }
        return null;
    }

    public Person binarySearchByName(Person[] persons, String name) {
        int bajo = 0;
        int alto = persons.length - 1;
        
        while (bajo <= alto) {
            int centro = bajo + (alto - bajo) / 2;
            if (persons[centro].getName().equals(name)) {
                return persons[centro];
            }
            if (persons[centro].getName().compareTo(name) > 0) {
                alto = centro - 1;
            } else {
                bajo = centro + 1;
            }
        }
        return null;
    }

    public boolean isSortedByAge(Person[] persons) {
        for (int i = 1; i < persons.length; i++) {
            if (persons[i].getAge() < persons[i - 1].getAge()) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedByName(Person[] persons) {
        for (int i = 1; i < persons.length; i++) {
            if (persons[i].getName().compareTo(persons[i - 1].getName()) < 0) {
                return false;
            }
        }
        return true;
    }
}