package src;

import java.util.Scanner;

public class Menu {
    private boolean wlaczony = true; // Flaga do utrzymywania pętli działania menu
    private Scanner scan = new Scanner(System.in);
    StudentManager studentManager = new StudentManager();

    // Administrator posiada uprawnienia do edycji danych uczniów (dodawanie/edycja ocen, usuwanie uczniów itp.)
    Teacher irenka = new Teacher("admin", "test");

    public void wlacz() {
        wlaczony = true;
        while (wlaczony) {
            wyswietlMenu(); // Wyświetlamy opcje menu
            int opcja = pobierzLiczbeCalkowita(); // Pobieramy od użytkownika numer opcji
            wykonajOpcje(opcja); // Przetwarzamy wybór użytkownika
        }
    }

    // Metoda wykonuje czynność przypisaną do numeru opcji
    private void wykonajOpcje(int opcja) {
        switch (opcja) {
            case 0:
                studentManager.viewData(); // Wyświetlenie listy uczniów
                break;
            case 1:
                studentManager.sortData(); // Sortowanie uczniów alfabetycznie po imieniu
                break;
            case 2:
                irenka.removeGrade(scan, studentManager); // Usuwanie oceny wybranego ucznia
                break;
            case 3:
                irenka.addGrade(scan, studentManager);
                break;
            case 4:
                irenka.removeStudent(scan, studentManager);
                break;
            case 5:
                irenka.addStudent(scan, studentManager);
                break;
            case 6:
                studentManager.saveData();
                break;
            case 7:
                wlaczony = false;
                System.out.println(" --- KONIEC ---");
                break;
            default:
                // Obsługa nieprawidłowego wyboru
                System.out.println("Opcja " + opcja + " jest niedostępna. Wybierz opcję z menu.");
        }
    }

    // Metoda do bezpiecznego pobrania liczby całkowitej od użytkownika
    private int pobierzLiczbeCalkowita() {
        String opcjaString = scan.nextLine();
        try {
            int opcjaInt = Integer.parseInt(opcjaString);
            return opcjaInt;
        } catch (NumberFormatException e) {
            // W przypadku błędu użytkownik jest informowany i proszony o ponowny wybór
            System.out.println(opcjaString + " nie jest liczbą. Podaj liczbę całkowitą");
            return pobierzLiczbeCalkowita(); // Rekurencyjne wywołanie do skutku
        }
    }

    // Buduje i wyświetla menu główne programu
    private void wyswietlMenu() {
        StringBuilder builder = new StringBuilder();
        builder.append("Co chcesz zrobić? Wybierz opcję:\n");
        builder.append("\t(0) Wyświetl spis uczniów\n");
        builder.append("\t(1) Posortuj uczniów według imion\n");
        builder.append("\t(2) Usuń ocenę wybranego ucznia\n");
        builder.append("\t(3) Dodaj ocenę wybranemu uczniowi\n");
        builder.append("\t(4) Usuń wybranego ucznia\n");
        builder.append("\t(5) Dodaj nowego ucznia\n");
        builder.append("\t(6) Zapisz zmieniony spis uczniów\n");
        builder.append("\t(7) Zakończ program\n");
        System.out.println(builder.toString());
    }
}