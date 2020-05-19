//time comp=O(n),extra space=O(n)
package Traversals;

import java.util.Stack;

//A Binary Tree node 
class Node3 { 
 int data; 
 Node3 left, right; 

 public Node3(int item) 
 { 
     data = item; 
     left = right = null; 
 } 
} 

class LevelOrderTraversalInSpiralForm { 

 static Node3 root; 

 void printSpiral(Node3 node) 
 { 
     if (node == null) 
         return; // NULL check 

     // Create two stacks to store alternate levels 
     // For levels to be printed from right to left 
     Stack<Node3> s1 = new Stack<Node3>();  
     // For levels to be printed from left to right 
     Stack<Node3> s2 = new Stack<Node3>();  

     // Push first level to first stack 's1' 
     s1.push(node); 

     // Keep printing while any of the stacks has some nodes 
     while (!s1.empty() || !s2.empty()) { 
         // Print nodes of current level from s1 and push nodes of 
         // next level to s2 
         while (!s1.empty()) { 
             Node3 temp = s1.peek(); 
             s1.pop(); 
             System.out.print(temp.data + " "); 

             // Note that is right is pushed before left 
             if (temp.right != null) 
                 s2.push(temp.right); 

             if (temp.left != null) 
                 s2.push(temp.left); 
         } 

         // Print nodes of current level from s2 and push nodes of 
         // next level to s1 
         while (!s2.empty()) { 
             Node3 temp = s2.peek(); 
             s2.pop(); 
             System.out.print(temp.data + " "); 

             // Note that is left is pushed before right 
             if (temp.left != null) 
                 s1.push(temp.left); 
             if (temp.right != null) 
                 s1.push(temp.right); 
         } 
     } 
 } 

 public static void main(String[] args) 
 { 
     LevelOrderTraversalInSpiralForm tree = new LevelOrderTraversalInSpiralForm(); 
     tree.root = new Node3(1); 
     tree.root.left = new Node3(2); 
     tree.root.right = new Node3(3); 
     tree.root.left.left = new Node3(7); 
     tree.root.left.right = new Node3(6); 
     tree.root.right.left = new Node3(5); 
     tree.root.right.right = new Node3(4); 
     System.out.println("Spiral Order traversal of Binary Tree is "); 
     tree.printSpiral(root); 
 } 
} 
