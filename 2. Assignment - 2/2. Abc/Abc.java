/* Write a program to generate the below pattern from the input String "abc" using recursive backtracking. 

abc
ab
a
ab
abc */

public class Abc {
    public static void main(String[] args) {
        String str = "abc";
        printPattern(str, str.length() - 1);
    }
    
    public static void printPattern(String str, int index) {
        
        if (index < 0) {
            return;
        }

     
        System.out.println(str.substring(0, index + 1));

        
        printPattern(str, index - 1);

       
        System.out.println(str.substring(0, index + 1));
    }
}