class DoublyLinkedList {
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    // Insert a node at the end
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Insert a node at the beginning
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    public void delete(int data) {
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node not found!");
            return;
        }
        // If it's the head
        if (current == head) {
            head = current.next;
            if (head != null) head.prev = null;
            else tail = null; // list became empty
        }
        // If it's the tail
        else if (current == tail) {
            tail = current.prev;
            tail.next = null;
        }
        // Middle node
        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }
    public void display() {
        Node current = head;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertLast(10);
        dll.insertLast(20);
        dll.insertLast(30);
        dll.insertFirst(5);

        dll.display();
        dll.delete(20);
        dll.display();
    }
}
