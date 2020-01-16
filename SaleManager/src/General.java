import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class General {
    public static int showMenu(int idicator) {
        Scanner input = new Scanner(System.in);
        String[][] Menu = {{"Load data from file"
                , "Input & add to the end"
                , "Display data"
                , "Save product list to file"
                , "Search by pcode"
                , "Delete by pcode"
                , "Sort by pcode"
                , "Add after position  k"
                , " Delete the node after the node having code = xCode"},
                {
                        "Load data from file"
                        , "Input & add to the end"
                        , "Display data"
                        , "Save customer list to file"
                        , "Search by ccode"
                        , "Delete by ccode"
                },
                {
                        "Input data",
                        "Display data with total value",
                        "Sort  by pcode + ccode"
                }
        };
        int idx = idicator - 1, size = Menu[idx].length;
        for (int i = 0; i < size; i++) {
            System.out.println(idicator + "." + (i + 1) + " " + Menu[idx][i]);
        }
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        while (choice <= idx || choice > size) {
            System.out.println("Invalid input, stroke again: ");
            choice = input.nextInt();
        }
        return choice;
    }

    public static String[] refineData(String[] data) {
        String[] refinedData = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            refinedData[i] = data[i].trim();
        }
        return refinedData;
    }

    public static void readData(String[] data, List list) {
        switch (data.length) {
            case 5:
                list.append(new Product(data));
                break;
            case 3:
                list.append(new Customer(data));
                break;
            default:
                System.err.println("Do not implement data type!!!");
        }
    }

    public static void loadData(String filePath, List list) {
        FileHandler file = new FileHandler(filePath);
        for (String datum : file.lines()) {
            String[] extractedDatum = refineData(datum.split("\\|"));
            readData(refineData(extractedDatum), list);
        }
        System.out.println("READ SUCCESSFUL 😁");
    }

    public static ListNode search(String ID, String field, List list) {
        assert (field.equals("ccode") || field.equals("pcode")) : "ID code field is not support yet";
        ListNode searchRes;
        HashSet<String> collection = field.equals("ccode") ? Customer.getIDsCollection() : Product.getIDsCollection();
        if (!collection.contains(ID)) {
            return null;
        } else {
            searchRes = field.equals("ccode") ? list.getCustomer(ID) : list.getProduct(ID);
        }
        return searchRes;
    }

    public static void remove(String ID, String field, HashSet<String> Collection, List list) {
        if (!Collection.contains(ID)) {
            System.out.println("NOT EXITSTED");
        } else {
            ListNode FoundNode = field.equals("ccode") ? list.getCustomer(ID) : list.getProduct(ID);
            list.remove(FoundNode);
        }
    }
    public static void sortProduct(List list){
        list.sort();
    }
    public static Product addProduct(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the product you want to add!");
        String code, name;
        int quantity, saled;
        double price;
        System.out.print("Product ID: ");
        code = input.next();
        System.out.print("Product Name: ");
        name = input.next();
        System.out.print("Quantity: ");
        quantity = input.nextInt();
        System.out.print("Number of the saled: ");
        saled = input.nextInt();
        System.out.println("How much ?");
        price = input.nextDouble();
        return new Product(code, name, quantity,saled,price);
    }
    public static boolean isNull(List x){
        return x == null;
    }
}
