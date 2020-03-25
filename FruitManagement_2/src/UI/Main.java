package UI;

import Business.Management;
import Entity.Fruit;
import Entity.OrderItem;
import Entity.Order;

import java.util.List;

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
                    List<Order> orderData = management.getRecord();
                    for (Order rec : orderData)
                    {
                        System.out.println("Customer: " + rec.getName());
                        List<OrderItem> lo = rec.getOrderItems();
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
                    Order order = new Order();
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
                        if (order.isItemExisted(fruit.getFruitId()))
                            order.updateOrder(fruit.getFruitId(), quantity);
                        else
                            order.add(new OrderItem(fruit.getFruitId(), fruit.getFruitName(),
                                    quantity, fruit.getPrice()));
                        if (!InputChecker.isYNInput())
                            break;
                    }
                    Hub.showOrderInfo(order.getOrderItems());
                    System.out.println("Total: " + order.getTotal());
                    System.out.print("Enter name: ");
                    String name = InputChecker.checkInputString();
                    order.setName(name);
                    management.addOrder(order);
                    System.err.println("Add successful");
                    break;
                case 4:
                    return;
            }
        }
    }
}
