package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Rejestrujemy czas rozpoczęcia działania programu (w nanosekundach) – wykorzystywane do pomiaru czasu trwania działania całej aplikacji
        ProgramRuntime.startTime = System.nanoTime();
        Scanner scanner = new Scanner(System.in);

        // Inicjalizacja systemu logowania i rozpoczęcie autoryzacji użytkownika
        LogInSystem logowanie = new LogInSystem();
        if (logowanie.authenticate(scanner)) {
            // Po zalogowaniu uruchamiamy główne menu aplikacji
            Menu menu = new Menu();
            menu.turnOn();
        }
        scanner.close(); // Zamykamy skaner po zakończeniu działania programu        

        // Rejestrujemy czas zakończenia działania programu
        ProgramRuntime.endTime = System.nanoTime();
        ProgramRuntime.printRuntimeDuration(); // Wyświetlamy czas działania programu
    }
}
