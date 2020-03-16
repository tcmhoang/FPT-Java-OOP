import java.util.HashSet;

public class Product {
    /*
     * pcode (string): the code of the product (this should be unique for the product).
     * pro_name (string): the name of the product.
     * quantity (integer): the number of  products with the same code in a shop at beginning of a day.
     * saled (integer): the number of  products with the same code, which are saled in the day. Condition: saled ≤ quantity.
     * price (double): The price of the product.
     */
    private static HashSet<String> pCodeSet = new HashSet<>();
    private String pcode, pro_name;
    private int quantity, saled;
    private double price;

    Product(String productID, String name, int numOfPros, int saledPros, double pricePros) {
        if (saledPros > numOfPros) {
            System.err.println("Number of saled products cannot be greater than the quantity");
            return;
        }
        if (pCodeSet.contains(productID.toUpperCase())) {
            System.err.println("Product ID is already existed !!!");
            return;
        }
        pcode = productID;
        pro_name = name;
        quantity = numOfPros;
        saled = saledPros;
        price = pricePros;
        pCodeSet.add(productID.toUpperCase());
    }

    Product(String[] dataDump) {
        if (!(dataDump.length == 5)) {
            System.err.println("WRONG DATA FOR PRODUCT CLASS");
            return;
        }
        if (!(Integer.parseInt(dataDump[3]) <= Integer.parseInt(dataDump[2]))) {
            System.err.println("Number of saled products cannot be greater than the quantity");
            return;
        }
        if (pCodeSet.contains(dataDump[0].toUpperCase())) {
            System.err.println("Product ID is already existed !!!");
        }
        pcode = dataDump[0];
        pro_name = dataDump[1];
        quantity = Integer.parseInt(dataDump[2]);
        saled = Integer.parseInt(dataDump[3]);
        price = Double.parseDouble(dataDump[4]);
        pCodeSet.add(dataDump[0].toUpperCase());
    }

    public String toString() {
        return pcode + "|" + pro_name + "|" + quantity + "|" + saled + "|" + price;
    }

    public static HashSet<String> getIDsCollection() {
        return pCodeSet;
    }

    public String getID() {
        return pcode;
    }
    public boolean isExhausted(){
        return quantity <= saled;
    }
    public int getStock(){
        return quantity - saled;
    }
}


