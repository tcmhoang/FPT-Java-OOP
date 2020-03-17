package UI;

import Business.Validation;
import Entity.Fruit;
import Entity.Order;

import java.util.List;

public class Hub
{
    //display menu
    static int menu()
    {
        //loop until user want to exit
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = InputChecker.checkInputIntLimit(1, 4);
        return choice;
    }


    //display list order
    static void showOrderInfo(List<Order> lo)
    {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : lo)
        {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    //display list fruit in shop
    static void displayFruits(List<Fruit> lf)
    {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fruit : lf)
        {
            //check shop have item or not
            if (fruit.getQuantity() != 0)
            {
                System.out.printf("%-10d%-20s%-20s%15.0f$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }

    //if order exist then update order
    static void updateOrder(List<Order> lo, String id, int quantity)
    {
        for (Order order : lo)
        {
            if (order.getFruitId().equalsIgnoreCase(id))
            {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }
}
