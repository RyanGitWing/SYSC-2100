/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btsdictionary;

/**
 *
 * @author Ryan Nguyen
 * @version 04/01/2020
 */
public class BTSDictionary <E, K extends Sortable> implements Dictionary 
{
    
    private BTSNode<E, K> currNode;
    private BTSNode<E, K> root = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }
    
    /**
     *  Search through the tree for a specific key.
     * 
     * @param key The key being searched.
     * @return Return null if the key is not found, else the element.
     */
    @Override
    public Object search(Sortable key) 
    {
        // if the tree is empty or we reached the end of the search return null
        if (currNode == null) {
            
            currNode = root;
            return null;
        
        // if the current node is the the one being searched return its element
        } else if (currNode.getKey().compareTo(key) == 0) {
            
            BTSNode<E, K> trgt = new BTSNode(currNode.getKey(), currNode.getElement(), currNode.getLeft(), currNode.getRight());
            currNode = root;
            return trgt.getElement();
        
        // if the current node is larger than the key check, move to left and recursive
        // if the current node is smaller than the key check right and recursive
        } else if (currNode.getKey().compareTo(key) > 0) {
            
            currNode = currNode.getLeft();
            return search(key);
            
        } else {
            
            currNode = currNode.getRight();
            return search(key);
            
        }
    }
    
    /**
     *  Print the BST.
     * 
     * @param curr The current node.
     * @return Return the tree as a string.
     */
    public void treePrint(BTSNode<E, K> curr) 
    {
        
        if (curr == null)
            return;
        
        treePrint(curr.getLeft());
        System.out.print(curr.getKey() + " ");
        treePrint(curr.getRight());
        
    }
    
    /**
     * Get the height of the tree. 
     * 
     * @param curr The current node.
     * @return Return 0 if the tree is empty, else the height of the tree.
     */
    public int treeDepth(BTSNode<E, K> curr) 
    {
        
        if (curr == null)
            return 0;
        
        else {
            
            // compare the depth of each subtree
            int leftSub = treeDepth(curr.getLeft());
            int rightSub = treeDepth(curr.getRight());
            
            // return the largest branch
            if (rightSub < leftSub) {
                
                return leftSub + 1;
                
            } else 
                
                return rightSub + 1;
        }
    }
    
    /**
     *  Add an item to a location by indicated by the key.
     * 
     * @param key Location of where to be inserted.
     * @param newItem The element to be inserted.
     */
    @Override
    public void insert(Sortable key, Object newItem) 
    {
        
        BTSNode<E, K> tmp = new BTSNode<>((SortableString) key, (String) newItem, null, null);
        
        // check if tree is empty, if so insert element at root of tree
        if (root == null) {
            
            root = tmp;
            currNode = root;
            
        }
        
        // local variable that compares the node being evaluated to the new item
        int comp = currNode.getKey().compareTo(tmp.getKey()); 
            
        // if the current node is larger than the new item and left is empty set it to left
        // else recursive and evaluate from the left of the current
        if (comp > 0) {
                
            if (currNode.getLeft() == null) {
                    
                currNode.setLeft(tmp);
                currNode = root;
                    
            } else {
                    
                currNode = currNode.getLeft();
                insert(key, newItem);
                    
            }
            
        // if the current node is smaller than the new item and right is empty set it to right
        // else recursive and evaluate from the right of the current   
        } else if (comp < 0) {
                
            if (currNode.getRight() == null) {
                    
                currNode.setRight(tmp);
                currNode = root;
                    
            } else {
                    
                currNode = currNode.getRight();
                insert(key, newItem);
                    
            }
        }
    }
    
    /**
     *  Removing an element at a specific location indicated by the key.
     * 
     * @param key The location where the element is to be remove.
     */
    @Override
    public void delete(Sortable key) 
    {
        
        BTSNode<E, K> curr = root;
        BTSNode<E, K> prnt = null;
        BTSNode<E, K> trgt = null;
        
        if (curr == null) 
            return;
        
        
            while (curr != null && curr.key != key) {
                
                prnt = curr;

                if (key.compareTo(curr.getKey()) > 0) {
                    
                    curr = curr.getRight();

                } else {

                    curr = curr.getLeft();

                }
            }
        
            
            if (curr.getLeft() != null && curr.getRight() != null) {
                
                BTSNode<E, K> tmp = findMin(trgt.getRight());
                trgt = tmp;
                delete(tmp.key);
                curr.key = trgt.key;
                
            } else if (curr.getLeft() != null && curr.getRight() == null) {
                
                prnt.setLeft(curr.getLeft());

                
            } else if (curr.getLeft() == null && curr.getRight() != null) {
                
                prnt.setRigt(curr.getRight());

                
            } else {
                
                if (prnt.getLeft() == curr) {
                    
                    prnt.setLeft(null);
                    
                } else {
                    
                    prnt.setRight(null);
                }
                
            }

    }
    
    /**
     *  A method that prints the tree.
     */
    @Override
    public void printTree() 
    {
        
        System.out.println(treePrint(root));
        
    }
    
    /**
     *  A method that gives the height of the tree.
     * 
     * @return Return the height of the tree.
     */
    @Override
    public int depth() 
    {
     
        return treeDepth(root);
        
    }
    
    /**
     *  Finding the minimum value in a branch at the leftmost.
     * 
     * @param curr The current node being evaluated.
     * @return Return the minimum value.
     */
    public BTSNode<E, K> findMin(BTSNode<E, K> curr)
    {
        BTSNode<E, K> tmp = curr;
        
        while (tmp.getLeft() != null) {
            
            tmp = tmp.getLeft();
            
        }
        
        return tmp;
        
    }
}
