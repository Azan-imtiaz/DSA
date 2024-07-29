package Implementations;
class Node2 {
    Node2 next;
    int data;

    public Node2(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node2 head;

    public Boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node2 elem = new Node2(data);
        if (isEmpty()) {
            head = elem;
            return;
        }
        elem.next = head;
        head = elem;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        } else {
            return head.data;
        }
    }

    public void print() {
        Node2 temp = head;
        while (temp != null) {

            System.out.println(temp.data);

            temp = temp.next;
        }
    }

    public int pop() {

        if (isEmpty()) {

            System.out.println("No data is present in stack ");
            return -1;
        } else {
            int data=head.data;
            head = head.next;
            return data;
        }
    }

}

class MainClass {
    public static void main(String[] args) {
        Stack obj = new Stack();
        obj.push(22);
        obj.push(19);
        System.out.println(obj.pop()+"   "+
        // obj.pop()+" "+
        obj.pop());
        
        System.out.println(obj.peek());
    }
}
