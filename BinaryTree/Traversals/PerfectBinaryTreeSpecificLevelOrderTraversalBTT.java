package Traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* A binary tree node has data, pointer to left child 
and a pointer to right child */
class Node8  
{ 
 int data; 
 Node8 left, right; 

 public Node8(int data)  
 { 
     this.data = data; 
     left = right = null; 
 } 
} 

public class PerfectBinaryTreeSpecificLevelOrderTraversalBTT  
{ 
 Node8 root; 

 void printSpecificLevelOrderUtil(Node8 root, Stack<Node8> s)  
 { 
     if (root == null) 
         return; 

     // Create a queue and enqueue left and right 
     // children of root 
     Queue<Node8> q = new LinkedList<Node8>(); 

     q.add(root.left); 
     q.add(root.right); 

     // We process two nodes at a time, so we 
     // need two variables to store two front 
     // items of queue 
     Node8 first = null, second = null; 

     // traversal loop 
     while (!q.isEmpty())  
     { 
         // Pop two items from queue 
         first = q.peek(); 
         q.poll(); 
         second = q.peek(); 
         q.poll(); 

         // Push first and second node's chilren 
         // in reverse order 
         s.push(second.left); 
         s.push(first.right); 
         s.push(second.right); 
         s.push(first.left); 

         // If first and second have grandchildren, 
         // enqueue them in specific order 
         if (first.left.left != null)  
         { 
             q.add(first.right); 
             q.add(second.left); 
             q.add(first.left); 
             q.add(second.right); 
         } 
     } 
 } 

 /* Given a perfect binary tree, print its nodes in 
    specific level order */
 void printSpecificLevelOrder(Node8 root)  
 { 
     //create a stack and push root 
     Stack<Node8> s = new Stack<Node8>(); 

     //Push level 1 and level 2 nodes in stack 
     s.push(root); 

     // Since it is perfect Binary Tree, right is 
     // not checked 
     if (root.left != null)  
     { 
         s.push(root.right); 
         s.push(root.left); 
     } 

     // Do anything more if there are nodes at next 
     // level in given perfect Binary Tree 
     if (root.left.left != null) 
         printSpecificLevelOrderUtil(root, s); 

     // Finally pop all Nodes from stack and prints 
     // them. 
     while (!s.empty())  
     { 
         System.out.print(s.peek().data + " "); 
         s.pop(); 
     } 
 } 

 // Driver program to test the above functions 
 public static void main(String[] args)  
 { 
	 PerfectBinaryTreeSpecificLevelOrderTraversalBTT tree = new PerfectBinaryTreeSpecificLevelOrderTraversalBTT(); 
     tree.root = new Node8(1); 
     tree.root.left = new Node8(2); 
     tree.root.right = new Node8(3); 

     tree.root.left.left  = new Node8(4); 
     tree.root.left.right = new Node8(5); 
     tree.root.right.left  = new Node8(6); 
     tree.root.right.right = new Node8(7); 

     tree.root.left.left.left  = new Node8(8); 
     tree.root.left.left.right  = new Node8(9); 
     tree.root.left.right.left  = new Node8(10); 
     tree.root.left.right.right  = new Node8(11); 
     tree.root.right.left.left  = new Node8(12); 
     tree.root.right.left.right  = new Node8(13); 
     tree.root.right.right.left  = new Node8(14); 
     tree.root.right.right.right  = new Node8(15); 

     tree.root.left.left.left.left  = new Node8(16); 
     tree.root.left.left.left.right  = new Node8(17); 
     tree.root.left.left.right.left  = new Node8(18); 
     tree.root.left.left.right.right  = new Node8(19); 
     tree.root.left.right.left.left  = new Node8(20); 
     tree.root.left.right.left.right  = new Node8(21); 
     tree.root.left.right.right.left  = new Node8(22); 
     tree.root.left.right.right.right  = new Node8(23); 
     tree.root.right.left.left.left  = new Node8(24); 
     tree.root.right.left.left.right  = new Node8(25); 
     tree.root.right.left.right.left  = new Node8(26); 
     tree.root.right.left.right.right  = new Node8(27); 
     tree.root.right.right.left.left  = new Node8(28); 
     tree.root.right.right.left.right  = new Node8(29); 
     tree.root.right.right.right.left  = new Node8(30); 
     tree.root.right.right.right.right  = new Node8(31); 
   
     System.out.println("Specific Level Order Traversal "
             + "of Binary Tree is "); 
     tree.printSpecificLevelOrder(tree.root); 
 } 

}
