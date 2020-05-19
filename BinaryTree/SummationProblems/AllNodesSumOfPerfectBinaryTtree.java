//time comp=O(1)
package SummationProblems;

public class AllNodesSumOfPerfectBinaryTtree 
{
	// function to find sum of 
    // all of the nodes of given 
    // perfect binary tree 
    static double sumNodes(int l) 
    { 
          
        // no of leaf nodes 
        double leafNodeCount = Math.pow(2, l - 1); 
      
        double sumLastLevel = 0; 
      
        // sum of nodes at last level 
        sumLastLevel = (leafNodeCount *  
            (leafNodeCount + 1)) / 2; 
      
        // sum of all nodes 
        double sum = sumLastLevel * l; 
      
        return sum; 
    } 
      
    // Driver Code 
    public static void main (String[] args) { 
      
        int l = 3; 
        System.out.println(sumNodes(l)); 
    } 

}
