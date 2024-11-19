package Queue.Implication;

public class UsingJavaImp {
    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    class QueueImpUsingLinkedList {
        Node front;
        Node rear; // Corrected to 'rear'

        QueueImpUsingLinkedList() {
            front = rear = null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (rear == null) { // Use 'rear' for the empty check
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        public int remove() {
            if (front == null) {
                System.out.println("Queue is empty, cannot remove.");
                return -1; // Return -1 if queue is empty
            }
            int data = front.data;
            front = front.next;
            if (front == null) {
                rear = null; // Reset rear if the queue becomes empty
            }
            return data;
        }

        public int peek() {
            if (front == null) {
                System.out.println("Queue is empty, nothing to peek.");
                return -1; // Indicate the queue is empty
            }
            return front.data;
        }
    }

    public static void main(String[] args) {
        UsingJavaImp ui = new UsingJavaImp();
        QueueImpUsingLinkedList queue = ui.new QueueImpUsingLinkedList();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Front element: " + queue.peek()); // Should print 10

        System.out.println("Removed: " + queue.remove()); // Should print 10
        System.out.println("Front element after removal: " + queue.peek()); // Should print 20

        System.out.println("Removed: " + queue.remove()); // Should print 20
        System.out.println("Removed: " + queue.remove()); // Should print 30
        System.out.println("Removed from empty queue: " + queue.remove()); // Should print an error message
    }
}
