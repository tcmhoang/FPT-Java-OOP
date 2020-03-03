package UI;

import Entity.Report;
import Entity.Student;
import Business.*;

import java.util.ArrayList;
import java.util.Collections;
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
    public static void createStudent(StudentManagement students) {
        //if number of students greater than 10 ask user continue or not
        if (students.isGreaterThan10()) {
            System.out.print("Do you want to continue (Y/N): ");
            if (!InputChecker.checkInputYN()) {
                return;
            }
        }
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
            if (Validation.checkStudentExist(students, id, name, semester, course)) {
                students.add(new Student(id, name, semester, course));
                System.out.println("Add success.");
                return;
            }
            System.err.println("Duplicate.");
        }
    }
    //Allow user find and sort

    /**
     * Sort students by name and find them. If a student in list this will print to console
     * In Format NAME|SEMESTER|COURSE_NAME
     * @param studentManagement Student management object
     */
    public static void findAndSort(StudentManagement studentManagement) {
        //check list empty 
        if (studentManagement.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter name to search: ");
        String name = InputChecker.checkInputString();
        List<Student> listStudentFindByName = studentManagement.getListStudentByName(name);
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not exist.");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
            //loop from first to last element of list student
            for (Student student : listStudentFindByName) {
                student.print();
            }
        }
    }

    /**
     * Allow user update and delete students via console
     * @param studentManagement Student management object
     */
    public static void updateOrDelete(StudentManagement studentManagement) {
        //if list empty 
        if (studentManagement.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter ID: ");
        String id = InputChecker.checkInputString();
        List<Student> listStudentFindByName = studentManagement.getListStudentById(id);
        //check list empty
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not found student.");
        } else {
            Student student = getStudentByList(listStudentFindByName);
            System.out.print("Do you want to update (U) or delete (D) student: ");
            //check user want to update or delete
            if (InputChecker.checkInputUD()) {
                System.out.print("Enter id: ");
                String idStudent = InputChecker.checkInputString();
                System.out.print("Enter name student: ");
                String name = InputChecker.checkInputString();
                System.out.print("Enter semester: ");
                String semester = InputChecker.checkInputString();
                System.out.print("Enter name course: ");
                String course = InputChecker.checkInputCourse();
                //check user change or not
                if (!Validation.checkChangeInformation(student, id, name, semester, course)) {
                    System.err.println("Nothing change.");
                }
                //check student exist or not
                if (Validation.checkStudentExist(studentManagement, id, name, semester, course)) {
                    student.setId(idStudent);
                    student.setStudentName(name);
                    student.setSemester(semester);
                    student.setCourseName(course);
                    System.err.println("Update success.");
                }
            } else {
                studentManagement.remove(student);
                System.err.println("Delete success.");
            }
        }
    }

    /**
     * Get exactly student user want to update/delete in list found
     * Called by updateOeDelete func
     * @param listStudentFindByName list of all Students
     * @return a Student Object
     */
    private static Student getStudentByList(List<Student> listStudentFindByName) {
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

    /**
     * Print all students in the list
     * @param studentManagement Student management object
     */
    public static void report(StudentManagement studentManagement) {
        if (studentManagement.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Report> lr = new ArrayList<>();
        var list = studentManagement.getStudentList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int total = 0;
            for (Student student : list) {
                String id = student.getId();
                String courseName = student.getCourseName();
                String studentName = student.getStudentName();
                for (Student studentCountTotal : list) {
                    if (id.equalsIgnoreCase(studentCountTotal.getId())
                            && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())) {
                        total++;
                    }
                }
                if (Validation.checkReportExist(lr, studentName,
                        courseName, total)) {
                    lr.add(new Report(student.getStudentName(),courseName, total));
                }
            }
        }
        //print report
        for (Report report : lr) {
            System.out.printf("%-15s|%-10s|%-5d\n", report.getStudentName(),
                    report.getCourseName(), report.getTotalCourse());
        }
    }
}