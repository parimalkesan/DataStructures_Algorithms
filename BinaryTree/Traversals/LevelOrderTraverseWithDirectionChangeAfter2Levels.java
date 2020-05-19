//time comp=O(n)
package Traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraverseWithDirectionChangeAfter2Levels 
{
	// A Binary Tree Node 
	static class Node  
	{ 
	    Node left; 
	    int data; 
	    Node right; 
	}; 
	  
	/* Function to print the level order of  
	given binary tree. Direction of printing  
	level order traversal of binary tree changes  
	after every two levels */
	static void modifiedLevelOrder(Node node) 
	{ 
	    // For null root 
	    if (node == null) 
	        return; 
	  
	    if (node.left == null && node.right == null)  
	    { 
	        System.out.print(node.data); 
	        return; 
	    } 
	  
	    // Maintain a queue for normal level order traversal 
	    Queue<Node> myQueue = new LinkedList<>(); 
	  
	    /* Maintain a stack for printing nodes in reverse 
	    order after they are popped out from queue.*/
	    Stack<Node> myStack = new Stack<>(); 
	  
	    Node temp = null; 
	  
	    // sz is used for storing  
	    // the count of nodes in a level 
	    int sz; 
	  
	    // Used for changing the direction 
	    // of level order traversal 
	    int ct = 0; 
	  
	    // Used for changing the direction  
	    // of level order traversal 
	    boolean rightToLeft = false; 
	  
	    // Push root node to the queue 
	    myQueue.add(node); 
	  
	    // Run this while loop till queue got empty 
	    while (!myQueue.isEmpty())  
	    { 
	        ct++; 
	  
	        sz = myQueue.size(); 
	  
	        // Do a normal level order traversal 
	        for (int i = 0; i < sz; i++) 
	        { 
	            temp = myQueue.peek(); 
	            myQueue.remove(); 
	  
	            /*For printing nodes from left to right, 
	            simply print the nodes in the order in which 
	            they are being popped out from the queue.*/
	            if (rightToLeft == false)  
	                System.out.print(temp.data + " ");          
	  
	            /* For printing nodes from right to left, 
	            push the nodes to stack instead of printing them.*/
	            else
	                myStack.push(temp);          
	  
	            if (temp.left != null) 
	                myQueue.add(temp.left); 
	  
	            if (temp.right != null) 
	                myQueue.add(temp.right); 
	        } 
	  
	        if (rightToLeft == true)  
	        { 
	  
	            // for printing the nodes in order 
	            // from right to left 
	            while (!myStack.isEmpty())  
	            { 
	                temp = myStack.peek(); 
	                myStack.pop(); 
	  
	                System.out.print(temp.data + " "); 
	            } 
	        } 
	  
	        /*Change the direction of printing 
	        nodes after every two levels.*/
	        if (ct == 2)  
	        { 
	            rightToLeft = !rightToLeft; 
	            ct = 0; 
	        } 
	  
	        System.out.print("\n"); 
	    } 
	} 
	  
	// Utility function to create a new tree node 
	static Node newNode(int data) 
	{ 
	    Node temp = new Node(); 
	    temp.data = data; 
	    temp.left = temp.right = null; 
	    return temp; 
	} 
	  
	// Driver Code 
	public static void main(String[] args)  
	{ 
	    // Let us create binary tree 
	    Node root = newNode(1); 
	    root.left = newNode(2); 
	    root.right = newNode(3); 
	    root.left.left = newNode(4); 
	    root.left.right = newNode(5); 
	    root.right.left = newNode(6); 
	    root.right.right = newNode(7); 
	    root.left.left.left = newNode(8); 
	    root.left.left.right = newNode(9); 
	    root.left.right.left = newNode(10); 
	    root.left.right.right = newNode(11); 
	    root.right.left.left = newNode(12); 
	    root.right.left.right = newNode(13); 
	    root.right.right.left = newNode(14); 
	    root.right.right.right = newNode(15); 
	    root.left.right.left.left = newNode(16); 
	    root.left.right.left.right = newNode(17); 
	    root.right.left.right.left = newNode(18); 
	    root.right.right.left.right = newNode(19); 
	  
	    modifiedLevelOrder(root); 
	} 

}
