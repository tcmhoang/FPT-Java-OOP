package Business;

import Entity.EastAsiaCountries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EAsiaCountriesManagement
{

    List<EastAsiaCountries> lc;

    public EAsiaCountriesManagement()
    {
        lc = new ArrayList<>();
    }

    public List<EastAsiaCountries> getData()
    {
        return lc;
    }

    public void add(EastAsiaCountries eastAsiaCountries)
    {
        lc.add(eastAsiaCountries);
    }

    public void sort()
    {
        Collections.sort(lc);
    }

    public EastAsiaCountries search(String countryName)
    {
        return lc.stream().filter(k -> k.getCountryName().equalsIgnoreCase(countryName)).findFirst().orElse(null);
    }

    public boolean checkCountryExist(String countryCode)
    {
        for (EastAsiaCountries eastAsiaCountries : lc)
        {
            if (eastAsiaCountries.getCountryCode().equalsIgnoreCase(countryCode))
            {
                return false;
            }
        }
        return true;
    }

}