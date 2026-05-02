import java.util.*;

class ListNode {
      int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) {
           this.val = val;
           this.next = null;
       }
}

public class LinkedList {
    static ListNode head=null;
    static ListNode tail = null;
    static int size=0;

    public static void main(String[] args) {
       Scanner inp = new Scanner(System.in);
       
       int[] ll = {1,2,3,4,5};
       int[] nums = {1,2,3};

       HashMap<Integer,Integer> hm = new HashMap<>();

       ListNode h1 = convertArrayToLL(ll);

        ListNode newHead = modifiedList(nums, h1);
        printLL(newHead);



       printLL(h1);

       /*System.out.println(sizeLL(h1));
       ListNode temph1 = null;
       reverseKGroup(h1, k);*/

       /*long startTime,endTime;
       createLL();

       deleteDuplicates(head);

       removeDuplicatesNodes(head);

       insert(2,256);
       displayLL();

       System.out.println("Enter rotation count: ");
       int k = inp.nextInt();
       startTime = System.nanoTime();
       rotateRight(k);
       endTime = System.nanoTime();

       long runTime = (endTime-startTime);
       System.out.println("Run Time for rotating list is: "+(double)runTime+" ns");
       deleteNode(1);
       displayLL();*/

       /*ListNode head1 = null,head2=null,temp1=null,temp2=null;
       int choice =1;
       while(choice==1) {
           System.out.println("Enter data(h1): ");
           int data = inp.nextInt();
           ListNode newNode = new ListNode(data);
           if(head1==null){
               head1 = newNode;
               temp1 = head1;
           }else{
               temp1.next = newNode;
               temp1 = newNode;
           }
           System.out.println("Enter 1 to continue: ");
           choice = inp.nextInt();
       }
       choice =1;
       while(choice==1) {
           System.out.println("Enter data(h2): ");
           int data = inp.nextInt();
           ListNode newNode = new ListNode(data);
           if(head2==null){
               head2 = newNode;
               temp2 = head2;
           }else{
               temp2.next = newNode;
               temp2 = newNode;
           }
           System.out.println("Enter 1 to continue: ");
           choice = inp.nextInt();
       }
       printLL(head1);
       printLL(head2);
       printLL(addTwoNumbers(head1,head2));*/



   }

    public static ListNode modifiedList(int[] nums, ListNode h1) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i,0);
        }
        ListNode temp  = h1,newHead=null,nt=null;
        while (temp!=null){
            ListNode nn = temp;
            if(!hm.containsKey(temp.val)){
                if(newHead==null){
                    newHead = nn;
                    nt = newHead;
                }else {
                    nt.next  = nn;
                    nt =nn;
                }
            }
            temp = temp.next;
        }
        return newHead;
    }

    public static ListNode convertArrayToLL(int[] arr){
        ListNode head = null,temp = null;
        for(int i : arr){
            ListNode nn = new ListNode(i);
            if(head==null){
                head =nn;
                temp = head;
            }else{
                temp.next = nn;
                temp = nn;
            }
        }
        printLL(head);
        return head;
    }

    public static ListNode insertGreatestCommonDivisors(ListNode h1){

        ListNode current = h1, nextNode = current.next;
        int pos = 2;
        while(nextNode!=null) {
            ListNode nn = new ListNode(gcdIterative(current.val, nextNode.val));
            nn.next = nextNode;
            current.next = nn;
            pos+=2;
            current = nextNode;
            nextNode = current.next;
        }
        return h1;
    }

    public static int[][] spiralMatrix(int m , int n, ListNode h1){
        ArrayList<Integer> al = convertLLToArrayList(h1);


        int[][] mat = new int[m][n];
        int k=0;
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(k<al.size()){
                    mat[i][j] = al.get(k);
                    k++;
                }else {
                    mat[i][j] = -1;
                }
            }
        }
        return mat;
    }

    public static void printMat(int[][] mat,int m,int n){
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static ListNode convertArraytoLL(ArrayList<Integer> al){
        ListNode head = null,temp = null;
        for(Integer i : al){
            ListNode nn = new ListNode(i);
            if (head==null){
                head = nn;
                temp = nn;
            }else {
                temp.next = nn;
                temp = nn;
            }
        }
        return head;
    }

    public static ListNode doubleItArrayList(ListNode h1) {
        ArrayList<Integer> al = convertLLToArrayList(h1);
        int carry = 0;
        for (int i = al.size() - 1; i >= 0; i--) {
            int num = al.get(i) * 2 + carry;
            al.set(i, num % 10);
            carry = num / 10;
        }
        if (carry > 0) {
            al.add(0, carry);
        }

        return convertArraytoLL(al);
    }

    public static ListNode doubleIt(ListNode h1) {
        ListNode h2 = reverseList(h1);

        ListNode temp = h2;
        int carry = 0;
        ListNode t2 = null;

        while (temp != null) {
            int num = temp.val * 2 + carry;
            temp.val = num % 10;
            carry = num / 10;
            t2 = temp;
            temp = temp.next;
        }

        if (carry > 0) {
            ListNode nn = new ListNode(carry);
            t2.next = nn;
        }

        h2 = reverseList(h2);
        return h2;
    }

    public static void reorderList(ListNode h1) {
        int s = 2;
        while(s<sizeLL(h1)){
            int data = deleteEnd(h1).val;
            insert2(h1,data,s);
            s+=2;
        }
    }

    public static int sizeLL(ListNode head){
        int c=0;
        while(head!=null){
            c++;
            head = head.next;
        }
        return c;
    }

    //Only prints elements that exist once
    public static ListNode deleteDuplicates(ListNode head) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        ListNode tp = head;

       /* // Count occurrences without replace I guess.
        while (tp != null) {
            int key = tp.val;
            map.put(key, map.getOrDefault(key, 0) + 1);
            tp = tp.next;
        }*/

        while(tp!=null){
            int key = tp.val;
            if(map.containsKey(key)){
                map.replace(key,map.get(key),map.get(key)+1);
            }else{
                map.put(key,0);
            }
            tp = tp.next;
        }
        for(Map.Entry<Integer,Integer> iter : map.entrySet()){
            System.out.println("Key: "+iter.getKey()+" , Count: "+iter.getValue());
        }
        ListNode newHead = null,newTemp=null;
        for(Map.Entry<Integer,Integer> iter : map.entrySet()){
            ListNode newNode = new ListNode(iter.getKey());
            if(iter.getValue()==0){
                if(newHead==null){
                    newHead = newNode;
                    newHead.next = null;
                    newTemp = newHead;
                }else {
                    newTemp.next = newNode;
                    newTemp = newTemp.next;
                }
            }
        }
        ListNode tx = newHead;
        while(tx!=null){
            System.out.print(tx.val+" -> ");
            tx = tx.next;
        }

        return newHead;
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail = dummy;
        ListNode start = head;

        while (true) {
            ListNode end = start;
            int count = 1;
            while (count < k && end != null) {
                end = end.next;
                count++;
            }
            if (end == null) break;

            ListNode nextGroupHead = end.next;

            ListNode newHead = reverseList(start, nextGroupHead);

            // Connect previous group to new head
            prevGroupTail.next = newHead;

            // Connect old start (now tail) to next group
            start.next = nextGroupHead;
            prevGroupTail = start;
            start = nextGroupHead;
        }
        return dummy.next;
    }

    public static ListNode reverseList(ListNode head, ListNode temp){
        ListNode current = head;
        ListNode prev = null;
        ListNode nextNode;

        while (current != temp) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public static ListNode reverseList(ListNode head){
        ListNode prev = null,current=head,nextNode=null;

        while(current!=null){
            nextNode = current.next;
            current.next=prev;
            prev = current;
            current = nextNode;
        }
        head = prev;
        return head;
    }

    public static void addToList(ListNode head,ArrayList<Integer> al){
        while(head!=null){
            al.add(head.val);
            head = head.next;
        }

    }

    public static ArrayList<Integer> convertLLToArrayList(ListNode head){
        ArrayList<Integer> al = new ArrayList<>();
        while(head!=null){
            al.add(head.val);
            head = head.next;
        }
        return al;
    }

    public static int gcdIterative(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static ListNode mergeKLists(ListNode[] heads){
        ArrayList<Integer> al = new ArrayList<>();
        ListNode dummy=null,temp = null;
        for(ListNode h1 : heads){
            addToList(h1,al);
        }
        Collections.sort(al);
        for(int i=0;i<al.size();i++){
            ListNode nn = new ListNode(al.get(i));
            if(dummy==null){
                dummy = nn;
                temp = dummy;
            }else{
                temp.next = nn;
                temp = nn;
            }

        }
        return dummy;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }

    public static void removeDuplicatesNodes(ListNode head) {
        HashMap<Integer,Integer> map = new HashMap<>();

        ListNode newHead = null,newTemp =null;
        ListNode temp = head;

        while(temp!=null){
            map.putIfAbsent(temp.val, temp.val);
            temp = temp.next;
        }

        for(Map.Entry<Integer,Integer> val: map.entrySet()){
            ListNode newNode = new ListNode(val.getValue());
            if(newHead==null){
                 newHead = newNode;
                 newHead.next = null;
                 newTemp = newHead;
            }else{
                newTemp.next = newNode;
                newTemp = newTemp.next;
            }
        }

        ListNode tp = newHead;
        while(tp!=null){
            System.out.print(tp.val+" -> ");
            tp = tp.next;
        }
    }

    public static void printLL(ListNode head){
       while(head!=null){
           System.out.print(head.val+" -> ");
           head=head.next;
       }
        System.out.println("null");
    }

    public static void rotateRight(int x) {
        x=x%size;
        if(head == null || size <= 1 || x == 0){
            displayLL();
        }
        else{
            ListNode newTail = head;
            for(int i=0;i<size-x-1;i++){
                newTail=newTail.next;
            }
            tail.next=head;
            head = newTail.next;
            newTail.next=null;
            tail=newTail;
            displayLL();
        }

    }

    public static void createLL() {
        Scanner inp = new Scanner(System.in);
        ListNode temp=null;
        int choice = 1;
        while(choice==1){
            System.out.println("Enter data: ");
            int data = inp.nextInt();
            ListNode newListNode = new ListNode(data);
            if(head==null){
                head = newListNode;
                temp = head;
                tail = temp;
                newListNode.next=null;
                size++;
            }else{
                temp.next = newListNode;
                newListNode.next=null;
                temp = newListNode;
                tail=temp;
                size++;
            }
            System.out.println("Enter 1 to continue: ");
            choice = inp.nextInt();

        }
    }

    public static void displayLL() {
        ListNode temp = head;
        while(true){
            if(temp==tail){
                System.out.print(temp.val+" -> ");
                break;
            }else{
                System.out.print(temp.val+" -> ");
                temp = temp.next;
            }
        }
        System.out.println("null");
    }

    public static void displayLL(ListNode head){
       ListNode temp = head;
        while(true){
            if(temp==tail){
                System.out.print(temp.val+" -> ");
                break;
            }else{
                System.out.print(temp.val+" -> ");
                temp = temp.next;
            }
        }
        System.out.println("null");
    }

    public static void deleteNode(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid index");
            return;
        }
        if (position == 1) {
            deleteBeg();
            return;
        }
        if (position == size) {
            deleteEnd();
            return;
        }
        ListNode temp = head;
        for (int i = 0; i < position - 2; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public static void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        ListNode newTail = head;
        for (int i = 0; i < size - 2; i++) {
            newTail = newTail.next;
        }
        newTail.next = null;
        tail = newTail;
        size--;
        displayLL();
    }

    public static ListNode deleteEnd(ListNode head){
        while(head.next.next!=null){
            head=head.next;
        }
        ListNode del = head.next;
        head.next = null;
        return del;
    }

    public static void deleteBeg(){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        head=head.next;
        size--;
        System.gc();
        displayLL();
    }

    public static void insert(int position,int data){
        if(position==1||position<1){
            insertBeg(data);
            return;
        }
        if(position>=size){
            insertEnd(data);
            return;
        }
        ListNode newListNode = new ListNode(data);
        ListNode temp = head;
        for(int i=0;i<position-2;i++){
            temp=temp.next;
        }
        newListNode.next = temp.next;
        temp.next= newListNode;
        size++;

    }

    public static void insert2(ListNode head,int data, int pos){
        ListNode nn = new ListNode(data);
        if (pos < 0) {
            return;
        }
        if(pos>sizeLL(head)){
            return;
        }
        for(int i=0;i<pos-2;i++){
            head = head.next;
        }
        nn.next = head.next;
        head.next = nn;
    }

    public static void insertBeg(int data){
        ListNode temp=head;
        ListNode newListNode = new ListNode(data);
        if(head==null){
            head = newListNode;
            temp = head;
            tail = temp;
            newListNode.next=null;
            size++;
        }
        else{
            newListNode.next=head;
            head= newListNode;
            size++;
        }
    }

    public static void insertEnd(int data){
        if(head==null){
            insertBeg(data);
            return;
        }else{
            ListNode newListNode = new ListNode(data);
            tail.next = newListNode;
            newListNode.next=null;
            tail= newListNode;
            size++;
        }
    }

    public static int calcSize(ListNode head){
       int size =0;
       ListNode temp = head;
       while(temp!=null){
           size++;
           temp=temp.next;
       }
       return size;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = calcSize(head);

        int position = size - n + 1;

        if (position < 0 || position >= size) {
            System.out.println("Invalid index");
        }
        if (position == 1) {
            deleteBeg();
        }
        if (position == size) {
            deleteEnd();
        }
        for (int i = 0; i < position - 2; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
        return head;
    }

}

