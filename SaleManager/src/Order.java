import java.util.HashSet;

public class Order {
    /*
     * pcode (string): the code of the product to be ordered.
     * ccode (string): the code of the customer.
     * quantity (integer): the number of  ordered products.
     */
    String pcode, ccode;
    private int quantity;
    private static HashSet<String> orderList = new HashSet<>();

    Order(String productID, String customerID, int quan) {
        pcode = productID;
        ccode = customerID;
        quantity = quan;
        orderList.add(pcode);
        orderList.add(ccode);
    }

    public static HashSet<String> getOrdersCollections() {
        return orderList;
    }

    public String toString() {
        return pcode + "|" + ccode + "|" + quantity;
    }

}
