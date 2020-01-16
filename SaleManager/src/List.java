import java.util.Objects;

public class List {
    ListNode head, tail;

    List() {
        head = tail = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    void append(Object x) {
        ListNode node = new ListNode(x);
        if (isEmpty()) {
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    void showAll() {
        ListNode dummyNode = head;
        while (dummyNode != null) {
            System.out.println(dummyNode.val);
            dummyNode = dummyNode.next;
        }
    }
    String getData(){
        StringBuilder output = new StringBuilder();
        ListNode dummyNode = head;
        while (dummyNode != null) {
            output.append(dummyNode.val).append("\n");
            dummyNode = dummyNode.next;
        }
        return output.toString();
    }

    ListNode getCustomer(String ID) {
        ListNode dummyNode = head;
        while (dummyNode != null) {
            if (((Customer) dummyNode.val).getID().equals(ID)) {
                return dummyNode;
            }
            dummyNode = dummyNode.next;
        }
        return null;
    }

    ListNode getProduct(String ID) {
        ListNode dummyNode = head;
        while (dummyNode != null) {
            if (((Product) dummyNode.val).getID().equals(ID)) {
                return dummyNode;
            }
            dummyNode = dummyNode.next;
        }
        return null;
    }

    void remove(ListNode danmNode) {
        if(isEmpty() || danmNode == null) return;
        ListNode dummyNode = head;
        while (!Objects.equals(danmNode, dummyNode.next)) {
            dummyNode = dummyNode.next;
        }
        dummyNode.next = danmNode.next;
    }

    void sortProduct() {
        ListNode n1, n2;
        Object nah;
        n1 = head;
        while (n1 != null) {
            n2 = n1.next;
            while (n2 != null) {
                if (((Product) n1.val).getID().compareTo(((Product) n2.val).getID()) > 0) {
                    nah = n1.val;
                    n1.val = n2.val;
                    n2.val = nah;
                }
                n2 = n2.next;
            }
            n1 = n1.next;
        }
    }

    void sortCustomer() {
        ListNode n1, n2;
        Object nah;
        n1 = head;
        while (n1 != null) {
            n2 = n1.next;
            while (n2 != null) {
                if (((Customer) n1.val).getID().compareTo(((Customer) n2.val).getID()) > 0) {
                    nah = n1.val;
                    n1.val = n2.val;
                    n2.val = nah;
                }
                n2 = n2.next;
            }
            n1 = n1.next;
        }
    }

    void insert(ListNode node, Object x) {
        if (isEmpty()) {
            append(x);
            return;
        } else if (node == null) return;
        ListNode tempNode = node.next;
        ListNode newNode = new ListNode(x, tempNode);
        node.next = newNode;
        if (tail == newNode) tail = tempNode;
    }
    void deleteRest(ListNode node){
        if(isEmpty() || node == null) return;
        ListNode dummyNode = head;
        while (Objects.equals(node, dummyNode)) {
            dummyNode = dummyNode.next;
        }
        dummyNode.next = null;
    }

}
