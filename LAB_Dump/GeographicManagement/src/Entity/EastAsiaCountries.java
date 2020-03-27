package Entity;

import java.text.MessageFormat;

public class EastAsiaCountries extends Country implements Comparable<EastAsiaCountries>
{
    //Swap name

    private String countryTerrain;

    public EastAsiaCountries()
    {
    }

    public EastAsiaCountries(String countryTerrain, String countryCode,
                             String countryName, double countryArea)
    {
        super(countryCode, countryName, countryArea);
        this.countryTerrain = countryTerrain;
    }

    @Override
    public String toString()
    {
        return MessageFormat.format("%-10s%-25s%-20.0f%-25s\n", this.countryCode,
                this.countryName, this.countryArea, this.countryTerrain);
    }

    public String getCountryTerrain()
    {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain)
    {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public int compareTo(EastAsiaCountries t)
    {
        return this.getCountryName().compareTo(t.getCountryName());
    }

}