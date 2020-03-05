package UI;

import Entity.Report;
import Entity.Student;
import Business.*;

import java.util.ArrayList;
import java.util.List;


public class Helper {


    /**
     * Show menu 's choices to user
     */
    public static void menu() {
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");
        System.out.print(" Enter your choice: ");
    }

    /**
     * Allow user create new student
     * @param students listStudent is in used
     */
    public static Student createStudent(StudentManagement students) {
        //loop until user input not duplicate
        while (true) {
            System.out.print("Enter ID: ");
            String id = InputChecker.checkInputString();
            System.out.print("Enter name student: ");
            String name = InputChecker.checkInputString();
            if (!Validation.checkIdExist(students, id, name)) {
                System.err.println("Id has exist student. Pleas re-input.");
                continue;
            }
            System.out.print("Enter semester: ");
            String semester = InputChecker.checkInputString();
            System.out.print("Enter name course: ");
            String course = InputChecker.checkInputCourse();
            //check student exist or not
            if (Validation.checkStudentExist(students, new Student(id, name, semester, course))) {
                return new Student(id, name, semester, course);
            }
            System.err.println("Duplicate.");
        }
    }

    public static Student createStudent() {
            System.out.print("Enter ID: ");
            String id = InputChecker.checkInputString();
            System.out.print("Enter name student: ");
            String name = InputChecker.checkInputString();
            System.out.print("Enter semester: ");
            String semester = InputChecker.checkInputString();
            System.out.print("Enter name course: ");
            String course = InputChecker.checkInputCourse();
            return new Student(id, name, semester, course);
    }

    /**
     * Get exactly student user want to update/delete in list found
     * Called by updateOeDelete func
     * @param listStudentFindByName list of all Students
     * @return a Student Object
     */
    static Student getStudentToEdit(List<Student> listStudentFindByName) {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        //display list student found
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.print("Enter student: ");
        int choice = InputChecker.checkInputIntLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice - 1);
    }

}