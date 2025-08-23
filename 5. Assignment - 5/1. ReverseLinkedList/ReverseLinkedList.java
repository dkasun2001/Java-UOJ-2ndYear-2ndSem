//Using doubly linked list ADT operations, Reverse a linked list and display the elements.

class Node {
  int data;
  Node next;
  Node prev;

  public Node(int data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

class DoublyLinkedList {
  private Node head;
  private Node tail;
  private int size;

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  // Insert at the end
  public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
    size++;
  }

  // Insert at the beginning
  public void insertAtBeginning(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
    size++;
  }

  // Insert at the given index
  public void insertAtIndex(int index, int data) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    if (index == 0) {
      insertAtBeginning(data);
      return;
    }
    if (index == size) {
      insertAtEnd(data);
      return;
    }

    Node newNode = new Node(data);
    Node current = head;
    for (int i = 0; i < index - 1; i++) {
      current = current.next;
    }
    newNode.next = current.next;
    newNode.prev = current;
    if (current.next != null) {
      current.next.prev = newNode;
    }
    current.next = newNode;
    size++;
  }

  // Delete a node with given data
  public boolean delete(int data) {
    if (head == null)
      return false;

    Node current = head;
    while (current != null && current.data != data) {
      current = current.next;
    }

    if (current == null)
      return false;

    if (current == head && current == tail) {
      head = tail = null;
    } else if (current == head) {
      head = head.next;
      head.prev = null;
    } else if (current == tail) {
      tail = tail.prev;
      tail.next = null;
    } else {

      current.prev.next = current.next;
      current.next.prev = current.prev;
    }
    size--;
    return true;
  }

  // Search for an element
  public boolean search(int data) {
    Node current = head;
    while (current != null) {
      if (current.data == data) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  // Get size of the list
  public int getSize() {
    return size;
  }

  // Check if list is empty
  public boolean isEmpty() {
    return head == null;
  }

  // Reverse the doubly linked list
  public void reverse() {
    if (head == null || head.next == null) {
      return;
    }

    Node current = head;
    Node temp = null;

    // Swap next and prev pointers for all nodes
    while (current != null) {
      temp = current.prev;
      current.prev = current.next;
      current.next = temp;
      current = current.prev; // Move to next node (which is now prev)
    }

    // Swap head and tail pointers
    temp = head;
    head = tail;
    tail = temp;
  }

  // Display list from beginning to end
  public void displayForward() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }

    System.out.print("Forward: ");
    Node current = head;
    while (current != null) {
      System.out.print(current.data);
      if (current.next != null) {
        System.out.print(" | ");
      }
      current = current.next;
    }
    System.out.println();
  }

  // Display list from end to beginning
  public void displayBackward() {
    if (tail == null) {
      System.out.println("List is empty");
      return;
    }

    System.out.print("Backward: ");
    Node current = tail;
    while (current != null) {
      System.out.print(current.data);
      if (current.prev != null) {
        System.out.print(" | ");
      }
      current = current.prev;
    }
    System.out.println();
  }
}

public class ReverseLinkedList {
  public static void main(String[] args) {
    DoublyLinkedList dll = new DoublyLinkedList();

    dll.insertAtEnd(10);
    dll.insertAtEnd(20);
    dll.insertAtEnd(30);
    dll.insertAtEnd(40);
    dll.insertAtEnd(50);

    System.out.println("\nInserting element at the beginning:");
    dll.insertAtBeginning(5);
    dll.displayForward();

    System.out.println("\nReversing the doubly linked list:");
    System.out.println("Before reversal:");
    dll.displayForward();

    dll.reverse();

    System.out.println("After reversal:");
    dll.displayForward();
    dll.displayBackward();

  }
}