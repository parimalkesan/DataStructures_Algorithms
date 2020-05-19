//time comp=O(n)
package Traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node5  
{ 
    int data; 
    Node5 left, right; 
   
    Node5(int item)  
    { 
        data = item; 
        left = right; 
    } 
} 
   
class ReverseLevelOrderTraversal 
{ 
    Node5 root; 
   
    /* Given a binary tree, print its nodes in reverse level order */
    void reverseLevelOrder(Node5 node)  
    { 
        Stack<Node5> S = new Stack(); 
        Queue<Node5> Q = new LinkedList(); 
        Q.add(node); 
   
        // Do something like normal level order traversal order.Following 
        // are the differences with normal level order traversal 
        // 1) Instead of printing a node, we push the node to stack 
        // 2) Right subtree is visited before left subtree 
        while (Q.isEmpty() == false)  
        { 
            /* Dequeue node and make it root */
            node = Q.peek(); 
            Q.remove(); 
            S.push(node); 
   
            /* Enqueue right child */
            if (node.right != null) 
                // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT 
                Q.add(node.right);  
                  
            /* Enqueue left child */
            if (node.left != null) 
                Q.add(node.left); 
        } 
   
        // Now pop all items from stack one by one and print them 
        while (S.empty() == false)  
        { 
            node = S.peek(); 
            System.out.print(node.data + " "); 
            S.pop(); 
        } 
    } 
   
    // Driver program to test above functions 
    public static void main(String args[])  
    { 
    	ReverseLevelOrderTraversal tree = new ReverseLevelOrderTraversal(); 
   
        // Let us create trees shown in above diagram 
        tree.root = new Node5(1); 
        tree.root.left = new Node5(2); 
        tree.root.right = new Node5(3); 
        tree.root.left.left = new Node5(4); 
        tree.root.left.right = new Node5(5); 
        tree.root.right.left = new Node5(6); 
        tree.root.right.right = new Node5(7); 
   
        System.out.println("Level Order traversal of binary tree is :"); 
        tree.reverseLevelOrder(tree.root); 
    } 
}
