public class CountOccurrences {
  public static int countOccurrences(int[] arr, int target) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Array must not be null or empty");
    }
    int count = 0;
    for (int num : arr) {
      if (num == target) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 2, 4, 2, 5 };
    int target = 2;
    System.out.println("Count of " + target + " is: " + countOccurrences(arr, target));
  }
}
