// Write a program to find the second largest element in an array.

public class FindSecondLargest {

  public static int findSecondLargest(int[] arr){
    if (arr == null || arr.length < 2) {
      throw new IllegalArgumentException("Array must contain at least 2 elements");
    }
    
    int largest = 0;
    int secondLargest = 0; 
    
    for (int num : arr) {
      if (num > largest) {
        secondLargest = largest;
        largest = num;
      } else if (num > secondLargest && num != largest) {
        secondLargest = num;
      }
    }
    
    if (secondLargest == 0) {
      throw new IllegalArgumentException("All elements in the array are the same");
    }
    
    return secondLargest;
  }
  public static void main(String[] args) {
    int[] numbers = {12, 35, 1, 10, 34, 1};
    System.out.println("The second largest element is: " + findSecondLargest(numbers));
  }
  
}