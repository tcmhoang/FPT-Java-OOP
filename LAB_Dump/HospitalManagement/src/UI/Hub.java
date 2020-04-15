package UI;

import Entity.Doctor;

import java.util.ArrayList;

public class Hub
{
    //display menu
    public static int menu()
    {
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        return InputChecker.checkInputIntLimit(1, 5);
    }

    //allow user add doctor
    public static Doctor createDocData()
    {
        System.out.print("Enter code: ");
        String code = InputChecker.checkInputString();
        System.out.print("Enter name: ");
        String name = InputChecker.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = InputChecker.checkInputString();
        System.out.print("Enter availability: ");
        int availability = InputChecker.checkInputInt();
        return new Doctor(code, name, specialization, availability);
    }

    public static void updateDocInfo(Doctor doctor, String codeUpdate, String name, String specialization, int availability) {
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Update successful");
    }


}
