package src;

import java.util.*;
import java.io.*;

public class LogInSystem {
    private List<Teacher> teachers = new ArrayList<>();

    public LogInSystem() {
        LoadUsersFromFile(); //-> privte void LoadUsersFromFile()
    }

    public void authenticate(Scanner scanner) {
        System.out.println("Podaj login:");
        String username = scanner.nextLine();

        System.out.println("Podaj hasło: ");
        String password = scanner.nextLine();

        for (Teacher teacher : teachers){
            if (teacher.getUsername().equals(username) && teacher.getPassword().equals(password)) {
                System.out.println("Pomyślnie zalogowano");
                return;
            }
        }
        System.out.println("Wpisano niepoprawne dane");
    }
    //to jest 2 krok
    //prosimy użytkownika o wpisanie nazwy i hasła i prównujemy czy znadują się takie na naszej liście z pliku *LoadUsersFromFile();*

    private void LoadUsersFromFile() {
        File file = new File("resources/CSV files/UserDatabase.csv");

        try (Scanner fileScanner = new Scanner(file) ){
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                teachers.add(new Teacher(parts[0], parts[1]));  //-> klasa teacher nazwa i hasło 
            }
        } catch (IOException e) {
            System.out.println("Error while reading user file.");
        }
    }
    //to wykunuje się najpierw 
    //ładujemy plik csv zawierający nazwy i hasła dla nauczycieli 
    //i przechwytujemy ewentualny wyjątek niepoprawnego załadowania pliku 
}