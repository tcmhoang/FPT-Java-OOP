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
        assert saledPros <= numOfPros : "Number of saled products cannot be greater than the quantity";
        assert pCodeSet.contains(productID.toUpperCase()) : "Product ID is already existed !!!";
        pcode = productID;
        pro_name = name;
        quantity = numOfPros;
        saled = saledPros;
        price = pricePros;
        pCodeSet.add(productID.toUpperCase());
    }

    Product(String[] dataDump) {
        assert dataDump.length == 5 : "WRONG DATA FOR PRODUCT CLASS";
        assert Integer.parseInt(dataDump[3]) <= Integer.parseInt(dataDump[2]) : "Number of saled products cannot be greater than the quantity";
        assert pCodeSet.contains(dataDump[0].toUpperCase()) : "Product ID is already existed !!!";
        pcode = dataDump[0];
        pro_name = dataDump[1];
        quantity = Integer.parseInt(dataDump[2]);
        saled = Integer.parseInt(dataDump[3]);
        price = Double.parseDouble(dataDump[4]);
        pCodeSet.add(dataDump[1].toUpperCase());
    }

    public String toString() {
        return pcode + "|" + pro_name + "|" + quantity + "|" + saled + "|" + price + "|" + price;
    }
    public static HashSet<String> getIDsCollection(){
        return pCodeSet;
    }
    public String getID(){
        return pcode;
    }
}


