//Time Complexity=O(n),Auxiliary Space: O(1)
package Traversals;

public class NthNodeOfPostorderTraversal 
{
	static int flag = 0;  
	  
    // function to find the N-th node in the postorder  
    // traversal of a given binary tree  
    public static void NthPostordernode(Node4 root, int N)  
    {  
    
        if (root == null)  
            return;  
    
        if (flag <= N)  
        {    
            // left recursion  
            NthPostordernode(root.left, N);  
            // right recursion  
            NthPostordernode(root.right, N);  
            flag++;  
            // prints the n-th node of postorder traversal  
            if (flag == N)  
                System.out.print(root.data); 
        }  
    }  
  
  
    public static void main(String args[]) { 
        Node4 root = new Node4(25);  
        root.left = new Node4(20);  
        root.right = new Node4(30);  
        root.left.left = new Node4(18);  
        root.left.right = new Node4(22);  
        root.right.left = new Node4(24);  
        root.right.right = new Node4(32);  
    
        int N = 6;  
    
        // prints n-th node found  
        NthPostordernode(root, N); 
    } 
} 
  
/* A binary tree node structure */
class Node4 
{  
    int data;  
    Node4 left, right;  
    Node4(int data) 
    { 
        this.data=data; 
    } 
}
