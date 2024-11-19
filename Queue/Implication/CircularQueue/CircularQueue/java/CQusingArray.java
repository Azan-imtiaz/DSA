package Queue.Implication.CircularQueue.CircularQueue.java;

public class CQusingArray {
    private int capacity;
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    // Constructor to initialize the circular queue
    public CQusingArray(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Enqueue an element
    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity; // Circular increment
        queue[rear] = item;
        size++;
    }

    // Dequeue an element
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = queue[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        return item;
    }

    // Peek at the front element
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    // String representation of the queue
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(queue[(front + i) % capacity]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        CQusingArray queue = new CQusingArray(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue); // Output: [1, 2, 3]

        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.peek());     // Output: 2
        System.out.println(queue);             // Output: [2, 3]
        
        // Testing circular behavior
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue); // Output: [2, 3, 4, 5]
        
        queue.dequeue(); // Remove 2
        queue.enqueue(6); // Add 6
        System.out.println(queue); // Output: [3, 4, 5, 6]
    }
}
