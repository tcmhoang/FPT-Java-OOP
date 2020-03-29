package UI;

import Business.Management;
import Entity.Task;


import java.util.Date;

import static UI.InputChecker.checkInputString;

public class Main
{
    public static void main(String[] args)
    {
        Management management = new Management();
        int choice;
        while (true)
        {
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = InputChecker.checkIntLimit(1, 4);
            switch (choice)
            {
                case 1:
                    System.out.print("Enter Requirement Name: ");
                    String requirementName = checkInputString();

                    System.out.print("Enter Task Type: ");
                    String taskTypeId = InputChecker.checkInputTaskTypeId();

                    System.out.print("Enter Date: ");
                    Date date = InputChecker.checkInputDate();

                    System.out.print("Enter From: ");
                    String planFrom = InputChecker.checkInputPlan();

                    System.out.print("Enter To: ");
                    String planTo = InputChecker.checkInputPlan();

                    System.out.print("Enter Assignee: ");
                    String assign = checkInputString();

                    System.out.print("Enter Reviewer: ");
                    String reviewer = checkInputString();

                    management.addTask(new Task(management.getID(), taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer));

                    System.out.println("Add Task Success.");
                    break;
                case 2:
                    if (management.getTasks().isEmpty())
                    {
                        System.err.println("List empty");
                        break;
                    }
                    System.out.print("Enter id: ");
                    int id = InputChecker.checkInputInt();
                    Task temp = management.findTaskExist(id);
                    if (temp == null)
                    {
                        System.err.println("Not found.");
                        break;
                    }
                    if (management.deleteTask(temp))
                    {
                        System.out.println("Delete success.");
                    }
                    break;
                case 3:

                    if (management.getTasks().isEmpty())
                    {
                        System.err.println("List empty.");
                        break;
                    }
                    System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                            "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
                    management.getTasks().forEach(k -> System.out.println(k));
                    break;
                case 4:
                    return;

            }
        }
    }
}
