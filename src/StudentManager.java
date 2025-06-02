import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class StudentManager {
    ArrayList<Student> studentDatabase = new ArrayList<>();

    public StudentManager() {
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
                StudentDatabase.add(s);
            }

        } catch (IOException e) {
            System.out.println("Błąd przy czytaniu pliku: " + e.getMessage());
        }

    }

    public void addGrade(Student student, Integer grade) {
        student.addGrade(grade);
    }

    public void removeGrade(Student student, Integer grade) {
        student.removeGrade(grade);
    }

    public void addStudent(String name, String surname, ArrayList<Integer> grades) {
        Student student = new Student(name, surname, grades);
        studentDatabase.add(student);
    }
    public void removeStudent(String name, String surname) {
        for (Student student : studentDatabase) {
            if (student.getName().equals(name) && student.getSurname().equals(surname)) {
                studentDatabase.remove(student);
            }
        }
    }

    public void viewData() {
        for (Student student : ) {

        }
    }
}
