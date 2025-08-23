// Using Stack ADT implemented by array: write a program to convert a decimal number to its binary representation.

import java.util.Scanner;

class Stack {
  private int[] arr;
  private int top;
  private int capacity;

  Stack(int size) {
    arr = new int[size];
    capacity = size;
    top = -1;
  }

  public void push(int x) {
    if (isFull()) {
      System.out.println("Stack OverFlow");
      return;
    }
    arr[++top] = x;
  }

  public int pop() {
    if (isEmpty()) {
      System.out.println("STACK EMPTY");
      return -1; 
    }
    return arr[top--];
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public boolean isFull() {
    return top == capacity - 1;
  }
}

public class DecimalToBinary {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a decimal number: ");
    int decimal = scanner.nextInt();
    scanner.close();

    if (decimal == 0) {
      System.out.println("Binary representation is: 0");
      return;
    }

     
    Stack stack = new Stack(32);

    int tempDecimal = decimal;
    while (tempDecimal > 0) {
      int remainder = tempDecimal % 2;
      stack.push(remainder);
      tempDecimal /= 2;
    }

    System.out.print("Binary representation of " + decimal + " is: ");
    while (!stack.isEmpty()) {
      System.out.print(stack.pop());
    }
    System.out.println();
  }
}
