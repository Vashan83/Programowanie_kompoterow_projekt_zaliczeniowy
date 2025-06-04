package src;

import java.util.*;

public class Teacher {
    private String username;
    private String password;

    /**
     * Konstruktor nauczyciela z loginem i hasłem.
     */
    public Teacher(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Zwraca hasło nauczyciela.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Zwraca login (nazwę użytkownika) nauczyciela.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Prosi użytkownika o podanie imienia i nazwiska ucznia.
     * @return tablica zawierająca imię i nazwisko ucznia.
     */
    private String[] giveStudentName(Scanner scanner) {
        System.out.println("Podaj imię ucznia:");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko ucznia:");
        String surname = scanner.nextLine();
        return new String[] {name, surname};
    }

    /**
     * Dodaje ocenę uczniowi. Wymaga podania danych ucznia i oceny.
     */
    public void addGrade(Scanner scanner, StudentManager studentManager) {
        String[] studentName = giveStudentName(scanner);
        System.out.println("Podaj ocenę:");
        String grade = scanner.nextLine();

        // UWAGA: Ocena jest dodawana dwukrotnie – prawdopodobnie błąd
        studentManager.addGrade(studentName[0], studentName[1], Integer.parseInt(grade));
        studentManager.addGrade(studentName[0], studentName[1], Integer.parseInt(grade));
    }

    /**
     * Usuwa ocenę ucznia. Wymaga podania danych ucznia i konkretnej oceny do usunięcia.
     */
    public void removeGrade(Scanner scanner, StudentManager studentManager){
        String[] studentName = giveStudentName(scanner);
        System.out.println("Podaj ocenę do usunięcia:");
        String grade = scanner.nextLine();
        studentManager.removeGrade(studentName[0], studentName[1], Integer.valueOf(grade));
    }

    /**
     * Dodaje nowego ucznia. Można podać listę ocen oddzielonych przecinkami.
     */
    public void addStudent(Scanner scanner, StudentManager studentManager) {
        String[] studentName = giveStudentName(scanner);
        System.out.println("Podaj po przecinku oceny:");
        ArrayList<Integer> grades = new ArrayList<>();
        String line = scanner.nextLine();

        try {
            for (String grade : line.split(",")) {
                try {
                    grades.add(Integer.valueOf(grade.trim()));
                } catch (Exception e) {
                    System.out.println("Zignorowano niepoprawną ocenę");
                }
            }
        } catch (Exception e) {
            // Brak ocen – tworzymy ucznia bez ocen
        }

        studentManager.addStudent(studentName[0], studentName[1], grades);
    }

    /**
     * Usuwa ucznia na podstawie podanego imienia i nazwiska.
     */
    public void removeStudent(Scanner scanner, StudentManager studentManager) {
        String[] studentName = giveStudentName(scanner);
        studentManager.removeStudent(studentName[0], studentName[1]);
    }
}
