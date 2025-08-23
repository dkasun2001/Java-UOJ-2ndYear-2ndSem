/* 
 Write a program that prompts the user to enter a sentence. Split the sentence into words
using the space delimiter and store them in an array. Use a for-each loop to iterate over the
array and print each word in reverse order 
*/
import java.util.Scanner;
import java.util.Arrays;
public class ReverseOrder {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a sentence: ");
    String sentence = input.nextLine();

    // Split the sentence into words using space as a delimiter
    String[] words = sentence.split(" "); 
    

    // Print each word in reverse order using a for-each loop
    System.out.println("Words in reverse order:");
    
    for (String word : words) {
      // Reverse the word
      String reversedWord = new StringBuilder(word).reverse().toString();
      System.out.println(reversedWord);
    

    } 
}}
