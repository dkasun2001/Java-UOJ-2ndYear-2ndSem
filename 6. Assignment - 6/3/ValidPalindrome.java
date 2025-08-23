// Using Stack ADT implemented by the linked list: write a Java program to determine if a given string is a valid palindrome. Ignore non-alphanumeric characters and consider uppercase and lowercase characters as the same.

class Node<T> {
  T data;
  Node<T> next;

  public Node(T data) {
    this.data = data;
    this.next = null;
  }
}

class Stack<T> {
  private Node<T> top;

  public Stack() {
    this.top = null;
  }

  public void push(T data) {
    Node<T> newNode = new Node<>(data);
    newNode.next = top;
    top = newNode;
  }

  public T pop() {
    if (isEmpty()) {
      return null;
    }
    T data = top.data;
    top = top.next;
    return data;
  }

  public boolean isEmpty() {
    return top == null;
  }
}

public class ValidPalindrome {

  public static boolean isPalindrome(String s) {
    Stack<Character> stack = new Stack<>();
    StringBuilder forwardCleanedString = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (Character.isLetterOrDigit(c)) {
        char lowerC = Character.toLowerCase(c);
        forwardCleanedString.append(lowerC);
        stack.push(lowerC);
      }
    }

    StringBuilder reversedCleanedString = new StringBuilder();
    while (!stack.isEmpty()) {
      reversedCleanedString.append(stack.pop());
    }

    return forwardCleanedString.toString().equals(reversedCleanedString.toString());
  }

  public static void main(String[] args) {
    String str1 = "A man, a plan, a canal: Panama";
    System.out.println("Is \"" + str1 + "\" a palindrome? " + isPalindrome(str1));

  }
}
