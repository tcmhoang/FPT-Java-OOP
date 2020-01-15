import javax.print.attribute.standard.MediaSize;
import java.util.HashSet;

public class Customer {
    /*
     * ccode (string): the code of the customer (this should be unique for the customer).
     * cus_name (string): the name of the customer.
     * phone (string): The phone number of the customer (must contain digits only).
     */
    private String ccode, cus_name, phone;
    private static HashSet<String> customerIDs = new HashSet<>();

    Customer(String ID, String name, String phoneNumber) {
        assert customerIDs.contains(ID.toUpperCase()) : "ID is already existed!!!";
        assert phoneNumber.matches("//d{10,}") : "Phone must has 10 numbers long";
        ccode = ID;
        cus_name = name;
        phone = phoneNumber;
        customerIDs.add(ID.toUpperCase());
    }

    Customer(String[] data) {
        assert data.length == 3 : "WRONG DATA FOR CUSTOMER CLASS";
        assert customerIDs.contains(data[0].toUpperCase()) : "ID is already existed!!!";
        assert data[2].matches("//d{10,}") : "Phone must has 10 numbers long";
        ccode = data[0];
        cus_name = data[1];
        phone = data[2];
        customerIDs.add(data[0].toUpperCase());
    }

    public String toString() {
        return ccode + "|" + cus_name + "|" + phone;
    }

    public static HashSet<String> getIDsCollection() {
        return customerIDs;
    }

    public String getID() {
        return ccode;
    }
}
