import java.util.ArrayList;

    /*
    This class represents a school with students, teachers, and courses.
    It contains methods to add and delete to and from lists as well as printing the list.
     */

public class School {
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();

    //this is never used?
    ArrayList<String> course = new ArrayList<>();

    private String schoolName;
    private String schoolMascot;
    private int schoolAge;

    //constructor for school objects

    public School(String newSchoolName, String newSchoolMascot, int newSchoolAge){
        schoolName = newSchoolName;
        schoolMascot = newSchoolMascot;
        schoolAge= newSchoolAge;
    }

    //adds teachers to the list

    public void addTeacher(Teacher teacher) {

        teachers.add(teacher);
    }
    //adds students to the list

    public void addStudent(Student student) {

        students.add(student);
    }

    //deletes specified teachers from list

    public void deleteTeacher(String lastname){
        for(int i = 0; i < teachers.size(); i++){
            if (teachers.get(i).getLastname() == lastname){
                teachers.remove(teachers.get(i));
            }
        }
    }

   //deletes specified student from list

    public void deleteStudent(int studentNumber){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getStudentNumber() == studentNumber){
                students.remove(students.get(i));
            }
        }
    }

    //shows teachers list

    public void showTeachers(){
        for(int i = 0; i < teachers.size(); i++){
            System.out.println(teachers.get(i).toString());
        }
    }

    //shows student list

    public void showStudents(){
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).toString());
        }
    }


}

