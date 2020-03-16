import java.io.*;
import java.util.ArrayList;

public class BSTree {
    Node root;
    int count;

    BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    Node search(Node p, String code) {
        if (p == null) return (null);
        Product pInfo;
        Customer cInfo;
        if (p.info instanceof Product) {
            pInfo = (Product) p.info;
            if (pInfo.getID().equalsIgnoreCase(code)) return (p);
            if (code.compareTo(pInfo.getID()) < 0)
                return (search(p.left, code));
            else
                return (search(p.right, code));
        } else if (p.info instanceof Customer) {
            cInfo = (Customer) p.info;
            if (cInfo.getID().equalsIgnoreCase(code)) return (p);
            if (code.compareTo(cInfo.getID()) < 0)
                return (search(p.left, code));
            else
                return (search(p.right, code));
        }
        return null;
    }

    void visit(Node p) {
        System.out.println(p.info);
    }

    void breadth(Node p) {
        if (p == null) return;
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            if (r.left != null) q.enqueue(r.left);
            if (r.right != null) q.enqueue(r.right);
        }
    }

    void preOrder(Node p) {
        if (p == null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void inOrder(Node p) {
        if (p == null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void postOrder(Node p) {
        if (p == null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void loadProduct(String fname) throws IOException { // Using FileReader class
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] a;
        while (true) {
            s = br.readLine();
            if (s == null) break;
            a = s.split("\\s+[|]\\s+");
            if (a.length != 5) break;
            insert(new Product(a));
        }
        fr.close();
        br.close();
    }


    void loadCustomer(String fname) throws IOException { // Using FileReader class
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] a;

        while (true) {
            s = br.readLine();
            if (s == null) break;
            a = s.split("[|]");
            if (a.length != 3) break;
            insert(new Customer(a));
        }
        fr.close();
        br.close();
    }


    public void insert(Product product) {
        if (isEmpty()) {
            root = new Node(product);
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (((Product) p.info).getID().equalsIgnoreCase(product.getID())) {
                System.out.println("The key " + product.getID() + " already exists, no insertion");
                return;
            }
            f = p;
            if (product.getID().compareTo(((Product) p.info).getID()) < 0)
                p = p.left;
            else
                p = p.right;
        }
        if (product.getID().compareTo(((Product) f.info).getID()) < 0)
            f.left = new Node(product);
        else
            f.right = new Node(product);
    }

    public void insert(Customer customer) {
        if (isEmpty()) {
            root = new Node(customer);
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (((Customer) p.info).getID().equalsIgnoreCase(customer.getID())) {
                System.out.println("The key " + customer.getID() + " already exists, no insertion");
                return;
            }
            f = p;
            if (customer.getID().compareTo(((Customer) p.info).getID()) < 0)
                p = p.left;
            else
                p = p.right;
        }
        if (customer.getID().compareTo(((Customer) f.info).getID()) < 0)
            f.left = new Node(customer);
        else
            f.right = new Node(customer);
    }

    public void insert(Order order) {
        if (isEmpty()) {
            root = new Node(order);
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (((Order) p.info).getPcode().equalsIgnoreCase(order.getPcode())
                    && ((Order) p.info).getCcode().equalsIgnoreCase(order.getCcode())) {
                System.out.println("The key " + order.getCcode() + " " + order.getPcode() + " already exists, no insertion");
                return;
            }
            f = p;
            if (((Order) p.info).getPcode().equalsIgnoreCase(order.getPcode())) {
                if (order.getCcode().compareTo(((Order) p.info).getCcode()) < 0)
                    p = p.left;
                else
                    p = p.right;
            }
            else if (order.getPcode().compareTo(((Order) p.info).getPcode()) < 0)
                p = p.left;
            else
                p = p.right;
        }

        if (((Order) f.info).getPcode().equalsIgnoreCase(order.getPcode())) {
            if (order.getCcode().compareTo(((Order) f.info).getCcode()) < 0)
                f.left = new Node(order);
            else
                f.right = new Node(order);
        }
        else if (order.getPcode().compareTo(((Order) f.info).getPcode()) < 0)
            f.left = new Node(order);
        else
            f.right = new Node(order);

    }

    void visit(PrintWriter pw, Node p) throws IOException {
        if (pw == null || p == null) return;
        pw.printf(((Product) p.info).toString());
    }

    void saveFileBreadth(String fname, Node p) throws IOException { // Using FileReader class
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(pw, r);
            if (r.left != null) q.enqueue(r.left);
            if (r.right != null) q.enqueue(r.right);
        }
        pw.close();
        fw.close();
    }

    void saveFileInOrder(String fname, Node p) throws IOException { // Using FileReader class
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        inOrder(pw, p);
        pw.close();
        fw.close();
    }

    void inOrder(PrintWriter pw, Node p) throws IOException {
        if (p == null) return;
        inOrder(p.left);
        visit(pw, p);
        inOrder(p.right);
    }

    void deleByCopy(String code) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if ((((Product) p.info).getID().equalsIgnoreCase(code))) break;
            f = p;
            if (code.compareTo(((Product) p.info).getID()) < 0)
                p = p.left;
            else
                p = p.right;
        }
        if (p == null) return; // not found
        // p is a leaf node
        if (p.left == null && p.right == null) {
            if (f == null) { // p==root
                root = null;
                return;
            }
            if (p == f.left)
                f.left = null;
            else
                f.right = null;
        }
        // p has left son only
        if (p.left != null && p.right == null) {
            if (f == null) { // p==root
                root = p.left;
                return;
            }
            if (p == f.left)
                f.left = p.left;
            else
                f.right = p.left;
        }
        // p has right son only
        if (p.left == null && p.right != null) {
            if (f == null) { // p==root
                root = p.right;
                return;
            }
            if (p == f.left)
                f.left = p.right;
            else
                f.right = p.right;
        }
        // p has both 2 sons
        if (p.left != null && p.right != null) {
            Node q = p.left;
            // find the right-most node in the left sub-tree
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (frp == null) { // rp==q
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }

    }

    void balancePro(ArrayList<Product> t, int i, int j) {
        if (i > j) return;
        int k = (i + j) / 2;
        Product x = t.get(k);
        insert(x);
        balancePro(t, i, k - 1);
        balancePro(t, k + 1, j);
    }

    void balPro() {
        ArrayList<Product> t = new ArrayList<>();
        inOrderPro(t, root);
        clear();
        int n = t.size();
        balancePro(t, 0, n - 1);
    }

    void inOrderPro(ArrayList<Product> t, Node p) {
        if (p == null) return;
        inOrderPro(t, p.left);
        t.add((Product) p.info);
        inOrderPro(t, p.right);
    }

    int count() {
        count = 0;
        count(root);
        return count;
    }

    void count(Node root) {
        if (root == null) return;
        count(root.left);
        count(root.right);
        count++;
    }

    void balance(ArrayList<Order> t, int i, int j) {
        if (i > j) return;
        int k = (i + j) / 2;
        Order x = t.get(k);
        insert(x);
        balance(t, i, k - 1);
        balance(t, k + 1, j);
    }

    void balOrder() {
        ArrayList<Order> t = new ArrayList<>();
        inOrder(t, root);
        clear();
        int n = t.size();
        balance(t, 0, n - 1);
    }

    void inOrder(ArrayList<Order> t, Node p) {
        if (p == null) return;
        inOrder(t, p.left);
        t.add((Order) p.info);
        inOrder(t, p.right);
    }
}
