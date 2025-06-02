import java.util.*;
import java.io.*;

public class LogInSystem {
    private List<Teacher> teachers = new ArrayList<>();

    public LogInSystem() {
        LoadUsersFromFile();
    }

    public void authenticate(Scanner scanner) {
        System.out.println("Write login:");
        String username = scanner.nextLine();

        System.out.println("Write password:");
        String password = scanner.nextLine();

        for (Teacher teacher : teachers){
            if (teacher.getUsername().equals(username) && teacher.getPassword().equals(password)) {
                System.out.println("Pomyślnie zalogowano");
                return;
            }
        }
        System.out.println("Wpisano niepoprawne dane");
    }

    private void LoadUsersFromFile() {
        File file = new File("resources/CSV files/UserDatabase.csv");

        try (Scanner fileScanner = new Scanner(file) ){
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                teachers.add(new Teacher(parts[0], parts[1]));
            }
        } catch (IOException e) {
            System.out.println("Error while reading user file.");
        }
    }
}