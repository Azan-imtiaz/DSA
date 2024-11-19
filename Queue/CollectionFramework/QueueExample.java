package Queue.CollectionFramework;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Create a Queue
        Queue<String> queue = new LinkedList<>();

        // Add elements to the queue
        queue.offer("Element 1");
        queue.offer("Element 2");
        queue.offer("Element 3");

        // Display the queue
        System.out.println("Queue: " + queue);

        // Peek at the front element without removing it
        String front = queue.peek();
        System.out.println("Front element: " + front);

        // Remove elements from the queue
        String removed = queue.poll();
        System.out.println("Removed element: " + removed);
        
        // Display the queue after removal
        System.out.println("Queue after removal: " + queue);

        // Check if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? " + isEmpty);
    }
}
