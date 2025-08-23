
/* 
Implement a program that finds the missing number(s)in a given ArrayList of integers.The program should take the ArrayList as input and return an ArrayList containing the missing numbers in ascending order.

For example,given the input ArrayList:[1,3,5,7,9],the program should return[2,4,6,8].Your task is to write a Java program that solves this problem efficiently using ArrayList and basic programming constructs. 
*/
import java.util.ArrayList;

public class FindMissingNums {
  public static void findMissingNumbers(ArrayList<Integer> arrList) {

    if (arrList == null || arrList.size() == 0) {
      System.out.println("No elements.");
    } else {
      ArrayList<Integer> outputArry = new ArrayList<>();

      arrList.sort((a, b) -> a - b);
      System.out.println("Input ArrayList:: " + arrList);

      for (int i = 1; i < arrList.get(arrList.size() - 1); i++) {
        if (!arrList.contains(i)) {
          outputArry.add(i);
        }
      }
      System.out.println("Missing numbers: " + outputArry);
    }
    
  }

  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<>();
    nums.add(1);
    nums.add(3);
    nums.add(5);
    nums.add(7);
    nums.add(9);

    findMissingNumbers(nums);

  }
}
