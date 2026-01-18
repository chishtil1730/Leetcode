import java.util.Scanner;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class ListL {
   static Node head=null,temp=null;
    public static void main(String[] args) {
        createLL();
        insertBeg();
        insertEnd();
        display();
    }

    private static void createLL() {
        Scanner inp = new Scanner(System.in);
        int choice=1;
        while(choice==1){
            System.out.println("Enter data: ");
            int data = inp.nextInt();
            Node newNode = new Node(data);
            if(head==null){
                head = newNode;
                temp = head;
            }else {
                temp.next = newNode;
                temp = newNode;
            }
            System.out.println("Enter 1 to continue: ");
            choice = inp.nextInt();
        }
    }

    private static void display(){
        Node temp = head;
        System.out.print("LinkedList: ");
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.print("null\n");
    }

    private static void insertBeg(){
        System.out.println("Enter data to be inserted at beg: ");
        Scanner inp = new Scanner(System.in);
        int data = inp.nextInt();
        Node insert = new Node(data);
        insert.next=head;
        head = insert;
    }

    private static void insertEnd(){
        System.out.println("Enter data to be inserted at end: ");
        Scanner inp = new Scanner(System.in);
        int data = inp.nextInt();
        Node insert = new Node(data);
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=insert;
    }

    

}
