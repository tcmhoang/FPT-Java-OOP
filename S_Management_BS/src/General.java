import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class General {
    public static int showMenu(int idicator) {
        Scanner input = new Scanner(System.in);
        String[][] Menu = {{"Load data from file"
                , "Input & insert data"
                , "In-order traverse"
                , "Breadth-first traverse"
                , "In-order traverse to file"
                , "Search by pcode"
                , "Delete by pcode by copying"
                , "Simply balancing"
                , "Count number of products"},
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
                        "Simple Balance  by pcode + ccode"
                }
        };
        if (idicator <= 0 || idicator > 3) {
            return 100;
        }
        int idx = idicator - 1, size = Menu[idx].length;
        for (int i = 0; i < size; i++) {
            System.out.println(idicator + "." + (i + 1) + " " + Menu[idx][i]);
        }
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        while (choice <= 0 || choice > size) {
            System.out.println("Invalid input, stroke again: ");
            choice = input.nextInt();
        }
        return choice;
    }


    public static Product createProduct() {
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
        return new Product(code, name, quantity, saled, price);
    }

    public static Customer createCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the customer you want to add!");
        String code, name,phone;
        System.out.print("Customer ID: ");
        code = input.next();
        System.out.print("Customer Name: ");
        name = input.next();
        System.out.println("Phone ?");
        phone = input.next();
        return new Customer(code, name, phone);
    }

    public static Order createOrder(BSTree products, BSTree consumers) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Order you want to add!");
        String pcode, ccode;
        int quantity;
        System.out.print("Enter product code: ");
        pcode = input.next();
        System.out.print("Enter customer code: ");
        ccode = input.next();
        System.out.print("Enter quantity: ");
        quantity = input.nextInt();
        Node pRoot = products.root, cRoot = consumers.root;
//        If pcode not found in the products list or ccode not found in the customers list  then data is not accepted.
        if (!Product.getIDsCollection().contains(pcode) || !Customer.getIDsCollection().contains(ccode)) {
            System.err.println("INVALID DATA");
            return null;
        }
//        If  both pcode and ccode are found in the order list  then  data is not accepted.
        else if (Order.getOrdersCollections().contains(pcode) && Order.getOrdersCollections().contains(ccode)) {
            System.err.println("EXISTED PCODE, PCODE");
            return null;
        } else if (((Product) Objects.requireNonNull(products.search(pRoot,pcode)).info).isExhausted() ||
                ((Product) Objects.requireNonNull(consumers.search(cRoot,ccode)).info).getStock() < quantity)  {
            System.err.println("NOT ENOUGH GOODS");
            return null;
        } else {
            return new Order(pcode, ccode, quantity);
        }
    }

}
