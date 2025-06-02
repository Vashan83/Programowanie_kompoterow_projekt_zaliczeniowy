
public class Teacher {
    private String username;
    private String password;

    public Teacher(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //getery
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }

    public void addGrade(Student student, Integer grade) {
        student.addGrade(grade);
    }

    public void removeGrade(Student student, Integer grade){
        student.removeGrade(grade);
    }
}
