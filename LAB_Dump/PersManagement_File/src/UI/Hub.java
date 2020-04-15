package UI;

import Entity.Person;

import java.util.ArrayList;
import java.util.Collections;

public class Hub
{
    //display menu
    public static int menu() {
        System.out.println("1. Find person info.");
        System.out.println("2. Copy Text to new file.");
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
        return InputChecker.checkInputIntLimit(1, 3);
    }




}
