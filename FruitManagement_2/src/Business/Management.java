package Business;

import Entity.Fruit;
import Entity.Order;

import java.util.ArrayList;
import java.util.List;


public class Management
{
    List<Fruit> fruitList;
    List<Order> orders;


    public Management()
    {
        fruitList = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addFruit(Fruit fruit)
    {
        fruitList.add(fruit);
    }

    public void addOrder(Order order)
    {
        orders.add(order);
    }

    //check id exist
    public boolean checkFruitIdExist(String id)
    {
        return fruitList.stream().anyMatch(fruit ->
                id.equalsIgnoreCase(fruit.getFruitId()));
    }

    public List<Fruit> getFruitList()
    {
        return fruitList;
    }

    public List<Order> getRecord()
    {
        return orders;
    }


    /**
     * get fruit user want to by cardinal number
     * show in dispplay fruit method func
     *
     * @param item
     * @return
     */
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