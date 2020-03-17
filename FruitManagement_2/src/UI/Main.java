package UI;

import Business.Management;
import Business.Validation;
import Entity.Fruit;
import Entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main
{

    public static void main(String[] args)
    {
        Management management = new Management();
        while (true)
        {
            int choice = Hub.menu();
            switch (choice)
            {
                case 1:
                    // Create Fruit
                    // loop until user don't want to create fruit
                    while (true)
                    {
                        String fruitId = null;
                        System.out.print("Enter fruit id: ");
                        fruitId = InputChecker.checkInputString();
                        // Check if ID is existed or null
                        if (!management.checkFruitIdExist(fruitId))
                        {
                            System.err.println("ID EXISTED");
                            break;
                        }
                        System.out.print("Enter fruit name: ");
                        String fruitName = InputChecker.checkInputString();
                        System.out.print("Enter price: ");
                        double price = InputChecker.checkInputDouble();
                        System.out.print("Enter quantity: ");
                        int quantity = InputChecker.checkInputInt();
                        System.out.print("Enter origin: ");
                        String origin = InputChecker.checkInputString();
                        management.addFruit(new Fruit(fruitId,fruitName, price, quantity, origin));
                        if (!InputChecker.isYNInput())
                        {
                            break;
                        }
                    }
                    break;
                case 2:
                    Map<String, List<Order>> orderData = management.getOrderList();
                    for (String name : orderData.keySet())
                    {
                        System.out.println("Customer: " + name);
                        List<Order> lo = orderData.get(name);
                        Hub.showOrderInfo(lo);
                    }
                    break;
                case 3:
                    if (management.getFruitList().isEmpty())
                    {
                        System.err.println("No have item.");
                        return;
                    }
                    //loop until user don't want to buy continue
                    List<Order> lo = new ArrayList<>();
                    while (true)
                    {
                        List<Fruit> fruitData = management.getFruitList();
                        Hub.displayFruits(fruitData);
                        System.out.print("Enter item: ");
                        int item = InputChecker.checkInputIntLimit(1, fruitData.size());
                        Fruit fruit = management.getFruitByCarNum(item);
                        System.out.print("Enter quantity: ");
                        int quantity = InputChecker.checkInputIntLimit(1, fruit.getQuantity());
                        fruit.setQuantity(fruit.getQuantity() - quantity);
                        //check item exist or not
                        if (Validation.isItemExisted(lo, fruit.getFruitId()))
                            Hub.updateOrder(lo, fruit.getFruitId(), quantity);
                        else
                            lo.add(new Order(fruit.getFruitId(), fruit.getFruitName(),
                                    quantity, fruit.getPrice()));
                        if (!InputChecker.isYNInput())
                            break;
                    }
                    Hub.showOrderInfo(lo);
                    System.out.print("Enter name: ");
                    String name = InputChecker.checkInputString();
                    management.addRec(name, lo);
                    System.err.println("Add successful");
                    break;
                case 4:
                    return;
            }
        }
    }
}
