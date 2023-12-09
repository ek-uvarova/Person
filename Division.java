package org.example;

public class Division {
    private final int id;
    private final String name;

    public Division(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Преобразовать в строку
     * @return строка с данными
     */
    @Override
    public String toString() {
        return "Division = { division.id = " + id + "; name = " + name + " }";
    }
}
