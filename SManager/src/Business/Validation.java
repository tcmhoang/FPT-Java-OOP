package Business;

import Entity.Report;
import Entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    //check student exist

    /**
     * Check student if they already in the Student List
     * @param listStudent list of all students
     * @param id id of students
     * @param studentName Name of Students
     * @param semester terms currently in
     * @param courseName course already taken
     * @return true if that student existed otherwise return false
     */
    public static boolean checkStudentExist(StudentManagement studentManagement, String id,
                                            String studentName, String semester, String courseName) {
        for (Student student : studentManagement.getStudentList()) {
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if report is existed in list Report
     * @param listReport list of reports
     * @param name Name of report
     * @param course course in report
     * @param total total course in report
     * @return true if report is existed otherwise return false
     */
    public static boolean checkReportExist(ArrayList<Report> listReport, String name,
                                           String course, int total) {
        for (Report report : listReport) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }


    /**
     * Check valid id if it existed
     * @param listStudent  list of all students
     * @param id  ID need to verify
     * @param name  Name of Students
     * @return true if ID is existed otherwise return false
     */
    public static boolean checkIdExist(StudentManagement listStudent, String id, String name) {
        for (Student student : listStudent.getStudentList()) {
            if (id.equalsIgnoreCase(student.getId())
                    && !name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks usr if them make changes or not
     * @param student Student is in considered
     * @param ID user's changed ID
     * @param name user's changed Name
     * @param semester user's changed Semester
     * @param course user's changed course
     * @return true if them already change student's infos
     */
    public static boolean checkChangeInformation(Student student, String ID,
                                                 String name, String semester, String course) {
        return !ID.equalsIgnoreCase(student.getId())
                || !name.equalsIgnoreCase(student.getStudentName())
                || !semester.equalsIgnoreCase(student.getSemester())
                || !course.equalsIgnoreCase(student.getCourseName());
    }

}
