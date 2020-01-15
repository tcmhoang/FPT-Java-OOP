import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Show Menu: \n" +
                    "1.Product List\n" +
                    "2.Customer List\n" +
                    "3.Order List\n");
            int menu = input.nextInt(), choice = General.showMenu(menu);
            switch (menu) {
                case 1:
                    List products = null;
                    ListNode res = null;
                    switch (choice){
                        case 1:
                            if(products == null){
                                products = new List();
                            }
                            System.out.println("Enter the path to file you wanna import!");
                            String path = input.next();
                            General.loadData(path,products);
                            break;
                        case 2:
                            products.append(General.addProduct());
                            break;
                        case 3:
                            System.out.println("code |   Pro_name  |  Quantity  |  saled |  Price   |   Value \n" +
                                    "-------------------------------------------------------------------");
                            products.showAll();
                            break;
                        case 4:
                            FileHandler.write(products.getData());
                            System.out.println("Write Successful PATH: \"test/output\"");
                            break;
                        case 5:
                            System.out.println("Enter pcode you wanna search: ");
                            res = General.search(input.next(),"pcode",products);
                            if(res == null){
                                System.out.println("NOT EXITSTED");
                            } else {
                                System.out.println(res.val.toString());
                            }
                            break;
                        case 6:
                            System.out.println("Enter pcode you wanna search: ");
                            General.remove(input.next(),"pcode",Product.getIDsCollection(),products);
                            break;
                        case 7:
                            General.sortProduct(products);
                            System.out.println("Sorted!");
                            products.showAll();
                            break;
                        case 8:
                            System.out.println("Enter a code you wanna insert after it:");
                            res = General.search(input.next(),"pcode",products);
                            if(res == null){
                                System.out.println("NOT EXITSTED");
                            } else {
                                products.insert(res,General.addProduct());
                            }
                            break;
                        case 9:
                            System.out.println("Enter xCode you wanna delete from: ");
                            res = General.search(input.next(),"pcode",products);
                            if(res == null){
                                System.out.println("NOT EXITSTED");
                            } else {
                                products.deleteRest(res);
                            }
                            products.showAll();
                            break;
                        default:
                    }
                case 2:
                case 3:
            }
        }
    }
}
