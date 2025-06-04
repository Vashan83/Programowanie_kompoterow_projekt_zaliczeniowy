package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class StudentManager {
    ArrayList<Student> studentDatabase = new ArrayList<>(); // Lista przechowująca wszystkich uczniów

    // ===== Konstruktor =====

    /**
     * Konstruktor wczytujący dane z pliku CSV znajdującego się w folderze resources/CSV files/.
     * Format pliku: imię,nazwisko,ocena1,ocena2,...
     */
    public StudentManager() {
        try {
            Path path = Paths.get("resources/StudentDatabase.csv");
            List<String> lines = Files.readAllLines(path); // Wczytanie wszystkich linii z pliku

            for (String line : lines) {
                String[] parts = line.split(","); // Rozdzielenie danych po przecinku

                String name = parts[0];
                String surname = parts[1];

                ArrayList<Integer> grades = new ArrayList<>();
                for (int i = 2; i < parts.length; i++) {
                    grades.add(Integer.parseInt(parts[i])); // Parsowanie ocen do Integer
                }

                Student s = new Student(name, surname, grades);
                studentDatabase.add(s); // Dodanie ucznia do bazy danych
            }
        } catch (IOException e) {
            System.out.println("Błąd przy czytaniu pliku: " + e.getMessage());
        }
    }

    // ===== Dodawanie ocen =====

    public void addGrade(String name, String surname, Integer grade) {
        for (Student student : studentDatabase){
            if (student.getName().equals(name) && student.getSurname().equals(surname)){
                student.addGrade(grade);
            }
        }
    }

    // ===== Usuwanie konkretnej oceny =====

    /**
     * Usuwa pierwszą napotkaną ocenę o danej wartości u konkretnego ucznia.
     */
    public void removeGrade(String name, String surname, Integer gradeValue) {
        boolean studentFound = false;
        boolean gradeFound = false;

        for (Student student : studentDatabase){
            if (student.getName().equals(name) && student.getSurname().equals(surname)){
                studentFound = true;
                Iterator<Integer> iterator = student.getGrades().iterator();

                while (iterator.hasNext()) {
                    Integer grade = iterator.next();
                    if (grade.equals(gradeValue)) {
                        iterator.remove(); // Usunięcie bieżącego elementu przez iterator
                        break; // Usuwamy tylko jedną ocenę
                    }
                }
                break; // po znalezieniu ucznia nie kontynuujemy pętli
            }
        }
        if (!studentFound) {
            throw new NoSuchElementException("Nie znaleziono ucznia o podanym imieniu i nazwisku!");
        } else if (!gradeFound) {
            throw new NoSuchElementException("Uczeń nie ma podanej oceny do usunięcia!");
        }
    }

    // ===== Dodawanie i usuwanie uczniów =====

    public void addStudent(String name, String surname, ArrayList<Integer> grades) {
        Student student = new Student(name, surname, grades);
        studentDatabase.add(student);
    }

    /**
     * Usuwa ucznia z bazy danych na podstawie imienia i nazwiska.
     * Używamy Iteratora, ponieważ modyfikujemy listę w trakcie iteracji.
     */
    public void removeStudent(String name, String surname) {
        Iterator<Student> iterator = studentDatabase.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equals(name) && student.getSurname().equals(surname)) {
                iterator.remove(); // Usunięcie bieżącego elementu przez iterator
                break; // Zakładamy, że imię+nazwisko są unikalne
            }
        }
    }

    // ===== Wyświetlanie danych =====

    public void viewData() {
        for (Student student : studentDatabase) {
            System.out.println(student.toString());
        }
    }

    // ===== Sortowanie danych =====

    public void sortData() {
        Collections.sort(studentDatabase, Comparator.comparing(Student::getName));
    }

    // ===== Zapisywanie danych =====

    public void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/editedStudentDatabase.csv"))) {
            for (Student student : studentDatabase) {
                writer.write(student.getName() + "," + student.getSurname());

                for (Integer grade : student.getGrades()) {
                    writer.write("," + grade); // Dodanie każdej oceny z przecinkiem
                }

                writer.newLine(); // Nowa linia dla nowego ucznia
            }
        } catch (IOException e){
            System.out.println("Błąd przy zapisie pliku:");
            e.printStackTrace(); // Wypisanie błędu zapisu
        }
    }
}