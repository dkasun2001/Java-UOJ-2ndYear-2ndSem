// Write a Java program to remove duplicates from a given stack.

class StackADT{
    int maxSize;
    int[] stackArray;
    int top;

    public StackADT(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1; // Initialize the top of the stack to -1 (empty)
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;// Check if the stack is full
    }

    // Push data onto the stack
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + data);
        } else {
            stackArray[++top] = data;
        }
    }

    // Pop data from the stack 
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    // Peek at the top data of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // Display the contents of the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}

public class RemoveDuplicates {

  public static void removeDuplicates(StackADT stack) {
    StackADT tempStack = new StackADT(stack.maxSize);
    boolean[] seen = new boolean[100]; // Assuming stack values are in the range 0-99

    while (!stack.isEmpty()) {
      int current = stack.pop();
      if (!seen[current]) {
        seen[current] = true;
        tempStack.push(current);
      }
    }

    // Restore the original stack with unique elements
    while (!tempStack.isEmpty()) {
      stack.push(tempStack.pop());
    }
  }

  public static void main(String[] args) {
      StackADT stack = new StackADT(10);
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(5);
      stack.push(78);
      stack.push(9);
      stack.push(2);
      stack.push(4);
      stack.push(3);
      stack.push(5);

      System.out.println("Original Stack:");
      stack.display();

      removeDuplicates(stack);

      System.out.println("Stack After Removing Duplicates:");
      stack.display();
  }

  
}