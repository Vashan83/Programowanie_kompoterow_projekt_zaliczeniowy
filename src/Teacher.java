package src;

import java.util.*;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.io.*;
>>>>>>> 795c6f39a82cb80a0d23b8259ec7daf9e8442e8b
=======
import java.io.*;
>>>>>>> fa031efcca80ac979c9e5d54f239f6e80ed53eff

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
    }  // dodawanie ocen przez przekazanie zadania do studentManager wraz z oceną 

    public void removeGrade(StudentManager studentManager, Student student, Integer grade){
        studentManager.removeGrade(student, grade);
    }  // usuwanie oceny przez przekazanie zadania do studentManager wraz z wartością oceny

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
