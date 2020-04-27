//Time Complexity: O(n*k),Auxiliary Space: O(n*k)
public class BinomialCoeff 
{
	// Returns value of Binomial Coefficient C(n, k) 
    static int binomialCoeff(int n, int k) 
    { 
    int C[][] = new int[n+1][k+1]; 
    int i, j; 
      
        // Calculate  value of Binomial Coefficient in bottom up manner 
    for (i = 0; i <= n; i++) 
    { 
        for (j = 0; j <= min(i, k); j++) 
        { 
            // Base Cases 
            if (j == 0 || j == i) 
                C[i][j] = 1; 
       
            // Calculate value using previously stored values 
            else
                C[i][j] = C[i-1][j-1] + C[i-1][j]; 
          } 
     } 
       
    return C[n][k]; 
    } 
  
    // A utility function to return minimum of two integers 
    static int min(int a, int b) 
    { 
    return (a<b)? a: b;  
    } 
  
    /* Driver program to test above function*/
    public static void main(String args[]) 
    { 
    int n = 5, k = 2; 
    System.out.println("Value of C("+n+","+k+") is "+binomialCoeff(n, k)); 
    } 
}

//Time Complexity: O(n*k),Auxiliary Space: O(k)
//class BinomialCoeff { 
//    
//    static int binomialCoeff(int n, int k) 
//    { 
//        int C[] = new int[k + 1]; 
//         
//        // nC0 is 1 
//        C[0] = 1;   
//       
//        for (int i = 1; i <= n; i++) 
//        { 
//            // Compute next row of pascal  
//            // triangle using the previous row 
//            for (int j = Math.min(i, k); j > 0; j--) 
//                C[j] = C[j] + C[j-1]; 
//        } 
//        return C[k]; 
//    } 
//      
//    /* Driver program  */
//    public static void main(String[] args)  
//    { 
//         int n = 5, k = 2; 
//            System.out.printf("Value of C(%d, %d) is %d "
//                                , n, k, binomialCoeff(n, k)); 
//    } 
//} 
