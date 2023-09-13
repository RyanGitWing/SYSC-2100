/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacklistbased;

import java.util.LinkedList;
/**
 *
 * @author Ryan Nguyen
 * @version
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

        items.clear();

    }

    /**
     * Check if list is empty.
     */
    public boolean isEmpty(){

        return items.isEmpty();

    }

    /**
     * Pushes an element to the top of the list
     */
    public void push(Object o){

        items.push(o);

    }

    /**
     * Remove and return the first element of the list.
     */
    public Object pop(){

        return items.pop();

    }

    /**
     * Gets the first element of the list but does not remove.
     */
    public Object peek(){

        return items.peek();

    }
}
