package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Stałe "poprawne" dane logowania
        String correctUsername = "Jan";
        String correctPassword = "Kowalski";

        //zapisujemy jakie są poprawne dane
        LogIn logowanie = new LogIn(correctUsername, correctPassword); 

        //user wpisuje dane
        System.out.print("Podaj login: ");
        String userLogin = scanner.nextLine();

        System.out.print("Podaj hasło: ");
        String userPassword = scanner.nextLine();

        //porównywanie danych systemowych z danymi od usera
        if (logowanie.authenticate(userLogin.trim(), userPassword.trim())) {
            System.out.println("Zalogowano pomyślnie jako: " + logowanie.getUsername());
        } else {
            System.out.println("Błąd logowania. Nieprawidłowa nazwa użytkownika lub hasło.");
        }

        scanner.close();
    }
}