package src;

import java.util.*;

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

    private String[] giveStudentName(Scanner scanner) {
        System.out.println("Podaj imię ucznia:");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko ucznia:");
        String surname = scanner.nextLine();
        return new String[] {name, surname};
    }

    public void addGrade(Scanner scanner, StudentManager studentManager) {
        String[] studentName = giveStudentName(scanner);
        System.out.println("Podaj ocenę:");
        String grade = scanner.nextLine();

        studentManager.addGrade(studentName[0], studentName[1], Integer.parseInt(grade));
        studentManager.addGrade(studentName[0], studentName[1], Integer.parseInt(grade));
    }  // dodawanie ocen przez przekazanie zadania do studentManager wraz z oceną 

    public void removeGrade(Scanner scanner, StudentManager studentManager){
        String[] studentName = giveStudentName(scanner);
        System.out.println("Podaj ocenę do usunięcia:");
        String grade = scanner.nextLine();
        studentManager.removeGrade(studentName[0],studentName[1], Integer.valueOf(grade));
    }  // usuwanie oceny przez przekazanie zadania do studentManager wraz z wartością oceny

    public void addStudent(Scanner scanner, StudentManager studentManager) {
        String[] studentName = giveStudentName(scanner);
        System.out.println("Podaj po przecinku oceny:");
        ArrayList<Integer> grades = new ArrayList<>();
        String line = scanner.nextLine();
        try {
            for (String grade : line.split(",")) {
                try {
                    grades.add(Integer.valueOf(grade));
                } catch (Exception e) {
                    System.out.println("Zignorowano niepoprawną ocenę");
                }
        }
        } catch (Exception e) {
            //nie ma ocen, 
        }
        
        studentManager.addStudent(studentName[0], studentName[1], grades);
    }

    public void removeStudent(Scanner scanner, StudentManager studentManager) {
        String[] studentName = giveStudentName(scanner);
        studentManager.removeStudent(studentName[0], studentName[1]);
    }
}
