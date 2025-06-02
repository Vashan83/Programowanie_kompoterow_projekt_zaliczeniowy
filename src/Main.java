//package src;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Logowanie się
        LogInSystem logowanie = new LogInSystem(); 
        logowanie.authenticate(scanner);

        scanner.close();
    }
}