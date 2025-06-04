package src;

import java.util.*;
import java.io.*;

public class LogInSystem {
    private List<Teacher> teachers = new ArrayList<>(); // Lista nauczycieli wczytana z pliku

    /**
     * Konstruktor inicjalizujący system logowania.
     * Automatycznie ładuje dane użytkowników z pliku CSV.
     */
    public LogInSystem() {
        LoadUsersFromFile(); // Wczytanie danych nauczycieli z pliku CSV
    }

    /**
     * Autoryzuje użytkownika na podstawie loginu i hasła.
     * Pobiera dane z konsoli, a następnie sprawdza je względem listy nauczycieli.
     */
    public boolean authenticate(Scanner scanner) {
        System.out.println("Podaj login:");
        String username = scanner.nextLine();

        System.out.println("Podaj hasło: ");
        String password = scanner.nextLine();

        for (Teacher teacher : teachers) {
            if (teacher.getUsername().equals(username) && teacher.getPassword().equals(password)) {
                System.out.println("Pomyślnie zalogowano");
                return true;
            }
        }

        System.out.println("Wpisano niepoprawne dane");
        return false;
    }

    /**
     * Prywatna metoda wczytująca dane użytkowników (nauczycieli) z pliku CSV.
     * Każda linia pliku powinna zawierać login i hasło oddzielone przecinkiem.
     */
    private void LoadUsersFromFile() {
        File file = new File("resources/UserDatabase.csv");

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                teachers.add(new Teacher(parts[0], parts[1])); // Dodanie nauczyciela do listy
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas odczytu pliku użytkowników.");
        }
    }
}