/* Compare two sentences.Write a Java program to compare two sentences stored as linked lists of words,and check if they are equal while ignoring case differences. */

class Node<T> {
  T data;
  Node<T> next;

  public Node(T data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedListADT<T> {
  Node<T> head;

  public LinkedListADT() {
    this.head = null;
  }

  public boolean isEmpty() {
    return head == null;
  }

  // Get the size of the linked list
  public int getSize() {
    int size = 0;
    Node<T> current = head;
    while (current != null) {
      size++;
      current = current.next;
    }
    return size;
  }

  // Insert a new node at the front of the linked list
  public void insertAtFront(T data) {
    Node<T> newNode = new Node<>(data);
    if (isEmpty()) {
      head = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
  }

  // Insert a new node at the end of the linked list
  public void insertAtEnd(T data) {
    Node<T> newNode = new Node<>(data);
    if (isEmpty()) {
      head = newNode;
    } else {
      Node<T> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  // Insert a new node at a specific index in the linked list
  public void insertAtIndex(T data, int index) {
    if (index < 1 || index > getSize() + 1) {
      System.out.println("Invalid index");
      return;
    }

    if (index == 1) {
      insertAtFront(data);
      return;
    }

    Node<T> newNode = new Node<>(data);
    Node<T> current = head;

    for (int i = 1; i < index - 1 && current != null; i++) {
      current = current.next;
    }

    if (current == null) {
      System.out.println("Index out of bounds");
      return;
    }

    newNode.next = current.next;
    current.next = newNode;
  }

  // Delete the first node of the linked list
  public void deleteAtFront() {
    if (isEmpty()) {
      System.out.println("List is empty");
      return;
    } else {
      head = head.next;
    }
  }

  // Delete the last node of the linked list
  public void deleteAtEnd() {
    if (isEmpty()) {
      System.out.println("List is empty");
      return;
    }
    if (head.next == null) {
      head = null;
    } else {
      Node<T> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current = current.next;
    }
  }

  // Delete the node at a specific index in the linked list
  public void deleteAtIndex(int index) {
    if (isEmpty()) {
      System.out.println("List is empty");
      return;
    }
    if (index < 1 || index > getSize()) {
      System.out.println("Invalid index");
      return;
    }
    if (index == 1) {
      deleteAtFront();
      return;
    }
    Node<T> current = head;
    for (int i = 1; i < index - 1 && current != null; i++) {
      current = current.next;
    }
    if (current == null || current.next == null) {
      System.out.println("Index out of bounds");
      return;
    }
    current.next = current.next.next;
  }

  // Search for a specific value in the linked list
  public boolean search(T key) {
    if (isEmpty()) {
      return false;
    }
    Node<T> current = head;
    while (current != null) {
      if (current.data.equals(key)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  // Print the linked list
  public void printList() {
    if (isEmpty()) {
      System.out.println("List is empty");
      return;
    }
    Node<T> current = head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }
}

public class CompareSentences {

  public static boolean compareSentences(LinkedListADT<String> list1, LinkedListADT<String> list2) {
    if (list1.getSize() != list2.getSize()) {
      return false;
    }

    Node<String> current1 = list1.head;
    Node<String> current2 = list2.head;

    while (current1 != null && current2 != null) {

      String lowercaseCurrent1 = current1.data.toLowerCase();
      String lowercaseCurrent2 = current2.data.toLowerCase();
      if (!lowercaseCurrent1.equals(lowercaseCurrent2)) {
        return false;
      }
      current1 = current1.next;
      current2 = current2.next;
    }
    return true;
  }
  
  public static void main(String[] args) {
    LinkedListADT<String> list1 = new LinkedListADT<>();
    LinkedListADT<String> list2 = new LinkedListADT<>();

    // Insert words into the first sentence
    list1.insertAtEnd("Helloo");
    list1.insertAtEnd("World");
    list1.insertAtEnd("Java");

    // Insert words into the second sentence
    list2.insertAtEnd("helloo");
    list2.insertAtEnd("world");
    list2.insertAtEnd("java");

    // Compare the two sentences
    boolean areEqual = compareSentences(list1, list2);
    if (areEqual) {
      System.out.println("The sentences are equal.");
    } else {
      System.out.println("The sentences are not equal.");
    }
  }

  
}
