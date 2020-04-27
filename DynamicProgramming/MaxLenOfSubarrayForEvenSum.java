//time=O(n)
public class MaxLenOfSubarrayForEvenSum 
{
	// Function to find length of the longest 
    // subarray such that sum of the 
    // subarray is even 
    static int maxLength(int a[], int n) 
    { 
        int sum = 0, len = 0; 
  
        // Check if sum of complete array is even 
        for (int i = 0; i < n; i++) 
        { 
            sum += a[i]; 
        } 
  
        if (sum % 2 == 0) // total sum is already even 
        { 
            return n; 
        } 
  
        // Find an index i such the a[i] is odd 
        // and compare length of both halfs excluding 
        // a[i] to find max length subarray 
        for (int i = 0; i < n; i++)  
        { 
            if (a[i] % 2 == 1) 
            { 
                len = Math.max(len, Math.max(n - i - 1, i)); 
            } 
        } 
  
        return len; 
    } 
  
    // Driver Code 
    public static void main(String[] args) 
    { 
        int a[] = {1, 2, 3,1, 2}; 
        int n = a.length; 
        System.out.println(maxLength(a, n)); 
    }
}
