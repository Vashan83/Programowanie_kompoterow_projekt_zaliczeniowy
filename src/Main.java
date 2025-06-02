//package src;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        //Logowanie 
        LogInSystem logowanie = new LogInSystem(); 
        logowanie.authenticate(scanner);

        StudentManager studentManager = new StudentManager();

        scanner.close();
    }
}