//Time Complexity: O(n),Space Complexity: O(n)
package Traversals;

import java.util.LinkedList;
import java.util.Queue;

/* Class to represent Tree node */
class Node2 { 
    int data; 
    Node2 left, right; 
  
    public Node2(int item) { 
        data = item; 
        left = null; 
        right = null; 
    } 
} 
  
/* Class to print Level Order Traversal */
public class LevelOrderTraversal { 
  
    Node2 root; 
  
    /* Given a binary tree. Print its nodes in level order 
     using array for implementing queue  */
    void printLevelOrder()  
    { 
        Queue<Node2> queue = new LinkedList<Node2>(); 
        queue.add(root); 
        while (!queue.isEmpty())  
        { 
  
            /* poll() removes the present head. 
            For more information on poll() visit  
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node2 tempNode = queue.poll(); 
            System.out.print(tempNode.data + " "); 
  
            /*Enqueue left child */
            if (tempNode.left != null) { 
                queue.add(tempNode.left); 
            } 
  
            /*Enqueue right child */
            if (tempNode.right != null) { 
                queue.add(tempNode.right); 
            } 
        } 
    } 
  
    public static void main(String args[])  
    { 
        /* creating a binary tree and entering  
         the nodes */
        LevelOrderTraversal tree_level = new LevelOrderTraversal(); 
        tree_level.root = new Node2(1); 
        tree_level.root.left = new Node2(2); 
        tree_level.root.right = new Node2(3); 
        tree_level.root.left.left = new Node2(4); 
        tree_level.root.left.right = new Node2(5); 
  
        System.out.println("Level order traversal of binary tree is - "); 
        tree_level.printLevelOrder(); 
    } 
}
