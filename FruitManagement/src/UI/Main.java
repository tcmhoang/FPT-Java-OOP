package UI;

import Business.Management;
import Business.Validation;
import Entity.Fruit;
import Entity.Order;

import java.util.ArrayList;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        Management management = new Management();
        while (true) {
            int choice = Hub.menu();
            switch (choice) {
                case 1:
                    //Create Fruit
                    //loop until user don't want to create fruit
                    while (true) {
                        String fruitId = null;
                        while (true){
                            System.out.print("Enter fruit id: ");
                            fruitId = Validation.checkInputString();
                            //Check if ID is existed or null
                            if (management.getFruitData().containsKey(fruitId) || fruitId == null)
                                System.err.println("ID EXISTED");
                            else break;
                        }
                        Fruit buff;
                        while (true)
                        {
                            buff = Hub.createFruit();
                            if(management.getFruitData().values().contains(buff))
                                System.err.println("FRUIT EXISTED");
                            else break;
                        }
                        management.insertFruit(fruitId,buff);
                        if(!Validation.isYNInput()) break;
                    }
                    break;
                case 2:
                    //allow user show view order
                    Map orderData = management.getOrderData();
                    orderData.forEach((k,v) -> {
                        System.out.println("Customer: " + k);
                        Hub.showOrderInfo((ArrayList<Order>) v);
                    });
                break;
                case 3:
                    //check list empty user can't buy
                    if (management.getFruitData().isEmpty()) {
                        System.err.println("No item existed.");
                        break;
                    }
                    //loop until user don't want to buy continue
                    ArrayList<Order> lo = new ArrayList<>();
                    while (true) {
                        Map<String,Fruit> fruitData = management.getFruitData();
                        Hub.displayFruitData(fruitData);
                        System.out.print("Enter item: ");
                        int cardinal = Validation.getInputIntLimit(1, fruitData.size());
                        Fruit fruit = management.getFruitByCarNum(cardinal);
                        System.out.print("Enter quantity: ");
                        int quantity = Validation.getInputIntLimit(1, fruit.getQuantity());
                        fruit.setQuantity(fruit.getQuantity() - quantity);
                        //check item exist or not
                        String id = management.getFruitID(fruit);
                        if (lo.contains(fruit)) {
                            for (Order order : lo) {
                                if (order.getFruitId().equalsIgnoreCase(id)) {
                                    order.setQuantity(order.getQuantity() + quantity);
                                    return;
                                }
                            }
                        } else {
                            lo.add(new Order(id, fruit.getFruitName(),
                                    quantity, fruit.getPrice()));
                        }
                        if (!Validation.isYNInput()) break;
                    }
                    Hub.showOrderInfo(lo);
                    System.out.print("Enter name: ");
                    String name = Validation.checkInputString();
                    management.insertOrder(name, lo);
                    System.err.println("Add successfull");
                    break;
                case 4:
                    return;
            }
        }
    }

}