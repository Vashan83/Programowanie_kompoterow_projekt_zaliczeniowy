//package src;
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class StudentLoader {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        try {
            Path path = Paths.get("resources/CSV files/StudentDatabase.csv");
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                String[] parts = line.split(",");

                // Zakładamy: parts[0] = imię, parts[1] = nazwisko, reszta to oceny
                String name = parts[0];
                String surname = parts[1];

                
                //int[] grades = new int[parts.length - 2];
                ArrayList<Integer> grades = new ArrayList<>();
                for (int i = 2; i < parts.length; i++) {
                    grades.add(Integer.parseInt(parts[i]));
                }
                
                
                Student s = new Student(name, surname, grades);
                students.add(s);
            }

        } catch (IOException e) {
            System.out.println("Błąd przy czytaniu pliku: " + e.getMessage());
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }
}