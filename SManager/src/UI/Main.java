package UI;

import Business.StudentManagement;
import Business.Validation;
import Entity.Report;
import Entity.Student;

import java.util.Collections;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.add(new Student("1", "Pham Ngoc Hoa", "Spring", "java"));
        studentManagement.add(new Student("2", "Do Quang Hiep", "Summer", ".net"));
        studentManagement.add(new Student("3", "Nguyen Xuan Cuong", "Spring", "c/c++"));

        //loop until user want to exit program
        while (true) {
            //Show menu option
            Helper.menu();
            var choice = InputChecker.checkInputIntLimit(1, 5);
            String name, id;
            switch (choice) {
                case 1:
                    //if number of students greater than 10 ask user continue or not
                    if (studentManagement.isGreaterThan10()) {
                        System.out.print("Do you want to continue (Y/N): ");
                        if (!InputChecker.checkInputYN()) {
                            break;
                        }
                    }
                    var students = Helper.createStudent(studentManagement);
                    studentManagement.add(students);
                    break;
                case 2:
                    //check list empty
                    if (studentManagement.isEmpty()) {
                        System.err.println("List empty.");
                        break;
                    }
                    System.out.print("Enter name to search: ");
                    name = InputChecker.checkInputString();
                    List<Student> listStuByName = studentManagement.getListStudentByName(name);
                    if (listStuByName.isEmpty()) {
                        System.err.println("Not exist.");
                    } else {
                        Collections.sort(listStuByName);
                        System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
                        //loop from first to last element of list student
                        for (Student student : listStuByName) {
                            System.out.printf("%-15s%-15s%-15s\n", student.getStudentName(), student.getSemester(), student.getCourseName());
                        }
                    }
                    break;
                case 3:
                    //check list empty
                    if (studentManagement.isEmpty()) {
                        System.err.println("List empty.");
                        break;
                    }
                    System.out.print("Enter ID: ");
                    id = InputChecker.checkInputString();
                    List<Student> listStuByID = studentManagement.getListStudentById(id);
                    if (listStuByID.isEmpty()) {
                        System.err.println("Not found student.");
                    } else {
                        Student student = Helper.getStudentToEdit(listStuByID);
                        System.out.print("Do you want to update (U) or delete (D) student: ");
                        //check user want to update or delete
                        if (InputChecker.isUpdate()) {
                            var edited = Helper.createStudent();
                            //check user change or not
                            if (!Validation.checkChangeInformation(student, edited)) {
                                System.err.println("Nothing change.");
                            }
                            //check student exist or not
                            if (Validation.checkStudentExist(studentManagement, edited)) {
                                studentManagement.updateStuInfo(student, edited);
                                System.err.println("Update success.");
                            }
                        } else {
                            studentManagement.remove(student);
                            System.err.println("Delete success.");
                        }
                    }
                    break;
                case 4:
                    //check list empty
                    if (studentManagement.isEmpty()) {
                        System.err.println("List empty.");
                        break;
                    }
                    List<Report> reports = studentManagement.getReport();
                    for (Report report : reports) {
                        System.out.printf("%-15s|%-10s|%-5d\n", report.getStudentName(),
                                report.getCourseName(), report.getTotalCourse());
                    }
                    break;
                case 5:
                    return;
            }

        }
    }

}