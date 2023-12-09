package org.example;
import java.util.Date;

public class Person {
    private final int ID;
    private final String name;
    private final String gender;
    private final Division division;
    private final int salary;
    private final Date birthdate;

    /**
     * Конструктор класса person
     * @param ID
     * @param name
     * @param gender
     * @param division
     * @param salary
     * @param birthdate
     */
    public Person(int ID, String name, String gender, Division division, int salary, Date birthdate) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.division = division;
        this.salary = salary;
        this.birthdate = birthdate;
    }

    /**
     * Преобразовать в строку
     * @return строка с данными
     */
    @Override
    public String toString() {
        return "Person { ID = " + ID + "; name = " + name + "; gender = " + gender + "; " + division.toString() + "; salary = " + salary + "; birthdate = " + birthdate + " }\n";
    }
}

