package Business;

import Entity.Fruit;
import Entity.Order;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


public class Management
{
    List<Fruit> fruitList;
    Map<String, List<Order>> orderList;


    public Management()
    {
        fruitList = new ArrayList<>();
        orderList = new Hashtable<>();
    }

    public void addFruit(Fruit fruit)
    {
        fruitList.add(fruit);
    }

    public void addRec(String name, List<Order> orders)
    {
        orderList.put(name,orders);
    }

    //check id exist
    public boolean checkFruitIdExist(String id)
    {
        for (Fruit fruit : fruitList)
        {
            if (id.equalsIgnoreCase(fruit.getFruitId()))
            {
                return false;
            }
        }
        return true;
    }

    public List<Fruit> getFruitList()
    {
        return fruitList;
    }

    public Map<String, List<Order>> getOrderList()
    {
        return orderList;
    }


    //get fruint user want to by
    public Fruit getFruitByCarNum(int item)
    {
        int countItem = 1;
        for (Fruit fruit : fruitList)
        {
            //check shop have item or not
            if (fruit.getQuantity() != 0)
                countItem++;
            if (countItem - 1 == item)
                return fruit;
        }
        return null;
    }
}