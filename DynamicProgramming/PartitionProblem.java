//time comp=O(sum*n),Auxiliary Space: O(sum*n)
public class PartitionProblem 
{
	// Returns true if arr[] can be partitioned in two subsets of 
    // equal sum, otherwise false 
    static boolean findPartition (int arr[], int n) 
    { 
        int sum = 0; 
        int i, j; 
  
        // Calculate sum of all elements 
        for (i = 0; i < n; i++) 
            sum += arr[i]; 
  
        if (sum%2 != 0) 
            return false; 
  
        boolean part[][]=new boolean[n+1][sum/2+1]; 
  
        // initialize top row as true for sum=0
        for (i = 0; i <= n; i++) 
            part[i][0] = true; 
  
        // If sum is not 0 and set is empty, 
        // then answer is false  
        for (i = 1; i <= sum/2; i++) 
            part[0][i] = false; 
  
        // Fill the partition table in bottom up manner 
        for (i = 1; i <=n; i++) 
        { 
            for (j = 1; j <=sum/2; j++) 
            { 
                part[i][j] = part[i-1][j]; 
                if (j>= arr[i-1]) 
                    part[i][j] = part[i][j] || 
                                 part[i-1][j-arr[i-1]]; 
            } 
        } 
  
        /* // uncomment this part to print table 
        for (i = 0; i <= sum/2; i++) 
        { 
            for (j = 0; j <= n; j++) 
                printf ("%4d", part[i][j]); 
            printf("\n"); 
        } */
  
        return part[n][sum/2]; 
    } 
  
    /*Driver function to check for above function*/
    public static void main (String[] args) 
    { 
        int arr[] = {3, 1, 1, 2, 2,1}; 
        int n = arr.length; 
        if (findPartition(arr, n) == true) 
            System.out.println("Can be divided into two subsets of equal sum"); 
        else
            System.out.println("Can not be divided into two subsets of equal sum"); 
    } 
}
