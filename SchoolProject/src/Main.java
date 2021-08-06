/*
This is the driver class. It runs the whole program.
 */

public class Main {
    //runs the program
    public static void main(String[] args) {

    //creates the school object
        School school = new School("Vancouver Christian School", "Phoenix", 50);

    //creates students and adds them to the student list

        school.addStudent(new Student("Jesse", "Szeto", 11));
        school.addStudent(new Student("Jacky", "Tsoi", 12));
        school.addStudent(new Student("Mickey", "Mouse", 9));
        school.addStudent(new Student("Minnie", "Mouse", 8));
        school.addStudent(new Student("Angry", "Bird", 4));
        school.addStudent(new Student("Steve", "Stonecutter", 10));
        school.addStudent(new Student("Justin", "Law", 12));
        school.addStudent(new Student("Donkey", "Kong", 7));
        school.addStudent(new Student("Mario", "Mario", 6));
        school.addStudent(new Student("Luigi", "Mario", 5));

    //creates teachers and adds them to the teachers list

        school.addTeacher(new Teacher("Vincent", "Yuen", "Supervised Online Learning"));
        school.addTeacher(new Teacher("Captain", "Falcon", "English 101"));
        school.addTeacher(new Teacher("Piranha", "Plant", "Botany 101"));

    //prints out student list

        System.out.println("Student List: ");
        school.showStudents();

    //prints out teacher list

        System.out.println("\nTeacher List: ");
        school.showTeachers();

    //deletes students 1002 and 1009 from the lists

        school.deleteStudent(1002);
        school.deleteStudent(1009);

    //deletes teacher with the last name Falcon

        school.deleteTeacher("Falcon");

    //prints out updated student list

        System.out.println("\nUpdated Student List: ");
        school.showStudents();

    //prints out updated teacher list

        System.out.println("\nUpdate Teacher List: ");
        school.showTeachers();




    }
}
