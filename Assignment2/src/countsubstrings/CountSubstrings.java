/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countsubstrings;

import java.util.*;
import java.io.*;

/**
 *
 * @author Ryan Nguyen
 * @version February 10, 2020
 */
public class CountSubstrings {

    /**
     * @param args the command line arguments
     * @throws IOException throws exception
     */
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the path for the input file: ");
        String filename = scan.nextLine();

        System.out.println("Enter the pattern to look for: ");
        String pattern = scan.nextLine();

        List<Character> pArr = makeList(pattern, "ArrayList");
        List<Character> pLnk = makeList(pattern, "LinkedList");

        long startTime = System.currentTimeMillis();

        int countArrWrd = searchWord(filename, pArr);
        long elapsedArrTime = System.currentTimeMillis() - startTime;

        int countLnkWrd = searchWord(filename, pLnk);
        long elapsedLnkTime = System.currentTimeMillis() - startTime;

        scan.close();

        System.out.println("Using ArrayLists: " + countArrWrd + "matches, derived in " + elapsedArrTime + "milliseconds.");
        System.out.println("Using LinkedLists: " + countLnkWrd + "matches, derived in " + elapsedLnkTime + "milliseconds.");

    }

    /**
     * Create an ArrayList or LinkedList accordingly.
     *
     * @param data the information to be stored in the list
     * @param list the list to be created
     * @return return an ArrayList, LinkedList or null
     */
    public static List<Character> makeList(String data, String list){

        if (list.equals("ArrayList")) {

            ArrayList<Character> array = new ArrayList<Character>();

            for (int i = 0; i < data.length(); i++) {
                array.add(data.charAt(i));
            }
            return array;

        } else if (list.equals("LinkedList")) {

            LinkedList<Character> link = new LinkedList<Character>();

            for (int i = 0; i < data.length(); i++) {
                link.add(data.charAt(i));
            }
            return link;
        }
    return null;
    }

    /**
     * A search engine going through each line of a given text to find a certain pattern.
     *
     * @param filename the name of the file
     * @param o the pattern we will be looking for
     * @return the number of time the pattern is found
     * @throws IOException throws exception
     */
    public static int searchWord(String filename, Object o) throws IOException {

        if ( !(o instanceof ArrayList) && !(o instanceof ArrayList))
            throw new IllegalArgumentException("Invalid type!");

        int count = 0;

        try {

            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String lineReading = reader.readLine();

            while (lineReading != null) {

                StringTokenizer token = new StringTokenizer(lineReading);

                while (token.hasMoreTokens()) {

                    String t = token.nextToken();
                    ArrayList<Character> tokenArray = new ArrayList<Character>();
                    LinkedList<Character> tokenLink = new LinkedList<Character>();

                    for (int i = 0; i < t.length(); i++){
                        tokenArray.add(t.charAt(i));
                        tokenLink.add(t.charAt(i));
                    }
                    
                    if (o instanceof ArrayList && findBrute(tokenArray, (ArrayList<Character>) o) != -1) {
                    count++;
                } else if (o instanceof LinkedList && findBrute(tokenLink, (LinkedList<Character>) o) != -1){
                    count++;
                }
                }

            }

            lineReading = reader.readLine();
            reader.close();

        } catch (IOException e) {
            System.out.print("File or string not found!");
        }
        return count;
    }

    /**
    * Returns the lowest index at which substring pattern begins in text (or
    * else -1).
    */

   private static int findBrute(List<Character> text, List<Character> pattern) {
                   int n = text.size();
                   int m = pattern.size();
                   for (int i = 0; i <= n - m; i++) { // try every starting index
                                                                // within text
                           int k = 0; // k is index into pattern
                           while (k < m && text.get(i + k) == pattern.get(k))
                                   // kth character of pattern matches
                                   k++;
                           if (k == m) // if we reach the end of the pattern,
                                   return i; // substring text[i..i+m-1] is a match
                   }
                   return -1; // search failed
   }

}
