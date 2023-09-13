/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Ryan Nguyen
 * @version 03/20/2020 
 */
public class Assignment4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    /**
     * Recursive method that sorts an array using selection sort.
     * 
     * @param <T> Type of the array. 
     * @param theArray An array to be sorted.
     * @param n The number of elements in the array.
     */
    public static <T extends Comparable <? super T>>
        void recursiveSelectionSort (T[] theArray, int n){
           
            int largest = 0; // Index of the largest item.
            
            if (n == 0) // Base case.
                return;
            
            
            // Find the largest item in the array
            for (int i = 1; i < n; i++) { 
                
                if (theArray[i].compareTo(theArray[largest]) > 0)
                    largest = i;
                
            }
               
            // Swap the largest item with the last.    
            T temp = theArray[largest];
            theArray[largest] = theArray[n - 1];
            theArray[n - 1] = temp;
                

            recursiveSelectionSort(theArray, n - 1);
            
        }
        
    /**
     * Recursive method that sorts an array using bubble sort.
     * 
     * @param <T> Type of the Array.
     * @param theArray An array to be sorted.
     * @param n The number of elements in the array.
     */    
    public static <T extends Comparable <? super T>>
        void recursiveBubbleSort (T[] theArray, int n){
            
            boolean sorted = true;
            
            for (int i = 0; i < n - 1; i++) {
                
                // Compare each element with the following one.
                if (theArray[i].compareTo(theArray[i + 1]) > 0) {
                    
                    // Swap the ith element with the next.
                    T temp = theArray[i];
                    theArray[i] = theArray[i + 1];
                    theArray[i + 1] = temp;
                    sorted = false;
                    
                }
            }
            
            // If the array is still not sorted repeat.
            if (sorted == false) // Base case.
                recursiveBubbleSort(theArray, n - 1);
            
        }
        
    /**
     * Method that checks if a string is part of the language w$w'.
     * 
     * @param str A string to check.
     * @return Return true if the string is in the language.
     */    
    public static boolean isInLanguage (String str) {
        
        Queue<Character> w = new LinkedList<Character>();
        Stack<Character> reverseW = new Stack<Character>();
        int length = str.length();
        
        // An empty string is part of the language.
        if (length == 0 )
            return true;
        
        // A string that is only $ is part of the language since both side are the same opposite.
        if (length == 1 && str.charAt(0) == '$')
            return true;
        
        // If the length of the string is an even number than it is not part of the language.
        if (length % 2 == 0)
            return false;
            
        for (int i = 0; i < length / 2; i++) {
            
            // Add the first half of the string to queue (before $).
            w.add(str.charAt(i));
            // Add the second half of the string to the stack (right after $).
            reverseW.push(str.charAt((length / 2) + 1 + i));
            
        }
        
        // Check to see if the queue and stack are the same size.
        // If not that means they are not the same opposite.
        if (w.size() == reverseW.size()) {
            
            for (int i = 0; i < w.size(); i++) {
                
                // If an element from the queue is not the same as the one from stack, return false.
                if (w.remove() != reverseW.pop())
                    return false;
                
            }
            
            return true;
            
        }
        
        return false;
        
    }
    
    /**
     * Method that converts a string of number into an integer of number without spaces.
     * 
     * @param str A string to convert.
     * @return Return an integer.
     */
    public static int convertToNumber (String str) {
        
        Queue<Integer> aQueue = new LinkedList<Integer>();
        int num = 0;
        
        // If the string is empty or contains only spaces, return 0.
        if (str.isEmpty() || str.trim().isEmpty())
            return num;
        
        // Add the digits to the queue.
        for (int i = 0; i < str.length(); i++) {
            
            if (str.charAt(i) != ' ')
                aQueue.add(Character.getNumericValue(str.charAt(i)));
            
        }
        
        // Add up each element of the queue to get a converted version of the inital string number
        while (!aQueue.isEmpty()) {
            
            num *= 10;
            num += aQueue.remove();
        }
        return num;
    }
    
}
