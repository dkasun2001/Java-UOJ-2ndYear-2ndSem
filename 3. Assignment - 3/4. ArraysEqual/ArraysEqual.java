// Write a program to check if two arrays are equal (having the same elements in the same order).
public class ArraysEqual {

  public static boolean areArraysEqual(int[] array1, int[] array2) {
    // Check if both arrays are null
    if (array1 == null && array2 == null) {
      throw new IllegalArgumentException("Both arrays cannot be null");
    }
    // Check if either array is null
    if (array1 == null || array2 == null) {
      throw new IllegalArgumentException("One of the arrays is null");
    }
    // Check if lengths are different
    if (array1.length != array2.length) {
      throw new IllegalArgumentException("Arrays are of different lengths");
    }
    // Compare elements of both arrays
    for (int i = 0; i < array1.length; i++) {
      if (array1[i] != array2[i]) {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    int[] array1 = {1, 2, 3, 4, 5};
    int[] array2 = {1, 2, 3, 4, 5};
    int[] array3 = {1, 2, 3, 4, 6};

    System.out.println("Are array1 and array2 equal? " + areArraysEqual(array1, array2));
    System.out.println("Are array1 and array3 equal? " + areArraysEqual(array1, array3));
  }
}
