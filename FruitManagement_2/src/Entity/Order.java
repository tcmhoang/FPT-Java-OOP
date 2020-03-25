package Entity;

import java.util.ArrayList;
import java.util.List;

public class Order
{
    private String name;
    private List<OrderItem> orderItems;

    public Order()
    {
        orderItems = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<OrderItem> getOrderItems()
    {
        return orderItems;
    }

    public void add(OrderItem item)
    {
        orderItems.add(item);
    }

    //add orderItems
    public  boolean isItemExisted(String id)
    {
        //check list empty user can't buy
        return orderItems.stream().anyMatch(orderItem -> orderItem.getFruitId().equalsIgnoreCase(id));
    }

    public double getTotal()
    {
        return orderItems.stream().mapToDouble(x -> x.getPrice() * x.getQuantity()).sum();
    }
    /**
     * Update newly created order if thw order is already order
     *
     * @param id       Fruit ID
     * @param quantity quantity of fruit
     */
    public void updateOrder(String id, int quantity)
    {
        for (OrderItem orderItem : orderItems)
            if (orderItem.getFruitId().equalsIgnoreCase(id))
            {
                orderItem.setQuantity(orderItem.getQuantity() + quantity);
                return;
            }
    }
}
