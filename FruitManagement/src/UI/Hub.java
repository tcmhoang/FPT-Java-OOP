package UI;

import Business.Validation;
import Entity.Fruit;
import Entity.Order;

import java.util.ArrayList;
import java.util.Map;

public class Hub {
    //display menu
    public static int menu() {
        //loop until user want to exit
        System.out.println("1. Create Entity.Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validation.getInputIntLimit(1, 4);
        return choice;
    }

    //allow user create fruit
    public static Fruit createFruit() {
        System.out.print("Enter fruit name: ");
        String fruitName = Validation.checkInputString();
        System.out.print("Enter price: ");
        double price = Validation.checkInputDouble();
        System.out.print("Enter quantity: ");
        int quantity = Validation.checkInputInt();
        System.out.print("Enter origin: ");
        String origin = Validation.checkInputString();
        return new Fruit(fruitName, price, quantity, origin);
    }

    //display list order
    public static void showOrderInfo(ArrayList<Order> lo) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : lo) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    //display list fruit in shop
    static void displayFruitData(Map<String, Fruit> fruitData) {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Entity.Fruit name", "Origin", "Price");
        for (Map.Entry<String,Fruit> data : fruitData.entrySet()) {
            //check shop have item or not
            Fruit fruit = data.getValue();
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%-15.0f$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }
}
