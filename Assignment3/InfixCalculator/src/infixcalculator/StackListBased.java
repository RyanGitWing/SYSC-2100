/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infixcalculator;

import java.util.LinkedList;

import java.lang.Integer;
/**
 *
 * @author Ryan Nguyen
 * @version 03/03/2020
 */
public class StackListBased {

    private LinkedList<Object> items;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    /**
     * Construct for StackListBased().
     */
    public StackListBased() {

        items = new LinkedList<Object>();

    }

    /**
     * Create a stack based linked list.
     */
    public void createStack() {

        new StackListBased();

    }

    /**
     * Clear the list.
     */
    public void popAll(){

        this.items.clear();

    }

    /**
     * Check if list is empty.
     */
    public boolean isEmpty(){

        return this.items.isEmpty();

    }

    /**
     * Pushes an element to the top of the list
     */
    public void push(Object o){

        this.items.push(o);

    }

    /**
     * Remove and return the first element of the list.
     */
    public Object pop(){

        return this.items.pop();

    }

    /**
     * Gets the first element of the list but does not remove.
     */
    public Object peek(){

        return this.items.peek();

    }
}
