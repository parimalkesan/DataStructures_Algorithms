//time comp=O(n)
package SummationProblems;

class Node1 { 
    int data; 
    Node1 left, right; 
  
    // Constructor 
    public Node1(int data) 
    { 
        this.data = data; 
        this.left = null; 
        this.right = null; 
    } 
} 
  
public class SumOfMaxDepthNodes  { 
  
    // function to find the sum of nodes at 
    // maximum depth arguments are node and 
    // max, where max is to match the depth 
    // of node at every call to node, if 
    // max will be equal to 1, means 
    // we are at deepest node. 
    public static int sumMaxLevelRec(Node1 node, 
                     int max) 
    { 
        // base case 
        if (node == null)  
            return 0;      
  
        // max == 1 to track the node 
        // at deepest level 
        if (max == 1)  
            return node.data;     
  
        // recursive call to left and right nodes 
        return sumMaxLevelRec(node.left, max - 1) +  
               sumMaxLevelRec(node.right, max - 1); 
    } 
  
    public static int sumMaxLevel(Node1 root) { 
  
        // call to function to calculate 
        // max depth 
        int MaxDepth = maxDepth(root); 
          
        return sumMaxLevelRec(root, MaxDepth); 
    } 
  
    // maxDepth function to find the 
    // max depth of the tree 
    public static int maxDepth(Node1 node) 
    { 
        // base case 
        if (node == null)  
            return 0;      
  
        // either leftDepth of rightDepth is 
        // greater add 1 to include height 
        // of node at which call is 
        return 1 + Math.max(maxDepth(node.left),  
                           maxDepth(node.right));      
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
  
        /*      1 
              / \ 
              2   3 
            / \ / \ 
            4 5 6 7     */
  
        // Constructing tree 
        Node1 root = new Node1(1); 
        root.left = new Node1(2); 
        root.right = new Node1(3); 
        root.left.left = new Node1(4); 
        root.left.right = new Node1(5); 
        root.right.left = new Node1(6); 
        root.right.right = new Node1(7); 
  
  
        // call to calculate required sum 
        System.out.println(sumMaxLevel(root)); 
    } 
}
