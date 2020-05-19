package Traversals;

import java.util.LinkedList;
import java.util.Queue;

/* Class containing left and right child of current  
node and key value*/
class Node7  
{ 
 int data; 
 Node7 left, right; 

 public Node7(int item)  
 { 
     data = item; 
     left = right = null; 
 } 
} 

public class PerfectBinaryTreeSpecificLevelOrderTraversalTTB  
{ 
 Node7 root; 

 /* Given a perfect binary tree, print its nodes in specific 
    level order */
 void printSpecificLevelOrder(Node7 node)  
 { 
     if (node == null) 
         return; 

     // Let us print root and next level first 
     System.out.print(node.data); 

     //  Since it is perfect Binary Tree, right is not checked 
     if (node.left != null) 
         System.out.print(" " + node.left.data + " " + node.right.data); 

     // Do anything more if there are nodes at next level in 
     // given perfect Binary Tree 
     if (node.left.left == null) 
         return; 

     // Create a queue and enqueue left and right children of root 
     Queue<Node7> q = new LinkedList<Node7>(); 
     q.add(node.left); 
     q.add(node.right); 

     // We process two nodes at a time, so we need two variables 
     // to store two front items of queue 
     Node7 first = null, second = null; 

     // traversal loop 
     while (!q.isEmpty())  
     { 
         // Pop two items from queue 
         first = q.peek(); 
         q.remove(); 
         second = q.peek(); 
         q.remove(); 

         // Print children of first and second in reverse order 
         System.out.print(" " + first.left.data + " " +second.right.data); 
         System.out.print(" " + first.right.data + " " +second.left.data); 

         // If first and second have grandchildren, enqueue them 
         // in reverse order 
         if (first.left.left != null)  
         { 
             q.add(first.left); 
             q.add(second.right); 
             q.add(first.right); 
             q.add(second.left); 
         } 
     } 
 } 

 // Driver program to test for above functions 
 public static void main(String args[])  
 { 
	 PerfectBinaryTreeSpecificLevelOrderTraversalTTB tree = new PerfectBinaryTreeSpecificLevelOrderTraversalTTB(); 
     tree.root = new Node7(1); 
     tree.root.left = new Node7(2); 
     tree.root.right = new Node7(3); 

     tree.root.left.left = new Node7(4); 
     tree.root.left.right = new Node7(5); 
     tree.root.right.left = new Node7(6); 
     tree.root.right.right = new Node7(7); 

     tree.root.left.left.left = new Node7(8); 
     tree.root.left.left.right = new Node7(9); 
     tree.root.left.right.left = new Node7(10); 
     tree.root.left.right.right = new Node7(11); 
     tree.root.right.left.left = new Node7(12); 
     tree.root.right.left.right = new Node7(13); 
     tree.root.right.right.left = new Node7(14); 
     tree.root.right.right.right = new Node7(15); 

     tree.root.left.left.left.left = new Node7(16); 
     tree.root.left.left.left.right = new Node7(17); 
     tree.root.left.left.right.left = new Node7(18); 
     tree.root.left.left.right.right = new Node7(19); 
     tree.root.left.right.left.left = new Node7(20); 
     tree.root.left.right.left.right = new Node7(21); 
     tree.root.left.right.right.left = new Node7(22); 
     tree.root.left.right.right.right = new Node7(23); 
     tree.root.right.left.left.left = new Node7(24); 
     tree.root.right.left.left.right = new Node7(25); 
     tree.root.right.left.right.left = new Node7(26); 
     tree.root.right.left.right.right = new Node7(27); 
     tree.root.right.right.left.left = new Node7(28); 
     tree.root.right.right.left.right = new Node7(29); 
     tree.root.right.right.right.left = new Node7(30); 
     tree.root.right.right.right.right = new Node7(31); 

     System.out.println("Specific Level Order traversal of binary" 
                                                         +"tree is "); 
     tree.printSpecificLevelOrder(tree.root); 
 } 
} 