package Implementations;
class StackK {
    int top;
    int capacity;
    int arr[];

    public StackK(int size) {
        this.capacity = size;
        this.top = -1;
        arr = new int[capacity];
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        top++;
        arr[top] = value;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        top--;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    public Boolean isEmpty() {
        if (top == -1)
            return true;
        return false;
    }

    public Boolean isFull() {
        if (top == capacity - 1)
            return true;
        return false;
    }
}

class MainClass23 {
    public static void main(String[] args) {
        System.err.println("hello world ");
        StackK obj = new StackK(3);
        obj.push(5);
        obj.push(8);
        obj.push(10);
        obj.pop();
        obj.push(12);

        System.out.println(obj.peek());

    }
}