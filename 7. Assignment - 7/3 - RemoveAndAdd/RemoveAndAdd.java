// Using Stack and Queue ADT implemented by array: Remove the first K elements of the Queue and reversely add them in the same queue.

class QueueADT {
    private int front, rear, size;
    private int capacity;
    private int[] array;

    public QueueADT(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.size = 0;
        this.rear = -1;
        this.array = new int[this.capacity];
    }

    public boolean isFull() {
        return (this.size == this.capacity);
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return item;
    }

    //
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return this.array[this.front];
    }

    public int getSize() {
        return this.size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

class StackADT {
    private int top;
    private int capacity;
    private int[] array;

    public StackADT(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.array = new int[this.capacity];
    }

    public boolean isFull() {
        return (this.top == this.capacity - 1);
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        this.array[++top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return this.array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return this.array[top];
    }

    public int getSize() {
        return (top + 1);
    }
}

public class RemoveAndAdd {
    public static void main(String[] args) {
        QueueADT queue = new QueueADT(5);
        StackADT stack = new StackADT(5);

        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }
        queue.display();
        int K = 3;
        for (int i = 0; i < K; i++) {
            int item = queue.dequeue();
            if (item != -1) {
                stack.push(item);
            }
        }

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        queue.display();
    }
}