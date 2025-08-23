// Write a program to remove duplicate elements from an array.
public class RemoveDuplicate {
  public static int[] removeDuplicates(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Array must not be null or empty");
    }
    int n = arr.length;
    int[] temp = new int[n];
    int j = 0;

    temp[j++] = arr[0];

    for (int i = 1; i < n; i++) {
      boolean isDuplicate = false;

      for (int k = 0; k < j; k++) {
        if (arr[i] == temp[k]) {
          isDuplicate = true;
          break;
        }
      }

      if (!isDuplicate) {
        temp[j++] = arr[i];
      }
    }

    int[] result = new int[j];
    for (int i = 0; i < j; i++) {
      result[i] = temp[i];
    }

    return result;
  }

  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {

    int[] arr = { 1, 2, 3, 2, 4, 1, 5, 3 };
    System.out.println("Original array:");
    printArray(arr);

    int[] result = removeDuplicates(arr);
    System.out.println("Array after removing duplicates:");
    printArray(result);
  }

}