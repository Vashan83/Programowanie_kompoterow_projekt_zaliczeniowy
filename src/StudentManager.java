package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class StudentManager {
    ArrayList<Student> studentDatabase = new ArrayList<>();

    public StudentManager() {
        // Wgrywanie danych z pliku
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
                studentDatabase.add(s);
            }
        } catch (IOException e) {
            System.out.println("Błąd przy czytaniu pliku: " + e.getMessage());
        }
    }

    public void addGrade(String name, String surname, Integer grade) {
        for (Student student : studentDatabase){
            if (student.getName().equals(name) && student.getSurname().equals(surname)){
                student.addGrade(grade);
            }
        }
        
    }

    public void removeGrade(String name, String surname, Integer gradeValue) {
        for (Student student : studentDatabase){
            if (student.getName().equals(name) && student.getSurname().equals(surname)){
                Iterator<Integer> iterator = student.getGrades().iterator();
                while (iterator.hasNext()) {
                    //analogicznie jak poniżej
                    Integer grade = iterator.next();
                    if (grade == gradeValue) {
                        iterator.remove(); // ta metoda usuwa ostatnie iterator.next()
                    }
                }
            }
        }
    }

    public void addStudent(String name, String surname, ArrayList<Integer> grades) {
        Student student = new Student(name, surname, grades);
        studentDatabase.add(student);
    }
    public void removeStudent(String name, String surname) {
        Iterator<Student> iterator = studentDatabase.iterator();
        while (iterator.hasNext()) {
            //WAŻNE ŻEBY ZROZUMIEĆ
            //nie możemy użyć tutaj pętli for, bo nie można edytować w forze listy
            //na której działa pętla. Dlatego jesteśmy zmuszeni użyć struktury Iterator
            Student student = iterator.next();
            if (student.getName().equals(name) && student.getSurname().equals(surname)) {
                iterator.remove(); // ta metoda usuwa ostatnie iterator.next()
            }
        }
    }

    public void viewData() {
        for (Student student : studentDatabase) {
            System.out.println(student.toString());
        }
    }

    public void sortData() {
        Collections.sort(studentDatabase, Comparator.comparing(Student::getName));
    }

    public void saveData() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("resources/CSV files/editedStudentDatabase.csv"));
            for (Student student : studentDatabase) {
                writer.write(student.getName() + "," + student.getSurname() + ",");
                // Łączenie ocen w jedną linię z przecinkami
                List<Integer> grades = student.getGrades();
                for (Integer grade : grades) {
                    writer.write("," + grade);  // Przecinek przed każdą oceną
                }

                writer.newLine();
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
