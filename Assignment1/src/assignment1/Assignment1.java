/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author Ryan Nguyen
 * @version 1/30/2019
 */
public class Assignment1 {
    
    /**
     * A recursive method for the Spock problem seen in class.
     * 
     * @param n Number of planet in a solar system.
     * @param k Number of possible planets for exploring.
     * 
     * @return The number of groups of k planets chosen from n.
     */
    public static int c (int n, int k) {
        if (k == 0)
            return 1;
        else if (k == n)
            return 1;
        else if (k == 1)
            return n;
        else if (k > n)
            return 0;
        return c(n-1, k-1) +c (n-1, k);
    }
    
    /**
     * A recursive method for Organizing a Parade problem seen in class.
     * 
     * @param n The length of the parade.
     * 
     * @return The number of acceptable parades of length n.
     */
    public static int P(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 2;
        else if (n == 2)
            return 3;
        return P(n-1) + P(n-2);
    }
    
    /**
     * A recursive method that writes a character repeatedly to form a line of n characters.
     * 
     * @param ch The character that will be printed.
     * @param n  The number of time the character will be printed.
     */
    public static void writeLine (char ch, int n) {
        if (n > 0) {
            System.out.print(ch);
            writeLine(ch, n-1);
        }
    }
    
    /**
     * A recursive method that uses writeLine to write m lines of n characters.
     * 
     * @param ch The character that will be printed.
     * @param n The number of time the character will be printed.
     * @param m The number of time the line of characters will be printed.
     */
    public static void writeBlock (char ch, int n, int m){
        if (m > 0){
            writeLine(ch, n);
            System.out.println("");
            writeBlock(ch, n, m - 1);
        }
    }
    
    /**
     * A recursive method that writes the digits of a positive decimal integer in reverse order.
     * 
     * @param number The number that will be written in reverse.
     */
    public static void reverseDigits(int number){
        if (number > 0){
            System.out.print(number%10);
            reverseDigits(number/10);
        }
    }
    
    /**
     * A recursive method for the binary search algorithm seen in class, but for an array of strings.
     * 
     * @param anArray The array to look through.
     * @param first The first number.
     * @param last The last number.
     * @param value The value being searched for.
     * @return The index of the string in the array. 
     */
    public static int myBinarySearch(String [] anArray, int first, int last, String value){
        int index;
        if (first > last) {
            index = -1;
        } else {
            int mid = (first + last) / 2;
            if (anArray[mid].compareTo(value) > 0) {
                index = myBinarySearch(anArray, first, mid-1, value);
            }
            else if (anArray[mid].compareTo(value) < 0) {
                index = myBinarySearch(anArray, mid+1, last, value);
            }
            else {
                    index = mid;
            }
        }
        return index;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Q1
        System.out.println(c(3,2));
        
        //Q2
        System.out.println(P(4));
        
        //Q3
        writeBlock('*', 5, 3);
        
        //Q4
        reverseDigits(27319);
        System.out.println("");
        
        //Q5
        String arr[] = {"1", "2", "3", "4", "5"};
        System.out.println(myBinarySearch(arr, 0, arr.length, "3"));
    }
}
