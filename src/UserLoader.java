import java.util.Scanner;

public class UserLoader {
    Scanner scanner = new Scanner(new File("users.csv"));
    while (scanner.hasNextLine()) {
        String[] parts = scanner.nextLine().split(",");
        users.add(new User(parts[0], parts[1]));
    }

}
