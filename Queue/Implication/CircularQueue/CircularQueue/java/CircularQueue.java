package Queue.Implication.CircularQueue.CircularQueue.java;

public class CircularQueue {
    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;

    public CircularQueue() {
        front = rear = null;
    }

    // Add an element to the queue
    public void add(int data) {
        Node newNode = new Node(data);
        if (front == null) { // If queue is empty
            front = newNode;
            rear = newNode;
            rear.next = front; // Point rear to front to make it circular
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front; // Maintain circular nature
        }
    }

    // Remove an element from the queue
    public int remove() {
        if (front == null) {
            System.out.println("Queue is empty, cannot remove.");
            return -1; // Queue is empty
        }
        int data = front.data;
        if (front == rear) { // Only one element
            front = rear = null; // Reset queue
        } else {
            front = front.next;
            rear.next = front; // Maintain circular connection
        }
        return data;
    }

    // Peek at the front element
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty, nothing to peek.");
            return -1; // Indicate the queue is empty
        }
        return front.data;
    }

    // Main method for testing
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Front element: " + queue.peek()); // Should print 10

        System.out.println("Removed: " + queue.remove()); // Should print 10
        System.out.println("Front element after removal: " + queue.peek()); // Should print 20

        queue.add(40);
        System.out.println("Front element after adding 40: " + queue.peek()); // Should print 20

        System.out.println("Removed: " + queue.remove()); // Should print 20
        System.out.println("Removed: " + queue.remove()); // Should print 30
        System.out.println("Removed: " + queue.remove()); // Should print 40
        System.out.println("Removed from empty queue: " + queue.remove()); // Should print an error message
    }
}
