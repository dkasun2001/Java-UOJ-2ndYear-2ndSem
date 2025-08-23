/* Swap words to change meaning of a sentence.
Write a Java program that swaps two words in a linked list and print new sentence. */
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

  public void deleteAtFront() {
    if (isEmpty()) {
      System.out.println("List is empty");
      return;
    } else {
      head = head.next;
    }
  }

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

  public void swapWords(T word1, T word2) {
    if (isEmpty()) {
      System.out.println("List is empty");
      return;
    }

    Node<T> current = head;
    Node<T> node1 = null;
    Node<T> node2 = null;

    // Find the nodes containing the words to swap
    while (current != null) {
      if (current.data.equals(word1)) {
        node1 = current;
      }
      if (current.data.equals(word2)) {
        node2 = current;
      }
      current = current.next;
    }

    // If both nodes are found, swap their data
    if (node1 != null && node2 != null) {
      T temp = node1.data;
      node1.data = node2.data;
      node2.data = temp;
    } else {
      System.out.println("One or both words not found");
    }
  }
}

public class SwapWords {
  public static void main(String[] args) {
    LinkedListADT<String> list = new LinkedListADT<>();
    list.insertAtEnd("Hello");
    list.insertAtEnd("World");
    list.insertAtEnd("Java");
    list.insertAtEnd("Programming");

    System.out.println("Original List:");
    list.printList();

    list.swapWords("World", "Java");

    System.out.println("List After Swapping:");
    list.printList();
  }
}
