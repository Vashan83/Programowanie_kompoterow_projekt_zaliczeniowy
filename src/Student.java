package src;

import java.util.*;

// Klasa reprezentująca pojedynczego ucznia z imieniem, nazwiskiem i listą ocen
public class Student {
    private String name;
    private String surname;
    private ArrayList<Integer> grades;

    // Konstruktor inicjalizujący wszystkie pola ucznia
    public Student(String name, String surname, ArrayList<Integer> grades) {
        this.name = name;
        this.surname = surname;
        this.grades = grades;
    }

    // Gettery
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    /**
     * Dodaje nową ocenę do listy ocen ucznia.
     * Modyfikator domyślny (brak public/private) oznacza, że metoda jest dostępna tylko w obrębie pakietu `src`.
     */
    void addGrade(Integer grade) {
        grades.add(grade);
    }

    /**
     * Nadpisanie metody toString
     * Zwraca reprezentację tekstową obiektu ucznia – imię, nazwisko oraz jego oceny.
     * To ułatwia debugowanie oraz wyświetlanie danych ucznia np. w konsoli.
     */
    @Override
    public String toString() {
        return name + " " + surname + ": " + grades.toString();
    }
}
