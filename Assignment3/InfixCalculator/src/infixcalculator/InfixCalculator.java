/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infixcalculator;

import java.io.*;

/**
 *
 * @author Ryan Nguyen
 * @version 03/03/2020
 */
public class InfixCalculator {


    private StackListBased aStack = new StackListBased();

    private String expression;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

        String input = new String();


        try {
            while (true) {
                System.out.print("Enter the infix expression to evaluate: ");
                input = keyboardReader.readLine();
                break;
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        InfixCalculator w2 = new InfixCalculator(input);
        w2.evaluateInfix();
    }

    /**
     * Constructor for InfixCalculator.
     *
     * @param input infix expression.
     */
    public InfixCalculator(String input){

        expression = input;
    }

    /**
     * Converts infix expression into postfix expression.
     *
     * @param infix infix expression
     * @return returns a postfix expression
     */
    public String convertPostfix(String infix) {

        aStack.createStack();

        String postfixExp = "";

        for (int i = 0; i < infix.length(); i++) {

        switch (infix.charAt(i)) {

            case '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9':
                postfixExp += infix.charAt(i);
                break;

            case '(':
                aStack.push(infix.charAt(i));
                break;

            case ')':
                while (!aStack.peek().equals('(')) {
                postfixExp += aStack.pop();
            }
                aStack.pop();
                break;

            case '+' | '-' | '*' | '/':
                while (!aStack.isEmpty() && !aStack.peek().equals('(') && getOperator(infix.charAt(i)) <= getOperator((Character)aStack.peek())) {
                postfixExp += aStack.pop();
            }
                aStack.push(infix.charAt(i));
                break;

        }
    }

        while (!aStack.isEmpty()) {
            postfixExp += aStack.pop();

        }

        expression = postfixExp;

        return expression;

    }

    /**
     * A method that compares the operators to see which precedes first.
     *
     * @param op an operator
     * @return returns an integer representing the group that the operator belongs to
     */
    private int getOperator(char op) {

        if (op == '+' || op == '-')
           return 1;

        if (op == '*' || op == '/')
           return 2;

        return -1;

    }
    /**
     * Calculates the converter infix expression (postfix expression).
     *
     * @param input postfix expression
     * @return returns the result of the postfix expression
     */
    public int getPostfix(String input) {

        StackListBased calcStack = new StackListBased();
        calcStack.createStack();
        int result;

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '0' || input.charAt(i) == '1' || input.charAt(i) == '2' || input.charAt(i) == '3' || input.charAt(i) == '4' ||
                    input.charAt(i) == '5' || input.charAt(i) == '6' || input.charAt(i) == '7' || input.charAt(i) == '8' || input.charAt(i) == '9') {

                calcStack.push(input.charAt(i));

            } else {

                int num1 = Integer.parseInt((String)calcStack.pop());
                int num2 = Integer.parseInt((String)calcStack.pop());

                switch (input.charAt(i)) {

                    case '+':
                        calcStack.push(num1 + num2);
                        break;

                    case '-':
                        calcStack.push(num1 - num2);
                        break;

                    case '*':
                        calcStack.push(num1 * num2);
                        break;

                    case '/':
                        calcStack.push(num1 / num2);
                        break;
                }
            }
        }

        result = (Integer)calcStack.pop();
        return result;

    }

    /**
     * Print statement.
     */
    private void evaluateInfix() {

        System.out.println("infix: " + expression);
        System.out.println("postfix: " + convertPostfix(expression));
        System.out.println("result: " + getPostfix(expression));
    }



}
