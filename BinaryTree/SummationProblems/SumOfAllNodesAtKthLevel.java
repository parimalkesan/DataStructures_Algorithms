//time comp=0(n)
package SummationProblems;

public class SumOfAllNodesAtKthLevel 
{
	// Function to find sum of digits  
	// of elements at k-th level  
	static int sumAtKthLevel(String tree, int k)  
	{  
	    int level = -1;  
	    int sum = 0; // Initialize result  
	    int n = tree.length();  
	  
	    for (int i=0; i<n; i++)  
	    {  
	        // increasing level number  
	        if (tree.charAt(i) == '(')  
	            level++;  
	  
	        // decreasing level number  
	        else if (tree.charAt(i) == ')')  
	            level--;  
	  
	        else
	        {  
	            // check if current level is  
	            // the desired level or not  
	            if (level == k)  
	                sum += (tree.charAt(i)-'0');  
	        }  
	    }  
	  
	    // required sum  
	    return sum;  
	}  
	  
	// Driver program to test above  
	public static void main(String[] args)  
	{  
	    String tree = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";  
	    int k = 2;  
	    System.out.println(sumAtKthLevel(tree, k));  
	} 

}
