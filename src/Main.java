package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProgramRuntime.startTime = System.nanoTime(); // Pobieramy czas rozpoczęcia w nanosekundach
        Scanner scanner = new Scanner(System.in);

        //Logowanie 
        LogInSystem logowanie = new LogInSystem(); 
        logowanie.authenticate(scanner);
        Menu menu = new Menu();
        menu.wlacz();
        
        scanner.close();
        ProgramRuntime.endTime = System.nanoTime(); // Pobieramy czas zakończenia w nanosekundach
        ProgramRuntime.printRuntimeDuration();
    }
}
