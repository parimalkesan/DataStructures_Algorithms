//time comp=O(n)
package Traversals;

import java.util.Stack;

/* Class containing left and right child of 
current node and key value*/
class Node1 
{ 
    int data; 
    Node1 left, right; 
  
    public Node1(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 
  
/* Class to print the inorder traversal */
public class InorderTraversalWithStack 
{ 
    Node1 root; 
    void inorder() 
    { 
        if (root == null) 
            return; 
  
  
        Stack<Node1> s = new Stack<Node1>(); 
        Node1 curr = root; 
  
        // traverse the tree 
        while (curr != null || s.size() > 0) 
        { 
  
            /* Reach the left most Node of the 
            curr Node */
            while (curr !=  null) 
            { 
                /* place pointer to a tree node on 
                   the stack before traversing 
                  the node's left subtree */
                s.push(curr); 
                curr = curr.left; 
            } 
  
            /* Current must be NULL at this point */
            curr = s.pop(); 
  
            System.out.print(curr.data + " "); 
  
            /* we have visited the node and its 
               left subtree.  Now, it's right 
               subtree's turn */
            curr = curr.right; 
        } 
    } 
  
    public static void main(String args[]) 
    { 
  
        /* creating a binary tree and entering 
        the nodes */
    	InorderTraversalWithStack  tree = new InorderTraversalWithStack (); 
        tree.root = new Node1(1); 
        tree.root.left = new Node1(2); 
        tree.root.right = new Node1(3); 
        tree.root.left.left = new Node1(4); 
        tree.root.left.right = new Node1(5); 
        tree.inorder(); 
    } 
}
