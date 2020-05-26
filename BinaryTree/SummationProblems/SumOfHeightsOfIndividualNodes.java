//Time Complexity : O(nh) where n is total number of nodes and h is height of binary tree.
package SummationProblems;

public class SumOfHeightsOfIndividualNodes 
{
	/* A binary tree Node has data, pointer to  
    left child and a pointer to right child */
    static class Node 
    { 
        int data; 
        Node left; 
        Node right; 
    }; 
    static int sum; 
  
    /* Helper function that allocates a new Node with the  
    given data and null left and right pointers. */
    static Node newNode(int data) 
    { 
        Node Node = new Node(); 
        Node.data = data; 
        Node.left = null; 
        Node.right = null; 
  
        return (Node); 
    } 
  
    /* Function to sum of heights of individual Nodes  
    Uses Inorder traversal */
    static int getTotalHeightUtil(Node root)  
    { 
        if (root == null)  
        { 
            return 0; 
        } 
  
        int lh = getTotalHeightUtil(root.left); 
        int rh = getTotalHeightUtil(root.right); 
        int h = Math.max(lh, rh) + 1; 
  
        sum = sum + h; 
        return h; 
    } 
  
    static int getTotalHeight(Node root)  
    { 
        sum = 0; 
        getTotalHeightUtil(root); 
        return sum; 
    } 
  
    // Driver code  
    public static void main(String[] args)  
    { 
        Node root = newNode(1); 
  
        root.left = newNode(2); 
        root.right = newNode(3); 
        root.left.left = newNode(4); 
        root.left.right = newNode(5); 
        System.out.printf("Sum of heights of all Nodes = %d", 
                                       getTotalHeight(root)); 
    } 

}
