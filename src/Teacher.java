package src;

import java.util.*;

public class Teacher {
    private String username;
    private String password;

    // Konstruktor inicjalizujący nauczyciela z loginem i hasłem
    public Teacher(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Gettery
    public String getPassword() {
        return password;
    }

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

        try {
            studentManager.addGrade(studentName[0], studentName[1], Integer.parseInt(grade));
            System.out.println("Ocena została dodana.");
        } catch (NoSuchElementException e) {
            System.out.println("Błąd: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Podana ocena nie jest liczbą całkowitą.");
        }
    }

    /**
     * Usuwa pierwszą instancję podanej oceny. Wymaga podania danych ucznia i konkretnej oceny do usunięcia.
     */
    public void removeGrade(Scanner scanner, StudentManager studentManager){
        String[] studentName = giveStudentName(scanner);
        System.out.println("Podaj ocenę do usunięcia:");
        String grade = scanner.nextLine();

        try {
            int parsedGrade = Integer.parseInt(grade); // Zmiana wczytanej liczby w typie String na typ int
            studentManager.removeGrade(studentName[0], studentName[1], parsedGrade);
        } catch (NumberFormatException e) {
            System.out.println("Błąd: Podana wartość nie jest liczbą całkowitą.");
        } catch (NoSuchElementException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
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

        boolean studentFound = false;
        for (Student student : studentManager.studentDatabase) {
            if (student.getName().equals(studentName[0]) && student.getSurname().equals(studentName[1])) { //Jeżeli znaleźliśmy ucznia
                studentFound = true;
                break; // Zakończ szukanie
            }
        }
        if (studentFound) {
            studentManager.removeStudent(studentName[0], studentName[1]);
        }else{
            System.out.println("Brak ucznia w bazie.");
        }

    }
}
