package UI;

import Business.StudentManagement;
import Entity.Student;


public class Main {

    public static void main(String[] args) {
        var studentManager = new StudentManagement();
        studentManager.add(new Student("1", "Pham Ngoc Hoa", "Spring", "java"));
        studentManager.add(new Student("2", "Do Quang Hiep", "Summer", ".net"));
        studentManager.add(new Student("3", "Nguyen Xuan Cuong", "Spring", "c/c++"));
        //loop until user want to exit program
        while (true) {
            //Show menu option
            Helper.menu();
            int choice = InputChecker.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    Helper.createStudent(studentManager);
                    //stud
                    break;
                case 2:
                    Helper.findAndSort(studentManager);
                    //list
                    break;
                case 3:
                    Helper.updateOrDelete(studentManager);
                    //bool
                    break;
                case 4:
                    Helper.report(studentManager);
                    //list
                    break;
                case 5:
                    return;
            }

        }
    }

}