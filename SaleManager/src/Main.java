import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner input = new Scanner(System.in);
        List products = null, customer = null, orders = null;
        ListNode res = null;
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
                                products = new List();
                            }
                            System.out.println("Enter the path to file you wanna import!");
                            path = input.next();
                            General.loadData(path, products);
                            break;
                        case 2:
                            if (General.isNull(products)) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            products.append(General.addProduct());
                            break;
                        case 3:
                            if (General.isNull(products)) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            System.out.println("code |   Pro_name  |  Quantity  |  saled |  Price   |   Value \n" +
                                    "-------------------------------------------------------------------");
                            products.showAll();
                            break;
                        case 4:
                            if (General.isNull(products)) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            System.out.println("Enter the path you want to save! ");
                            path = input.next();
                            FileHandler.write(products.getData(), path);
                            System.out.println("Write Successful PATH: " + path);
                            break;
                        case 5:
                            System.out.println("Enter pcode you wanna search: ");
                            res = General.search(input.next(), "pcode", products);
                            if (res == null) {
                                System.out.println("NOT EXISTED");
                            } else {
                                System.out.println(res.val.toString());
                            }
                            break;
                        case 6:
                            if (General.isNull(products)) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            System.out.println("Enter pcode you wanna remove: ");
                            General.remove(input.next(), "pcode", Product.getIDsCollection(), products);
                            products.showAll();
                            break;
                        case 7:
                            if (General.isNull(products)) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            General.sort(products);
                            System.out.println("Sorted!");
                            products.showAll();
                            break;
                        case 8:
                            if (General.isNull(products)) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            System.out.println("Enter a code you wanna insert after it:");
                            res = General.search(input.next(), "pcode", products);
                            if (res == null) {
                                System.out.println("NOT EXITSTED");
                            } else {
                                products.insert(res, General.addProduct());
                            }
                            break;
                        case 9:
                            if (General.isNull(products)) {
                                System.err.println("Products List has not been initialized");
                                break;
                            }
                            System.out.println("Enter xCode you wanna delete from: ");
                            res = General.search(input.next(), "pcode", products);
                            if (res == null) {
                                System.out.println("NOT EXISTED");
                            } else {
                                products.deleteRest(res);
                            }
                            products.showAll();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    switch (choice) {
                        case 1:
                            if (customer == null) {
                                customer = new List();
                            }
                            System.out.println("Enter the path to file you wanna import!");
                            path = input.next();
                            General.loadData(path, customer);
                            break;
                        case 2:
                            if (General.isNull(customer)) {
                                System.err.println("Customer List has not been initialized");
                                break;
                            }
                            customer.append(General.addCustomer());
                            break;
                        case 3:
                            if (General.isNull(customer)) {
                                System.err.println("Customer List has not been initialized");
                                break;
                            }
                            System.out.println("code |   Cus_name  |  Phone \n" +
                                    "---------------------------------------");
                            customer.showAll();
                            break;
                        case 4:
                            if (General.isNull(customer)) {
                                System.err.println("Customer List has not been initialized");
                                break;
                            }
                            System.out.println("Enter the path you want to save! ");
                            path = input.next();
                            FileHandler.write(customer.getData(), path);
                            System.out.println("Write Successful PATH: " + path);
                            break;
                        case 5:
                            System.out.println("Enter ccode you wanna search: ");
                            res = General.search(input.next(), "ccode", customer);
                            if (res == null) {
                                System.out.println("NOT EXISTED");
                            } else {
                                System.out.println(res.val.toString());
                            }
                            break;
                        case 6:
                            if (General.isNull(customer)) {
                                System.err.println("Customer List has not been initialized");
                                break;
                            }
                            System.out.println("Enter ccode you wanna remove: ");
                            General.remove(input.next(), "ccode", Product.getIDsCollection(), products);
                            customer.showAll();
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    switch (choice) {
                        case 1:
                            if (orders == null) {
                                orders = new List();
                            }
                            if (General.isNull(products) || General.isNull(customer)) {
                                System.err.println("Do not initialized Products List or Customers List");
                                break;
                            }
                            Order temp =  General.addOrder(products, customer);
                            if(General.isNull(temp)){
                                break;
                            }
                            orders.append(temp);
                            break;
                        case 2:
                            if (General.isNull(orders)) {
                                System.err.println("Do not initialized Products List or Customers List");
                                break;
                            }
                            System.out.println("Pcode |   C_name  |  Quality \n" +
                                    "---------------------------------------");
                            orders.showAll();
                            break;
                        case 3:
                            if (General.isNull(orders)) {
                                System.err.println("Do not initialized Products List or Customers List");
                                break;
                            }
                            General.sort(orders, 2);
                            orders.showAll();
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
