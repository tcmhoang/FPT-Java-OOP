public class Order {
    /*
     * pcode (string): the code of the product to be ordered.
     * ccode (string): the code of the customer.
     * quantity (integer): the number of  ordered products.
     */
    String pcode, ccode;
    private int qualtity;

    Order(String productID, String customerID, int quantity) {
        pcode = productID;
        ccode = customerID;
    }
}
