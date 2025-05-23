package src;

import java.util.Arrays;

public class Student {
    private String name;
    private String surname;
    private int[] grades;

    public Student(String name, String surname, int[] grades) {
        this.name = name;
        this.surname = surname;
        this.grades = grades;
    }

    //getters
    public  String getName() {
        return name;
    }
    public  String getSurname() {return surname;}

    @Override
    public String toString() {
        return name + " " + surname + " " + Arrays.toString(grades);
    }
}
