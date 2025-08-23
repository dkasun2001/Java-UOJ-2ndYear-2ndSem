
// Write a program that counts the frequency of each element in a String array and prints the results.
import java.util.ArrayList;

public class FrequencyCounter {
  public static void countFrequencies(String[] elements) {
    ArrayList<String> countedElements = new ArrayList<>();

    if (elements == null || elements.length == 0) {
      System.out.println("No elements to count.");
      return;
    }

    for (String element : elements) {
      if (!countedElements.contains(element)) {
        countedElements.add(element);
        int count = 0;
        for (String e : elements) {
          if (e.equals(element)) {
            count++;
          }
        }
        System.out.println("Element: " + element + ", Frequency: " + count);
      }
    }

  }

  public static void main(String[] args) {
    String[] elements = { "apple", "banana", "apple", "orange", "banana", "apple" };
    countFrequencies(elements);
  }

}
