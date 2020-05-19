package Traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class PerfectBinaryTreeSpecificLevelOrderTraversalBTTByVector 
{
	/* A binary tree node has data,  
	pointer to left child and  
	a pointer to right child */
	static class Node  
	{  
	    int data;  
	    Node left;  
	    Node right;  
	      
	    /* Helper function that allocates   
	    a new node with the given data and  
	    null left and right pointers. */
	    Node(int value)  
	    {  
	        data = value;  
	        left = null;  
	        right = null;  
	    }  
	};  
	  
	/* Given a perfect binary tree,  
	print its nodes in specific level order */
	static void specific_level_order_traversal(Node root)  
	{  
	    // for level order traversal  
	    Queue <Node> q= new LinkedList<>(); 
	      
	    // Stack to print reverse  
	    Stack <Vector<Integer>> s = new Stack<Vector<Integer>>(); 
	      
	    q.add(root);  
	    int sz;  
	      
	    while(q.size() > 0)  
	    {  
	        // vector to store the level  
	        Vector<Integer> v = new Vector<Integer>();  
	        sz = q.size(); // considering size of the level  
	          
	        for(int i = 0; i < sz; ++i)  
	        {  
	            Node temp = q.peek();  
	            q.remove();  
	              
	            // push data of the node of a  
	            // particular level to vector  
	            v.add(temp.data);  
	              
	            if(temp.left != null)  
	            q.add(temp.left);  
	      
	            if(temp.right != null)  
	                q.add(temp.right);  
	        }  
	          
	        // push vector containg a level in Stack  
	        s.push(v);  
	    }  
	      
	    // print the Stack  
	    while(s.size() > 0)  
	    {  
	        // Finally pop all Nodes from Stack  
	        // and prints them.  
	        Vector <Integer> v = s.peek();  
	        s.pop();  
	        for(int i = 0, j = v.size() - 1; i < j; ++i)  
	            {  
	                System.out.print(v.get(i) + " " +  
	                                 v.get(j) + " ");  
	                j--;  
	            }  
	    }  
	      
	    // finally print root;  
	    System.out.println(root.data);  
	      
	}  
	  
	// Driver code  
	public static void main(String args[]) 
	{  
	    Node root = new Node(1);  
	  
	    root.left = new Node(2);  
	    root.right = new Node(3);  
	  
	    root.left.left = new Node(4);  
	    root.left.right = new Node(5);  
	    root.right.left = new Node(6);  
	    root.right.right = new Node(7);  
	  
	    root.left.left.left = new Node(8);  
	    root.left.left.right = new Node(9);  
	    root.left.right.left = new Node(10);  
	    root.left.right.right = new Node(11);  
	    root.right.left.left = new Node(12);  
	    root.right.left.right = new Node(13);  
	    root.right.right.left = new Node(14);  
	    root.right.right.right = new Node(15);  
	  
	    root.left.left.left.left = new Node(16);  
	    root.left.left.left.right = new Node(17);  
	    root.left.left.right.left = new Node(18);  
	    root.left.left.right.right = new Node(19);  
	    root.left.right.left.left = new Node(20);  
	    root.left.right.left.right = new Node(21);  
	    root.left.right.right.left = new Node(22);  
	    root.left.right.right.right = new Node(23);  
	    root.right.left.left.left = new Node(24);  
	    root.right.left.left.right = new Node(25);  
	    root.right.left.right.left = new Node(26);  
	    root.right.left.right.right = new Node(27);  
	    root.right.right.left.left = new Node(28);  
	    root.right.right.left.right = new Node(29);  
	    root.right.right.right.left = new Node(30);  
	    root.right.right.right.right = new Node(31);
	    System.out.println("Specific Level Order traversal" +  
	                                   " of binary tree is");  
	    specific_level_order_traversal(root);  
	} 

}
