/* Find missing letter in a sequence of consecutive letters. Write a Java program that returns the missing letter from an array of increasing letters(upper or lower). Assume there will always be one omission from the array. */

public class FindMissing {
  public static char findMissingLetter(char[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] + 1 != array[i + 1]) {
        return (char) (array[i] + 1);
      }
    }
    System.out.println("No missing letter found");
    return 0;
  }

  public static void main(String[] args) {
    char[] letters = { 'a', 'b', 'c', 'd', 'f' };
    char missingLetter = findMissingLetter(letters);
    System.out.println("Missing letter: " + missingLetter);
  }

}
