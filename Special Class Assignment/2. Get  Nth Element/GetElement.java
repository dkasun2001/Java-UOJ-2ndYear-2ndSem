// Write a Java program to get the nth element from the bottom of the stack.
class StackADT {
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
    return top == maxSize - 1;
  }

  public void push(int data) {
    if (isFull()) {
      System.out.println("Stack is full. Cannot push " + data);
    } else {
      // top = top+1
      // stackArray[top] = data;
      stackArray[++top] = data;
      
    }
  }

  public int pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty. Cannot pop.");
      return -1;
    } else {
      int data = stackArray[top];
      // top = top-1
      top--;
      return data;
    }
  }

  public int peek() {
    if (isEmpty()) {
      System.out.println("Stack is empty.");
      return -1;
    } else {
      return stackArray[top];
    }
  }

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

public class GetElement {

  public static int getElement(StackADT stack, int n) {
    if (n <= 0 || n > stack.top + 1) {
      System.out.println("Invalid position: " + n);
      return -1; // Invalid position
    }

    // Create a temporary stack to hold elements
    StackADT tempStack = new StackADT(stack.maxSize);
    int element = -1;

    // Pop elements from the original stack to the temporary stack
    for (int i = 0; i < n; i++) {
      if (!stack.isEmpty()) {
        element = stack.pop();
        tempStack.push(element);
      }
    }

    // Push back the elements to the original stack
    while (!tempStack.isEmpty()) {
      stack.push(tempStack.pop());
    }

    return element; // Return the nth element from the bottom
  }

  public static void main(String[] args) {
    StackADT stack = new StackADT(10);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(5);
    stack.push(8);
    stack.push(9);
    stack.push(2);
    stack.push(4);
    stack.push(3);
    stack.push(5);

    System.out.println("Original Stack:");
    stack.display();

    int nthElement = getElement(stack, 3);
    if (nthElement != -1) {
      System.out.println("The 3rd element from the bottom is: " + nthElement);
    }

    
    stack.display();
  }

}