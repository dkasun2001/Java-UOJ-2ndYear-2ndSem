/* 
Write a program that checks whether a given year is a leap year or not. Prompt the user to enter a year, and then determine and display whether it is a leap year or not. 

(A leap year is divisible by 4, but not divisible by 100 unless it is also divisible by 400.)
*/
import java.util.Scanner;
public class LeapYearOrNot {
  public static void main(String[] args){

    // Read input from the user
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a year: ");
    int year = input.nextInt();
    boolean isLeapYear = false;

    // Check if the year is a leap year
    if ((year % 4  == 0 && year % 100 != 0) || year % 400 == 0) {
      isLeapYear = true;
    }

    System.out.println("Is "+year + " Leap Year: " + isLeapYear);

  }
}
