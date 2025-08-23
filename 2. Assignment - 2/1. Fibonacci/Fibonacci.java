/* Write a recursive function to find the nth Fibonacci number. The Fibonacci sequence is defined as follows: F(0) = 0, F(1) = 1, and F( n ) = F(n-1) + F(n-2) for n > 1. Prompt the user to enter a number and display the corresponding Fibonacci number using recursion. */

import java.util.Scanner;
public class Fibonacci{
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        int result = fibonacci(n);
        System.out.println("Fibonacci number at position " + n + " is: " + result);
        scanner.close();
    }
    
}