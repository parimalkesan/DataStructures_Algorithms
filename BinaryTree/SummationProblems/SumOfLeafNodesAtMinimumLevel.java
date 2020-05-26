//time comp=O(n),Auxiliary space=O(n)
package SummationProblems;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeafNodesAtMinimumLevel 
{
	// structure of a node of binary tree 
	static class Node  
	{ 
	    int data; 
	    Node left, right; 
	}; 
	  
	// function to get a new node 
	static Node getNode(int data) 
	{ 
	    // allocate space 
	    Node newNode = new Node(); 
	  
	    // put in the data 
	    newNode.data = data; 
	    newNode.left = newNode.right = null; 
	    return newNode; 
	} 
	  
	// function to find the sum of 
	// leaf nodes at minimum level 
	static int sumOfLeafNodesAtMinLevel(Node root) 
	{ 
	    // if tree is empty 
	    if (root == null) 
	        return 0; 
	  
	    // if there is only one node 
	    if (root.left == null && 
	        root.right == null) 
	        return root.data; 
	  
	    // queue used for level order traversal 
	    Queue<Node> q = new LinkedList<>(); 
	    int sum = 0;  
	    boolean f = false; 
	  
	    // push root node in the queue 'q' 
	    q.add(root); 
	  
	    while (f == false) 
	    { 
	  
	        // count number of nodes in the 
	        // current level 
	        int nc = q.size(); 
	  
	        // traverse the current level nodes 
	        while (nc-- >0) 
	        { 
	  
	            // get front element from 'q' 
	            Node top = q.peek(); 
	            q.remove(); 
	  
	            // if it is a leaf node 
	            if (top.left == null &&  
	                top.right == null)  
	            { 
	  
	                // accumulate data to 'sum' 
	                sum += top.data; 
	  
	                // set flag 'f' to 1, to signify  
	                // minimum level for leaf nodes  
	                // has been encountered 
	                f = true; 
	            } 
	            else 
	            { 
	  
	                // if top's left and right child  
	                // exists, then push them to 'q' 
	                if (top.left != null) 
	                    q.add(top.left); 
	                if (top.right != null) 
	                    q.add(top.right); 
	            } 
	        } 
	    } 
	  
	    // required sum 
	    return sum; 
	} 
	  
	// Driver Code 
	public static void main(String[] args) 
	{ 
	      
	    // binary tree creation 
	    Node root = getNode(1); 
	    root.left = getNode(2); 
	    root.right = getNode(3); 
	    root.left.left = getNode(4); 
	    root.left.right = getNode(5); 
	    root.right.left = getNode(6); 
	    root.right.right = getNode(7); 
	    root.left.right.left = getNode(8); 
	    root.right.left.right = getNode(9); 
	  
	    System.out.println("Sum = " +  
	           sumOfLeafNodesAtMinLevel(root)); 
	    } 

}
