import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        //Logowanie 
        LogInSystem logowanie = new LogInSystem(); 
        logowanie.authenticate(scanner);

        StudentManager studentManager = new StudentManager();
        studentManager.viewData();
        
        scanner.close();


        long startTime = System.nanoTime(); // Pobieramy czas rozpoczęcia w nanosekundach

        // !!!!!!!!!TUTAJ UMIEŚĆ MENU *kod*, którego czas działania chcesz zmierzyć
        // Na przykład, symulacja długiej operacji:
        for (int i = 0; i < 1000000; i++) {
            double result = Math.sqrt(i) * Math.sin(i);
        }

        long endTime = System.nanoTime(); // Pobieramy czas zakończenia w nanosekundach

        long durationInNano = endTime - startTime; // Czas działania w nanosekundach
        long durationInMillis = durationInNano / 1_000_000; // Konwersja na milisekundy
        long durationInSeconds = durationInMillis / 1000; // Konwersja na sekundy

        System.out.println("Czas działania (nanosekundy): " + durationInNano);
        System.out.println("Czas działania (milisekundy): " + durationInMillis);
        System.out.println("Czas działania (sekundy): " + durationInSeconds);
    }
}
