import java.util.*;
import java.io.*;

public class LogInSystem {
    private List<User> users = new ArrayList<>();

    public LogInSystem() {
        LoadUsersFromFile();
    }

    public void authenticate(Scanner scanner) {
        System.out.println("Write login:");
        String username = scanner.nextLine();

        System.out.println("Write password:");
        String password = scanner.nextLine();

        for (User user : users){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Pomyślnie zalogowano");
                return;
            }
        }
        System.out.println("Wpisano niepoprawne dane.");
    }

    private void LoadUsersFromFile() {
        File file = new File("resources/CSV files/UserDatabase.csv");

        try (Scanner fileScanner = new Scanner(file) ){
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                users.add(new User(parts[0], parts[1]));
            }
        } catch (IOException e) {
            System.out.println("Error while reading user file.");
        }
    }
}