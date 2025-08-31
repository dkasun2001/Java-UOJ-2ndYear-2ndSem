// Implement a generic Queue using an array
class GenericQueueADT<T> {
    private T[] elements;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public GenericQueueADT(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enqueue(T item) {
        if (size == capacity) {
            return false;
        }
        rear = (rear + 1) % capacity;
        elements[rear] = item;
        size++;
        return true;
    }

    public T dequeue() {
        if (size == 0) {
            return null;
        }
        T item = elements[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

public class GenericQueue {
    public static void main(String[] args) {
        GenericQueueADT<Integer> Q1 = new GenericQueueADT<>(5);
        Q1.enqueue(1);
        Q1.enqueue(2);
        Q1.enqueue(3);
        Q1.enqueue(4);
        Q1.enqueue(5);
        Q1.enqueue(6);
        Q1.display();
        System.out.println("Dequeued: " + Q1.dequeue());
        System.out.println("Queue size: " + Q1.size());
        Q1.display();
    }
}