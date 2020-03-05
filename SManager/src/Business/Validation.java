package Business;

import Entity.Report;
import Entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    //check student exist

    /**
     * Check student if they already in the Student List
     * @param studentManagement list of students
     * @param s a student obj to check
     * @return true if that student existed otherwise return false
     */
    public static boolean checkStudentExist(StudentManagement studentManagement,Student s) {
        for (Student student : studentManagement.getStudentList()) {
            if (s.getId().equalsIgnoreCase(student.getId())
                    && s.getStudentName().equalsIgnoreCase(student.getStudentName())
                    && s.getSemester().equalsIgnoreCase(student.getSemester())
                    && s.getCourseName().equalsIgnoreCase(student.getCourseName())) {
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
    public static boolean isReportExisted(List<Report> listReport, String name,
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
     * @param other other student to compare with
     * @return true if them already change student's infos
     */
    public static boolean checkChangeInformation(Student student, Student other) {
        return !other.getId().equalsIgnoreCase(student.getId())
                || !other.getStudentName().equalsIgnoreCase(student.getStudentName())
                || !other.getSemester().equalsIgnoreCase(student.getSemester())
                || !other.getCourseName().equalsIgnoreCase(student.getCourseName());
    }

}
