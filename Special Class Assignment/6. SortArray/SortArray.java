/* Sort Array List.
Write a Java program to sort a given array list. */
import java.util.ArrayList;

public class SortArray {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(8);
        arrayList.add(1);
        arrayList.add(4);

        System.out.println("Original ArrayList: " + arrayList);

        // Sort the ArrayList
        arrayList.sort(null); // Using natural ordering

        System.out.println("Sorted ArrayList: " + arrayList);
    }
}
