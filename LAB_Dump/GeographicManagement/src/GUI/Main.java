package GUI;

import Business.EAsiaCountriesManagement;
import Entity.EastAsiaCountries;

import java.util.List;


public class Main
{

    public static void main(String[] args)
    {
        EAsiaCountriesManagement management = new EAsiaCountriesManagement();
        //loop until user want to exist
        while (true)
        {
            int choice = Hub.menu();
            switch (choice)
            {
                case 1:
                    EastAsiaCountries eastAsiaCountries = Hub.createCountry();
                    while (!management.checkCountryExist(eastAsiaCountries.getCountryCode()))
                    {
                        System.err.println("Entity.Country exist.");
                        eastAsiaCountries.setCountryCode(InputChecker.checkInputString());
                    }
                    management.add(eastAsiaCountries);
                    System.err.println("Add successful.");
                    break;
                case 2:
                    List<EastAsiaCountries> lc = management.getData();
                    System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                            "Terrain");
                    lc.forEach(k -> System.out.println(k));
                    break;
                case 3:
                    System.out.print("Enter the name you want to search for: ");
                    String countryName = InputChecker.checkInputString();
                    System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                            "Terrain");
                    EastAsiaCountries c = management.search(countryName);
                    if (c != null)
                        System.out.println(c);
                    else
                        System.err.println("NOT FOUND");
                    break;
                case 4:
                    management.sort();
                    List<EastAsiaCountries> ls = management.getData();
                    System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                            "Terrain");
                    ls.forEach(k -> System.out.println(k));
                    break;
                case 5:
                    return;
            }
        }
    }
}