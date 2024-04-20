// Given two integers n and r, find nCr. Since the answer may be very large, calculate the answer modulo 109+7.

// Example 1:

// Input: n = 3, r = 2
// Output: 3
// Explaination: 3C2 = 3. 
// Example 2:

// Input: n = 2, r = 4
// Output: 0
// Explaination: r is greater than n.
// Your Task:
// You do not need to take input or print anything. Your task is to complete the function nCr() which takes n and r as input parameters and returns nCr modulo 109+7..

// Expected Time Complexity: O(n*r)
// Expected Auxiliary Space: O(r)

// Constraints:
// 1 ≤ n ≤ 1000
// 1 ≤ r ≤ 800

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution{
    static int nCr(int n, int r){
        
        int[] arr = new int[r+1];
        arr[0] = 1;
        
        for(int i=1;i<=n;i++){
            for(int j=Math.min(i,r);j>0;j--){
                
                arr[j] = (arr[j] + arr[j-1])%(1000000007);
            }
        }
        return arr[r];
    }
}

// Time Complexity: O(n*r)
// Space Complexity: O(r)