package Business;

import Entity.Fruit;
import Entity.Order;

import java.util.*;
import java.util.stream.Collectors;


public class Management {

    private Map<String, Fruit> fruitData;
    private Map<String, List<Order>> orderData;

    public Management() {
        fruitData = new HashMap<>();
        orderData = new HashMap<>();
    }

    public void insertFruit(String ID, Fruit fruit) {
        fruitData.put(ID, fruit);
    }

    public void insertOrder(String name, List<Order> order) {
        orderData.put(name, order);
    }

    public Map<String, Fruit> getFruitData() {
        return fruitData;
    }

    public Map<String, List<Order>> getOrderData() {
        return orderData;
    }

    public String getFruitID(Fruit fruit) {
        Set<String> IDSet = fruitData.entrySet()
                .stream()
                .filter(k -> k.getValue().equals(fruit))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        if (IDSet.size() != 1) {
            throw new IllegalStateException();
        }
        for(String res : IDSet) return res;
        //never happen
        return null;
    }


    //get fruint user want to by
    public Fruit getFruitByCarNum(int item) {
        int countItem = 1;
        Fruit[] fruitList = fruitData.values().toArray(Fruit[]::new);
        for (Fruit fruit : fruitList) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

}