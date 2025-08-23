// Write a program that sorts the elements in an integer array in ascending order using insertion sorting algorithm.
public class ArrayInsertionSorting {
  public static void insertionSort(int[] array) {
    
    if (array == null) {
      throw new IllegalArgumentException("Array cannot be null");
    }
    
    for (int i = 1; i < array.length; i++) {
      int key = array[i];
      int j = i - 1;
      
      while (j >= 0 && array[j] > key) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = key;
    }
  }

  public static void main(String[] args) {
    int[] array = {5, 2, 9, 1, 5, 6};
    System.out.println("Original Array: ");
    for (int num : array) {
      System.out.print(num + " ");
    }
    
    insertionSort(array);
    
    System.out.println("\nSorted Array: ");
    for (int num : array) {
      System.out.print(num + " ");
    }
  }
}
