package Business;

import Entity.Order;

import java.util.List;
import java.util.Scanner;


public class Validation
{

    //check item exist or not
    public static boolean isItemExisted(List<Order> lo, String id)
    {
        //check list empty user can't buy
        for (Order order : lo)
        {
            if (order.getFruitId().equalsIgnoreCase(id))
            {
                return true;
            }
        }
        return false;
    }
}