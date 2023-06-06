public class algorithms2 {

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
 
        Node head = null;
        for (int num: nums) {
            head = shift(head, num);
        }
 
        printList("Данный список: ", head);
        head = revert(head);
        printList("Перевернутый список: ", head);
    }

    class Node {
        int data;
        Node next, prev;
    }

    class Main {
        public static Node shift(Node head, int num) {
            Node node = new Node();
            node.data = num;
            node.prev = null;
            node.next = head;
 
            if (head != null) {
                head.prev = node;
        }
 
        head = node;
        return head;
    }
 
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);
        while (head != null)
        {
            System.out.print(head.data + " —> ");
            head = head.next;
        }
 
        System.out.println("null");
    }
 
    public static void exchange(Node node)
    {
        Node previous = node.prev;
        node.prev = node.next;
        node.next = previous;
    }
 
    public static Node revert(Node head)
    {
        Node previous = null;
        Node number = head;
 
        while (number != null)
        {
            exchange(number);
            previous = number;
            number = number.prev;
        }

        if (previous != null) {
            head = previous;
        }
 
        return head;
    }
}}

