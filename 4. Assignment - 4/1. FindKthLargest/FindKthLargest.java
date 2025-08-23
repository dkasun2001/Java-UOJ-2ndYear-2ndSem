/* Implement a program that finds the kth largest element in an ArrayList of integers. The program should take the ArrayList and the value of k as input and return the kth largest element. If k is greater than the size of the ArrayList or if the ArrayList is empty, the program should return -1.
Note: Don't use additional java packages. */

import java.util.ArrayList;

class FindKthLargest {
    public static int findKthLargest(ArrayList<Integer> nums, int k) {
        if (nums == null || nums.size() == 0 || k <= 0 || k > nums.size()) {
            return -1;
        }

        nums.sort((a, b) -> b - a);

        return nums.get(k - 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(2);
        nums.add(1);
        nums.add(5);
        nums.add(6);
        nums.add(4);

        int k = 2;
        int result = findKthLargest(nums, k);

        System.out.println("The " + k + "th largest element is: " + result);

    }
}