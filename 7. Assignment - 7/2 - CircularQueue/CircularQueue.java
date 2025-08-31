// Implement a circular Queue ADT using an array
class CircularQueueADT {
  private int[] elements;
  private int front;
  private int rear;
  private int capacity;
  private int size;

  public CircularQueueADT(int capacity) {
    this.capacity = capacity;
    elements = new int[capacity];
    front = 0;
    rear = -1;
    size = 0;
  }

  public boolean enqueue(int item) {
    if (size == capacity) {
      return false; 
    }
    rear = (rear + 1) % capacity;
    elements[rear] = item;
    size++;
    return true;
  }

  public Integer dequeue() {
    if (size == 0) {
      return null;
    }
    int item = elements[front];
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

public class CircularQueue {
  public static void main(String[] args) {
    CircularQueueADT Q1 = new CircularQueueADT(5);
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
