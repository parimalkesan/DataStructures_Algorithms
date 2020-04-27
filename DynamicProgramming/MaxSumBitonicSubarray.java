//time=O(n),space=O(n)
public class MaxSumBitonicSubarray 
{
	// function to find the maximum  
    // sum bitonic subarray 
    static int maxSumBitonicSubArr(int arr[],  
                                   int n) 
    { 
          
    // 'msis[]' to store the maximum  
    // sum increasing subarray up to 
    // each index of 'arr' from the  
    // beginning 'msds[]' to store  
    // the maximum sum decreasing  
    // subarray from each index of  
    // 'arr' up to the end 
    int []msis = new int[n]; 
    int []msds = new int[n]; 
      
    // to store the maximum  
    // sum bitonic subarray 
    int max_sum = Integer.MIN_VALUE; 
      
    // building up the maximum  
    // sum increasing subarray 
    // for each array index 
    msis[0] = arr[0]; 
    for (int i = 1; i < n; i++) 
        if (arr[i] > arr[i - 1]) 
            msis[i] = msis[i - 1] +  
                       arr[i]; 
        else
            msis[i] = arr[i];  
      
    // building up the maximum  
    // sum decreasing subarray 
    // for each array index 
    msds[n - 1] = arr[n - 1]; 
    for (int i = n - 2; i >= 0; i--) 
        if (arr[i] > arr[i + 1]) 
            msds[i] = msds[i + 1] + arr[i]; 
        else
            msds[i] = arr[i]; 
      
    // for each array index,  
    // calculating the maximum  
    // sum of bitonic subarray  
    // of which it is a part of 
    for (int i = 0; i < n; i++)          
      
        // if true , then update  
        // 'max' bitonic subarray sum 
        if (max_sum < (msis[i] + 
                       msds[i] - arr[i])) 
            max_sum = msis[i] +  
                      msds[i] - arr[i]; 
      
    // required maximum sum 
    return max_sum; 
    } 
      
    // Driver Code 
    public static void main(String[] args) 
    { 
        int arr[] = {5, 3, 9, 2, 7, 6, 4}; 
        int n = arr.length; 
        System.out.println( "Maximum Sum = " +  
                 maxSumBitonicSubArr(arr, n)); 
    } 

}
