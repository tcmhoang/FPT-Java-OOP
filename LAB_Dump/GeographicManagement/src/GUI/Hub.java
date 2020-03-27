package GUI;

import Entity.EastAsiaCountries;


public class Hub
{
    //display menu
    public static int menu()
    {
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = InputChecker.checkInputIntLimit(1, 5);
        return choice;
    }


    //allow user input infomation of contries
    public static EastAsiaCountries createCountry()
    {
        System.out.print("Enter code of contry: ");
        String countryCode = InputChecker.checkInputString();
        System.out.print("Enter name of contry: ");
        String countryName = InputChecker.checkInputString();
        System.out.print("Enter total area: ");
        double countryArea = InputChecker.checkInputDouble();
        System.out.print("Enter terrain of contry: ");
        String countryTerrain = InputChecker.checkInputString();
        return new EastAsiaCountries(countryTerrain, countryCode, countryName, countryArea);
    }


}
