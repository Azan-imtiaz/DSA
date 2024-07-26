class Node {

    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }

}

class LL {
    Node head;
    int size;

    LL() {
        size = 0;
    }

// Add by default add at last

    public void add(int value) {
        Node newNode = new Node(value);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }
        Node tempNode = head;
        while (tempNode.next != null) {   // to find last Node 
            tempNode = tempNode.next;
        }
        newNode.next = tempNode.next;
        tempNode.next = newNode;
    }

// function to insert at the end of list

public void addLast(int value) {
        Node newNode = new Node(value);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }
        Node tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        newNode.next = tempNode.next;
        tempNode.next = newNode;
    }

        // add using index and data
        public void add(int index, int data) {
            if (index >= size || index < 0) {
                System.out.println("invalid index value");
                return;
            }
            size++;
            Node newNode = new Node(data);
            if (head == null || index == 0) {
                newNode.next = head;
                head = newNode;
                return;
            }
    
            Node currNode = head;
            for (int i = 1; i < size; i++) {
                if (i == index) {
                    Node nextNode = currNode.next;
                    currNode.next = newNode;
                    newNode.next = nextNode;
                    break;
                }
                currNode = currNode.next;
            }
    
        }
    
    
        // remove element By taking index
    public void remove(int index) {
        // System.out.println(null);
        if (index < 0 || index >= size) {
            return; // Index out of bounds
        }
        size--;
        if (size == 0) {
            head = null; // There's only one node in the list
            return;
        }
        if (index == 0) {
            head = head.next; // Removing the head
            return;
        }
        Node prev = null;
        Node cur = head;
        for (int i = 0; i < index; i++) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next; // Remove the node at the given index
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        Node copy = head;
        while (copy != null) {
            System.out.print(copy.value + "   ");
            copy = copy.next;
        }
    }

    public int getSize() {
        return size;
    }

    // remove first element
    public void removeFirst() {
        if (head == null) {
            return;
        }
        size--;
        head = head.next;
    }

    // remove last element
    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Node tempNode = head;
        Node prevtempNode = null;
        while (tempNode.next != null) {
            prevtempNode = tempNode;
            tempNode = tempNode.next;
        }
        prevtempNode.next = null;
        size--;
    }
 
   public void  reverse(){
      if(head==null){
        return;
      }
      if(head.next==null){
        return;
      }
      Node prev=head;
      Node cur=head.next;
      while(cur != null){
        Node fast=cur.next;
        cur.next=prev;

    prev=cur;
    cur=fast;    
    }

      head.next=null;
      head=prev;
   }
     

}

public class linkdedList {

    public static void main(String[] args) {
        LL l = new LL();
        l.add(1);

        l.add(2);

        l.add(3);

        l.add(4);
        l.add(5);
        l.reverse();
        l.print();

    }

}