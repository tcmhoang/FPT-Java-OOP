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
        if (customerIDs.contains(ID.toUpperCase())) {
            System.err.println("ID is already existed!!!");
            return;
        }
        if (phoneNumber.matches("//d{10,}")) {
            System.err.println("Phone must has 10 numbers long");
            return;
        }
        ccode = ID;
        cus_name = name;
        phone = phoneNumber;
        customerIDs.add(ID.toUpperCase());
    }

    Customer(String[] data) {
        if (data.length != 3) {
            System.err.println("WRONG DATA FOR CUSTOMER CLASS");
            return;
        }
        if (customerIDs.contains(data[0].toUpperCase())) {
            System.err.println("ID is already existed!!!");
            return;
        }
        if (data[2].matches("//d{10,}")) {
            System.err.println("Phone must has 10 numbers long");
            return;
        }
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
