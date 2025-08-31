/* 
Using Queue ADT implemented by linked list: Write a program to interleave the first half of a queue with the second half.
  Input:     123456
  Output:  142536 
*/

class QueueADT {
    private Node front, rear;
    private int size;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public QueueADT() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public int getSize() {
        return size;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

    }

    public void interleaveQueue(QueueADT queue) {
        if (queue.getSize() % 2 != 0) {
            System.out.println("Queue is empty");
            return;
        }
        if (queue.getSize() % 2 != 0) {
            System.out.println("Queue hasn't even number of elements");
            return;
        }

        QueueADT firstHalf = new QueueADT();
        QueueADT secondHalf = new QueueADT();
        int halfSize = queue.getSize() / 2;

        for (int i = 0; i < halfSize; i++) {
            firstHalf.enqueue(queue.dequeue());
        }
        while (!queue.isEmpty()) {
            secondHalf.enqueue(queue.dequeue());
        }

        QueueADT interleaved = new QueueADT();
        Node current1 = firstHalf.front;
        Node current2 = secondHalf.front;
        while (current1 != null && current2 != null) {
            interleaved.enqueue(current1.data);
            interleaved.enqueue(current2.data);
            current1 = current1.next;
            current2 = current2.next;
        }

        queue.front = interleaved.front;
        queue.rear = interleaved.rear;
        queue.size = interleaved.size;
    }
}

public class Interleave {
    public static void main(String[] args) {
        QueueADT Q1 = new QueueADT();
        Q1.enqueue(1);
        Q1.enqueue(2);
        Q1.enqueue(3);
        Q1.enqueue(4);
        Q1.enqueue(5);
        Q1.enqueue(6);
        System.out.println("Original Queue:");
        Q1.display();
        Q1.interleaveQueue(Q1);
        System.out.println("Interleaved Queue:");
        Q1.display();
    }
}