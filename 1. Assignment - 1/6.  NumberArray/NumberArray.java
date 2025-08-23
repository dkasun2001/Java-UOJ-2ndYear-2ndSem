
/*  
  Write a program that generates an array of numbers getting from user. Implement
methods to search for a specific number in the array and return its index, and to sort the
array in ascending order using a sorting algorithm of your choice. Test both methods with
appropriate input and display the results
  Example:
  Input: [5, 3, 8, 1, 2]
  Search for: 3
  Output: Index of 3 is 1
  Sorted array: [1, 2, 3, 5, 8]
*/
import java.util.Arrays;
import java.util.Scanner;

public class NumberArray {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Input the size of the array
    System.out.print("Enter the number of elements in the array: ");
    int n = input.nextInt();
    int[] numbers = new int[n];
    System.out.println("Enter the elements of the array:");

    // Input the elements of the array
    for (int i = 0; i < n; i++) {
      numbers[i] = input.nextInt();
    }

    System.out.print("Enter the number to search for: ");
    int searchNumber = input.nextInt();

    // search for specific number
    for (int i = 0; i < n; i++) {
      if (numbers[i] == searchNumber) {
        System.out.println("Index of " + searchNumber + " is " + i);
        break;
      } else {
        if (i == n - 1) {
          System.out.println(searchNumber + " not found in the array.");
        }
      }

    }

    // Sort the array in ascending order
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (numbers[j] > numbers[j + 1]) {
          // swap numbers[j] and numbers[j+1]
          int temp = numbers[j];
          numbers[j] = numbers[j + 1];
          numbers[j + 1] = temp;
        }
      }
    }
    System.out.println("Sorted array: " + Arrays.toString(numbers));
    input.close();

  }
}
