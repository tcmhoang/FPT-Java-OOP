package Entity;

public class CarData
{
    private String[] color;
    private int[] Price;
    private String[] availableDay;

    public CarData()
    {
    }

    public CarData(String[] color, int[] Price, String[] availableDay)
    {
        this.color = color;
        this.Price = Price;
        this.availableDay = availableDay;
    }


    public String[] getColor()
    {
        return color;
    }


    public int[] getPrice()
    {
        return Price;
    }


    public String[] getAvailableDay()
    {
        return availableDay;
    }


}