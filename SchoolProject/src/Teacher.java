
    /*
   This class represents teachers with firstnames, lastnames, and their respective subjects.
   It contains getters and setters for accessing their information.
   */

public class Teacher {
    private String firstname;
    private String lastname;
    private String subject;

    //constructor for teacher objects

    Teacher(String newFirst, String newLast, String newSubject) {
        firstname = newFirst;
        lastname = newLast;
        subject = newSubject;
    }

    // Getters and setters

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }
    public void setLastname(){
        this.lastname = lastname;
    }

    public String getSubject(){
        return subject = subject;
    }
    public void setSubject() { this. subject = subject; }

    //returns the description of the teacher object
    public String toString() {
        return "Name: " + firstname + " " + lastname + " Subject: " + subject;
    }
}
