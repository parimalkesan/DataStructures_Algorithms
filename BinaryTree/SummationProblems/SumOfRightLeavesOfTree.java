package SummationProblems;

public class SumOfRightLeavesOfTree {
	// sum 
    static int sum = 0; 
      
// node of binary tree  
static class Node 
{  
    int data;  
    Node left, right;  
};  
  
// return new node  
static Node addNode(int data) 
{  
    Node temp = new Node();  
    temp.data = data;  
    temp.left = temp.right = null;  
    return temp; 
}  


// A utility function to check if a given node is leaf or not 
static boolean isLeaf(Node node)  
{ 
    if (node == null) 
        return false; 
    if (node.left == null && node.right == null) 
        return true; 
    return false; 
} 

 // This function returns sum of all left leaves in a given 
 // binary tree 
static int rightLeafSum(Node node)  
{ 
    // Initialize result 
    int res = 0; 

    // Update result if root is not NULL 
    if (node != null)  
    { 
        // If left of root is NULL, then add key of 
        // left child 
        if (isLeaf(node.right)) 
            res += node.right.data; 
        else // Else recur for left child of root 
            res += rightLeafSum(node.right); 

        // Recur for right child of root and update res 
        res += rightLeafSum(node.left); 
    } 

    // return result 
    return res; 
} 
 
  
// Driver Code 
public static void main(String args[]) 
{  
      
    //contruct binary tree  
    Node root = addNode(1);  
    root.left = addNode(2);  
    root.left.left = addNode(4);  
    root.left.right = addNode(5);  
    root.left.left.right = addNode(2);  
    root.right = addNode(3);  
    root.right.right = addNode(8);  
    root.right.right.left = addNode(6);  
    root.right.right.right = addNode(7);  
      
    // variable to store sum  
    // of right leaves  
    sum = 0;  
    sum=rightLeafSum(root);  
    System.out.println( sum );  
    }  
}
