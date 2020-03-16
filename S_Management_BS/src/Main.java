import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        Scanner input = new Scanner(System.in);
        BSTree products = null, customer = null, orders = null;
        Node res = null;
        String path = null;
        boolean done = false;
        while (!done) {
            System.out.println("Show Menu: \n" +
                    "1.Product List\n" +
                    "2.Customer List\n" +
                    "3.Order List\n" +
                    "Any Other Key. Quit");
            int menu = input.nextInt(), choice = General.showMenu(menu);
            switch (menu) {
                case 1:
                    switch (choice) {
                        case 1:
                            if (products == null) {
                                products = new BSTree();
                            }
                            System.out.println("Enter the path to file you wanna import!");
                            path = input.next();
                            products.loadProduct(path);
                            break;
                        case 2:
                            if (products.isEmpty()) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            products.insert(General.createProduct());
                            break;
                        case 4:
                            if (products.isEmpty()) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            System.out.println("code |   Pro_name  |  Quantity  |  saled |  Price   |   Value \n" +
                                    "-------------------------------------------------------------------");
                            products.breadth(products.root);
                            break;
                        case 5:
                            if (products.isEmpty()) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            System.out.println("Enter the path you want to save! ");
                            path = input.next();
                            products.saveFileInOrder(path,products.root);
                            System.out.println("Write Successful PATH: " + path);
                            break;
                        case 6:
                            System.out.println("Enter pcode you wanna search: ");
                            res = products.search(products.root,input.next().trim());
                            if (res == null) {
                                System.out.println("NOT EXISTED");
                            } else {
                                System.out.println(res.info.toString());
                            }
                            break;
                        case 7:
                            if (products.isEmpty()) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            System.out.println("Enter pcode you wanna remove: ");
                            products.deleByCopy(input.next().trim());
                            products.breadth(products.root);
                            break;
                        case 3:
                            if (products.isEmpty()) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            System.out.println("code |   Pro_name  |  Quantity  |  saled |  Price   |   Value \n" +
                                    "-------------------------------------------------------------------");
                            products.inOrder(products.root);
                            break;
                        case 8:
                            if (products.isEmpty()) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            products.balPro();
                            products.breadth(products.root);
                            break;
                        case 9:
                            if (products.isEmpty()) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            int count = products.count();
                            System.out.println("The number of products is: " + count);
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    switch (choice) {
                        case 1:
                            if (customer == null) {
                                customer = new BSTree();
                            }
                            System.out.println("Enter the path to file you wanna import!");
                            path = input.next();
                            customer.loadCustomer(path);
                            break;
                        case 2:
                            if (customer.isEmpty()) {
                                System.err.println("Customer List has not been initialized");
                                break;
                            }
                            customer.insert(General.createCustomer());
                            break;
                        case 3:
                            if (customer.isEmpty()) {
                                System.err.println("Customer List has not been initialized");
                                break;
                            }
                            System.out.println("code |   Cus_name  |  Phone \n" +
                                    "---------------------------------------");
                            customer.breadth(customer.root);
                            break;
                        case 4:
                            if (customer.isEmpty()) {
                                System.err.println("Customer List has not been initialized");
                                break;
                            }
                            System.out.println("Enter the path you want to save! ");
                            customer.saveFileBreadth(input.next(),customer.root);
                            System.out.println("Write Successful PATH: " + path);
                            break;
                        case 5:
                            System.out.println("Enter ccode you wanna search: ");
                            res = customer.search(customer.root,input.next().trim());
                            if (res == null) {
                                System.out.println("NOT EXISTED");
                            } else {
                                System.out.println(res.info.toString());
                            }
                            break;
                        case 6:
                            if (customer.isEmpty()) {
                                System.err.println("Customer List has not been initialized");
                                break;
                            }
                            System.out.println("Enter ccode you wanna remove: ");
                            customer.deleByCopy(input.next().trim());
                            customer.breadth(customer.root);
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    switch (choice) {
                        case 1:
                            if (orders == null) {
                                orders = new BSTree();
                            }
                            if (products.isEmpty() || customer.isEmpty()) {
                                System.err.println("Do not initialized Products List or Customers List");
                                break;
                            }
                            Order temp =  General.createOrder(products, customer);
                            if(temp == null){
                                break;
                            }
                            orders.insert(temp);
                            break;
                        case 2:
                            if (orders.isEmpty()) {
                                System.err.println("Do not initialized Products List or Customers List");
                                break;
                            }
                            System.out.println("Pcode |   C_name  |  Quality \n" +
                                    "---------------------------------------");
                            orders.inOrder(orders.root);
                            break;
                        case 3:
                            if (orders.isEmpty()) {
                                System.err.println("Do not initialized Products List or Customers List");
                                break;
                            }
                            orders.balOrder();
                            orders.breadth(orders.root);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    done = true;
                    break;
            }
        }
    }
}
