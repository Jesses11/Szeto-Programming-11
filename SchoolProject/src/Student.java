    /*
    This class represents students with firstnames, lastnames, grades, and their student numbers.
    It contains getters and setters to access their information.
    */

public class Student {
    private String firstname;
    private String lastname;
    private int grade;
    private int studentNumber;
    private static int studentN = 1000;

    //constructor for student objects

    public Student(String newFirst, String newLast, int newGrade) {
        firstname = newFirst;
        lastname = newLast;
        grade = newGrade;
        this.studentNumber = studentN;
        studentN++;
    }

    //getters and setters

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getGrade() { return grade;}
    public void setGrade(int grade) { this.grade = grade; }

    public int getStudentNumber() {return studentNumber;}
    //set student number not needed. numbers should not be manually changed

    //returns the description of the student object

    public String toString() {
        return "Name: " + firstname + " " + lastname + " Grade: " + grade;
    }

}
