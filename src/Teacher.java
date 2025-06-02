package src;

import java.util.*;
import java.io.*;

public class Teacher {
    private String username;
    private String password;

    public Teacher(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //getery
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }

    public void addGrade(StudentManager studentManager, Student student, Integer grade) {
        studentManager.addGrade(student, grade);
    }

    public void removeGrade(StudentManager studentManager, Student student, Integer grade){
        studentManager.removeGrade(student, grade);
    }

    public void addStudent(Scanner scanner, StudentManager studentManager) {
        System.out.println("Podaj imię ucznia:");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko ucznia:");
        String surname = scanner.nextLine();

        System.out.println("Podaj po przecinku oceny:");
        ArrayList<Integer> grades = new ArrayList<>();
        String line = scanner.nextLine();
        //TO DO: wyjątek jak ktoś poda coś innego niż ocenę
        for (String grade : line.split(",")) {
            grades.add(Integer.valueOf(grade));
        }
        studentManager.addStudent(name, surname, grades);
    }

    public void removeStudent(Scanner scanner, StudentManager studentManager) {
        System.out.println("Podaj imię ucznia:");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko ucznia:");
        String surname = scanner.nextLine();

        studentManager.removeStudent(name, surname);
    }
}
