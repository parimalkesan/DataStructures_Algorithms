//Time Complexity : O(n),Auxiliary Space : O(n)
//public class FriendsPairingProblem
//{
//	// Returns count of ways n people 
//    // can remain single or paired up. 
//    static int countFriendsPairings(int n) 
//    { 
//        int dp[] = new int[n + 1]; 
//  
//        // Filling dp[] in bottom-up manner using 
//        // recursive formula explained above. 
//        for (int i = 0; i <= n; i++) { 
//            if (i <= 2) 
//                dp[i] = i; 
//            else
//                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2]; 
//        } 
//  
//        return dp[n]; 
//    } 
//  
//    // Driver code 
//    public static void main(String[] args) 
//    { 
//        int n = 4; 
//        System.out.println(countFriendsPairings(n)); 
//    } 
//}

//Time Complexity : O(n),Auxiliary Space : O(1)
class FriendsPairingProblem{ 
    // Returns count of ways n people 
    // can remain single or paired up. 
    static int countFriendsPairings(int n) 
    { 
        int a = 1, b = 2, c = 0; 
        if (n <= 2) { 
            return n; 
        } 
        for (int i = 3; i <= n; i++) { 
            c = b + (i - 1) * a; 
            a = b; 
            b = c; 
        } 
        return c; 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        int n = 4; 
        System.out.println(countFriendsPairings(n)); 
    } 
} 
