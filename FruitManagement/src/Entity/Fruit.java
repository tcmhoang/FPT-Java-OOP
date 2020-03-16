package Entity;

public class Fruit {

    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(String fruitName, double price, int quantity, String origin) {
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean equals(Object o) {
        return o != null && o instanceof Fruit && this.fruitName.equalsIgnoreCase(((Fruit) o).fruitName);
    }
}