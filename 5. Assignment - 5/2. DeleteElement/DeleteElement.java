// Using doubly linked list ADT operations, Deleting a given key from a linked list (which have multi type elements)

class Node<T> {
  T data;
  Node<T> next;
  Node<T> prev;

  public Node(T data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

class DoublyLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void insertAtEnd(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
    size++;
  }

  public boolean delete(T data) {
    if (head == null)
      return false;

    Node<T> current = head;
    while (current != null && !current.data.equals(data)) {
      current = current.next;
    }

    if (current == null) {
      return false;
    }

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

  public void displayForward() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }

    System.out.print("List: ");
    Node<T> current = head;
    while (current != null) {
      System.out.print(current.data);
      if (current.next != null) {
        System.out.print(" | ");
      }
      current = current.next;
    }
    System.out.println();
  }

  public int getSize() {
    return size;
  }
}

public class DeleteElement {
  public static void main(String[] args) {
    DoublyLinkedList<Object> dll = new DoublyLinkedList<>();

    dll.insertAtEnd(10);
    dll.insertAtEnd("Hello");
    dll.insertAtEnd(3.14);
    dll.insertAtEnd('A');
    dll.insertAtEnd("World");
    dll.insertAtEnd(50);

    System.out.println("\nOriginal list:");
    dll.displayForward();
    System.out.println("Size: " + dll.getSize());

    System.out.println("\nDeleting element: 'Hello':");
    dll.delete("Hello");
    dll.displayForward();
    System.out.println("Size: " + dll.getSize());

    System.out.println("\nDeleting element: 3.14:");
    dll.delete(3.14);
    dll.displayForward();
    System.out.println("Size: " + dll.getSize());
  }
}
