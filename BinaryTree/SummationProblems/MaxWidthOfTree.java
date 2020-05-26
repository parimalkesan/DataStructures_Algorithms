//time comp=O(n)
package SummationProblems;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfTree 
{
	/* A binary tree node has data, pointer to  
    left child and a pointer to right child */
 static class node  
 { 
     int data; 
     node left, right; 

     public node(int data)  
     { 
         this.data = data; 
     } 
 } 

 // Function to find the maximum width of  
 // the tree using level order traversal 
 static int maxwidth(node root)  
 { 
     // Base case 
     if (root == null) 
         return 0; 
       
     // Initialize result 
     int maxwidth = 0; 
       
     // Do Level order traversal keeping  
     // track of number of nodes at every level 
     Queue<node> q = new LinkedList<>(); 
     q.add(root); 
     while (!q.isEmpty())  
     { 
         // Get the size of queue when the level order 
         // traversal for one level finishes 
         int count = q.size(); 
           
         // Update the maximum node count value 
         maxwidth = Math.max(maxwidth, count); 
           
         // Iterate for all the nodes in  
         // the queue currently 
         while (count-- > 0)  
         { 
             // Dequeue an node from queue 
             node temp = q.remove(); 
           
             // Enqueue left and right children  
             // of dequeued node 
             if (temp.left != null)  
             { 
                 q.add(temp.left); 
             } 
             if (temp.right != null)  
             { 
                 q.add(temp.right); 
             } 
         } 
     } 
     return maxwidth; 
 } 

 public static void main(String[] args)  
 { 
     node root = new node(1); 
     root.left = new node(2); 
     root.right = new node(3); 
     root.left.left = new node(4); 
     root.left.right = new node(5); 
     root.right.right = new node(8); 
     root.right.right.left = new node(6); 
     root.right.right.right = new node(7); 

             /*   Constructed Binary tree is: 
             1 
           /   \ 
         2      3 
       /  \      \ 
      4    5      8 
                /   \ 
               6     7    */
                 
     System.out.println("Maximum width = " + maxwidth(root)); 
 } 

}
