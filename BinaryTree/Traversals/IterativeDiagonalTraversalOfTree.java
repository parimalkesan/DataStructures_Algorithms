package Traversals;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeDiagonalTraversalOfTree 
{
	// A binary tree node has data, pointer to left  
	 //  child and a pointer to right child  
	static class Node {  
	    int data;  
	    Node left, right;  
	};  
	    
	// Helper function that allocates a new node  
	static Node newNode(int data)  
	{  
	    Node node = new Node();  
	    node.data = data;  
	    node.left = node.right = null;  
	    return (node);  
	}  
	    
	// Iterative function to print diagonal view  
	static void diagonalPrint(Node root)  
	{  
	    // base case  
	    if (root == null)  
	        return;  
	    
	    // inbuilt queue of Treenode  
	    Queue<Node> q= new LinkedList<Node>();  
	    
	    // add root  
	    q.add(root);  
	    
	    // add delimiter  
	    q.add(null);  
	    
	    int sum=0;
	    while (q.size()>0) {  
	        Node temp = q.peek();  
	        q.remove();  
	    
	        // if current is delimiter then insert another  
	        // for next diagonal and cout nextline  
	        if (temp == null) {  
	    
	        	System.out.print("sum="+sum);
	        	sum=0;
	            // if queue is empty return  
	            if (q.size()==0)  
	                return;  
	            
	            
	    
	            // output nextline  
	            System.out.println(); 
	    
	            // add delimiter again  
	            q.add(null);  
	        }  
	        else {  
	            while (temp!=null) {  
	                System.out.print( temp.data + " ");  
	                sum=sum+temp.data;
	    
	                // if left child is present   
	                // add into queue  
	                if (temp.left!=null)  
	                    q.add(temp.left);  
	    
	                // current equals to right child  
	                temp = temp.right;  
	            }  
	        }  
	    }  
	}  
	    
	// Driver Code  
	public static void main(String args[]) 
	{  
	    Node root = newNode(8);  
	    root.left = newNode(3);  
	    root.right = newNode(10);  
	    root.left.left = newNode(1);  
	    root.left.right = newNode(6);  
	    root.right.right = newNode(14);  
	    root.right.right.left = newNode(13);  
	    root.left.right.left = newNode(4);  
	    root.left.right.right = newNode(7);  
	    diagonalPrint(root);  
	}  
}
