package SummationProblems;

//A binary tree node 
class Node2  
{ 
 int data; 
 Node2 left, right; 

 Node2(int item)  
 { 
     data = item; 
     left = right; 
 } 
} 

public class DiffBetweenOddAndEvenLevelSums  
{ 
 // The main function that return difference between odd and even level 
 // nodes 
 Node2 root; 

 int getLevelDiff(Node2 node)  
 { 
     // Base case 
     if (node == null) 
         return 0; 

     // Difference for root is root's data - difference for  
     // left subtree - difference for right subtree 
     return node.data - getLevelDiff(node.left) -  
                                           getLevelDiff(node.right); 
 } 

 // Driver program to test above functions 
 public static void main(String args[])  
 { 
	 DiffBetweenOddAndEvenLevelSums tree = new DiffBetweenOddAndEvenLevelSums(); 
     tree.root = new Node2(5); 
     tree.root.left = new Node2(2); 
     tree.root.right = new Node2(6); 
     tree.root.left.left = new Node2(1); 
     tree.root.left.right = new Node2(4); 
     tree.root.left.right.left = new Node2(3); 
     tree.root.right.right = new Node2(8); 
     tree.root.right.right.right = new Node2(9); 
     tree.root.right.right.left = new Node2(7); 
     System.out.println(tree.getLevelDiff(tree.root) +   
                                          " is the required difference"); 

 } 
} 