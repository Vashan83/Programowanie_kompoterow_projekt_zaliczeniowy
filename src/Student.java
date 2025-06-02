import java.util.*;

public class Student {
    private String name;
    private String surname;
    private ArrayList<Integer> grades;

    public Student(String name, String surname, ArrayList<Integer> grades) {
        this.name = name;
        this.surname = surname;
        this.grades = grades;
    }

    //getters
    public  String getName() {
        return name;
    }
    public  String getSurname() {
        return surname;
    }

    //nie public/private = mają do niej dostęp wyłącznie klasy w tym samym package
    void addGrade(Integer grade) {
        grades.add(grade);
    }

    void removeGrade(Integer grade) {
        //usuwa z listy pozycję o wartości grade.
        if (!grades.remove(Integer.valueOf(grade))) {
            System.out.println("Uczeń " + this.name + " " + this.surname + " nie ma takiej oceny.");
        }
    }

    
    //nadpisanie funkcji toString żeby zwracało imię nazwisko i oceny ucznia 
    @Override
    public String toString() {
        return name + " " + surname + " " + grades.toString();
    }
}
