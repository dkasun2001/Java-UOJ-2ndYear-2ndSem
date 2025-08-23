/* 
Write a program that prints the first 10 multiples of a given number. Prompt the user to
enter a number, and then calculate and display the first 10 multiples of that number.
*/
import java.util.Scanner;
public class FirstTenMultiples {
  public static void main(String[] args){


    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int number = input.nextInt();

    System.out.println("The first 10 multiples of " + number + " are:");

    for (int i = 1; i <= 10; i++) {
      int multiple = number * i;
      System.out.println(number + " x " + i + " = " + multiple);
    }    

    // input.close();
  }
}
