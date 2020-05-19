//Time Complexity: O(N),Auxiliary Space: O(N), 
package Traversals;

import java.util.Stack;

//A binary tree node 
class Node6 { 

 int data; 
 Node6 left, right; 

 Node6(int item) { 
     data = item; 
     left = right = null; 
 } 
} 

public class PreorderTraversalWithStack { 

 Node6 root; 
   
 void iterativePreorder() 
 { 
     iterativePreorder(root); 
 } 

 // An iterative process to print preorder traversal of Binary tree 
 void iterativePreorder(Node6 node) { 
       
     // Base Case 
     if (node == null) { 
         return; 
     } 

     // Create an empty stack and push root to it 
     Stack<Node6> nodeStack = new Stack<Node6>(); 
     nodeStack.push(root); 

     /* Pop all items one by one. Do following for every popped item 
      a) print it 
      b) push its right child 
      c) push its left child 
      Note that right child is pushed first so that left is processed first */
     while (nodeStack.empty() == false) { 
           
         // Pop the top item from stack and print it 
         Node6 mynode = nodeStack.peek(); 
         System.out.print(mynode.data + " "); 
         nodeStack.pop(); 

         // Push right and left children of the popped node to stack 
         if (mynode.right != null) { 
             nodeStack.push(mynode.right); 
         } 
         if (mynode.left != null) { 
             nodeStack.push(mynode.left); 
         } 
     } 
 } 

 // driver program to test above functions 
 public static void main(String args[]) { 
	 PreorderTraversalWithStack tree = new PreorderTraversalWithStack(); 
     tree.root = new Node6(10); 
     tree.root.left = new Node6(8); 
     tree.root.right = new Node6(2); 
     tree.root.left.left = new Node6(3); 
     tree.root.left.right = new Node6(5); 
     tree.root.right.left = new Node6(2); 
     tree.iterativePreorder(); 

 } 
} 
