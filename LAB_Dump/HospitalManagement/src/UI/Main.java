package UI;

import Business.Management;
import Business.Validator;
import Entity.Doctor;

import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        Management hosManagement = new Management();
        //loop until user want to exit
        while (true)
        {
            int choice = Hub.menu();
            Doctor temp;
            String code;
            switch (choice)
            {
                case 1:
                    temp = Hub.createDocData();

                    //check code exist or not
                    if (hosManagement.isCodeExist(temp.getCode()))
                    {
                        System.err.println("Code exist.");
                        break;
                    }

                    //check worker duplicate
                    if (hosManagement.isDuplicate(temp))
                    {
                        System.err.println("Duplicate.");
                        break;
                    }

                    hosManagement.add(temp);
                    System.out.println("Add successful.");
                    break;

                case 2:
                    //allow user update doctor
                    System.out.print("Enter code: ");
                    code = InputChecker.checkInputString();

                    //check code exist or not
                    if (!hosManagement.isCodeExist(code))
                    {
                        System.err.println("Not found doctor");
                        break;
                    }

                    System.out.println("START UPDATE SECTION");

                    System.out.print("Enter code: ");
                    String codeUpdate = InputChecker.checkInputString();
                    temp = hosManagement.getDocByID(code);

                    System.out.print("Enter name: ");
                    String name = InputChecker.checkInputString();

                    System.out.print("Enter specialization: ");
                    String specialization = InputChecker.checkInputString();

                    System.out.print("Enter availability: ");
                    int availability = InputChecker.checkInputInt();

                    //check user change information or not
                    if (Validator.checkChangeInfo(temp, code, name, specialization, availability))
                    {
                        System.err.println("No change");
                        break;
                    }

                    Hub.updateDocInfo(temp, codeUpdate, name, specialization, availability);

                    break;
                case 3:
                    System.out.print("Enter code: ");
                    code = InputChecker.checkInputString();
                    temp = hosManagement.getDocByID(code);
                    if (hosManagement.delDoc(temp))
                        System.err.println("Delete successful.");
                    else
                        System.err.println("Not found doctor.");
                    break;
                case 4:
                    System.out.print("Enter name: ");
                    String nameSearch = InputChecker.checkInputString();
                    List<Doctor> data = hosManagement.getDocsByName(nameSearch);
                    if (data.isEmpty())
                    {
                        System.err.println("List empty.");
                    }
                    else
                    {
                        System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                                "Specialization", "Availability");
                        for (Doctor doctor : data)
                        {
                            System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                                    doctor.getName(), doctor.getSpecialization(),
                                    doctor.getAvailability());
                        }
                    }
                    break;
                case 5:
                    return;
            }

        }

    }
}