package Business;

import Entity.Report;
import Entity.Student;

import java.util.*;

public class StudentManagement {
    private List<Student> ls = new ArrayList<>();
    private int count = 1;

    /**
     * Add student in list
     *
     * @param student list of students
     */
    public void add(Student student) {
        ls.add(student);
        count++;
    }

    public List<Student> getStudentList() {
        return ls;
    }

    public void remove(Student student) {
        if (count == 0) {
            return;
        }
        ls.remove(student);
        count--;
    }

    public int getCount() {
        return count;
    }
    //Get list student find by id

    /**
     * Travel through list and get a list of student has same ID
     *
     * @param id ID needed to search
     * @return a list of students has same ID
     */
    public List<Student> getListStudentById(String id) {
        List<Student> listsStudent = new ArrayList<>();
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())) {
                listsStudent.add(student);
            }
        }
        return listsStudent;
    }

    public boolean isGreaterThan10() {
        return count > 10;
    }

    public boolean isEmpty() {
        return ls.isEmpty();
    }

    /**
     * Allow student search through list of students and return 'em in List Format
     *
     * @param name student's name need to find
     * @return a list of student has exact name when user typed in
     */
    //List student found by name
    public List<Student> getListStudentByName(String name) {
        List<Student> listStudentFindByName = new ArrayList<>();
        for (Student student : ls) {
            //check student have name contains input
            if (student.getStudentName().contains(name)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }

    public void updateStuInfo(Student student, Student edS) {
        student = edS;
    }

    /**
     * Print all students in the list
     */
    public List<Report> getReport() {
        List<Report> lr = new ArrayList<>();
        var total = 0;
        Map<String, Set<String>> coursesPerID = new HashMap<>();
        for (Student student : ls) {
            boolean isAdded = false;
            String id = student.getId();
            String courseName = student.getCourseName();
            String studentName = student.getStudentName();

            if(!coursesPerID.containsKey(id))
            {
                coursesPerID.put(id,new HashSet<>());
                coursesPerID.get(id).add(courseName);
                total ++;
                isAdded = true;
            }
            else {
                Set<String> courses = coursesPerID.get(id);
                if(!courses.contains(courseName))
                {
                    total ++;
                    courses.add(courseName);
                    isAdded = true;
                }
            }

            if (isAdded &&Validation.isReportExisted(lr, studentName,
                    courseName, total)) {
                lr.add(new Report(student.getStudentName(), courseName, total));
            }
        }
        return lr;
    }
}
