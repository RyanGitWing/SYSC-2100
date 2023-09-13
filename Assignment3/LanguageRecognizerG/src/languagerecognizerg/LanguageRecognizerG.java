/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languagerecognizerg;

import java.io.*;

/**
 *
 * @author Ryan Nguyen
 * @version 03/03/2020
 */
public class LanguageRecognizerG {

    String word;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

        String input = new String();

        try {

            while (true) {

                System.out.print("Enter the G-Language word to check: ");
                input = keyboardReader.readLine();
                break;

            }
        } catch (IOException e) {

            System.out.println(e);

        }

        LanguageRecognizerG w1 = new LanguageRecognizerG(input);
        w1.recursivePrintG();

    }
    
    
    /**
     * Constructor for LanguageRecognizerG.
     * 
     * @param input the word inputed by the user
     */
    private LanguageRecognizerG(String input) {

    word = input;

    }
    
    /**
     * Determine whether or not the word entered by the user is a G-language word.
     * 
     * @param word the word being evaluated
     * @return true or false if the word matches the requirement to be a G-language word
     */
    private boolean recursiveRecogG(String word) {

        int wrd = word.length();

        if (wrd == 0)
            return true;

        else if (wrd == 1)
            return recogE(word.charAt(0));

        else if (wrd == 2)
            return recogV(word.charAt(0)) && recogE(word.charAt(1));

        else if (wrd >= 3)
            return recogE(word.charAt(0)) && recursiveRecogG(word.substring(1, wrd - 1)) && recogV(word.charAt(wrd - 1));

        return false;

    }
    
    /**
     * Determine if the character is & or # for the G-language word.
     * 
     * @param c character to evaluate as & or #
     * @return true if the c is & or # if not than false
     */
    private boolean recogE(char c) {

        if (c == '&' || c == '#')
            return true;

        return false;

    }
    
    /**
     * Determine if the character is W or A for the G-language word.
     * 
     * @param c character to evaluate as W or A
     * @return true if the c is W or A if not than false
     */
    private boolean recogV(char c) {

        if (c == 'W' || c == 'A')
            return true;

        return false;

    }
    
    /**
     * Print statement.
     */
    private void recursivePrintG() {
        if (recursiveRecogG(word))
            System.out.println("Recursion: Word " + word + " IS a word of the G language.");
        else
            System.out.println("Recursion: Word " + word + " is NOT a word of the G language.");
    }
}
