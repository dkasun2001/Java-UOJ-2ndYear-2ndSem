/* Extract Sub list from Array List. 
Write a Java program to extract a portion of an array list. */

import java.util.ArrayList;

public class ExtractSubList{
  public static void main(String[] args) {
    ArrayList<Integer> arrayList = new ArrayList<>();
    
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    arrayList.add(5);

    // Extract a sublist from the original list
    ArrayList<Integer> subList = new ArrayList<>(arrayList.subList(1, 4)); // Extract elements from index 1 to 3

    // Display lists
    System.out.println("Original ArrayList: " + arrayList);
    System.out.println("Sublist: " + subList);
  }
}