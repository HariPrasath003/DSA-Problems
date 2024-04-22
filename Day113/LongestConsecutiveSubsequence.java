// Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 

// Example 1:

// Input:
// N = 7
// a[] = {2,6,1,9,4,5,3}
// Output:
// 6
// Explanation:
// The consecutive numbers here
// are 1, 2, 3, 4, 5, 6. These 6 
// numbers form the longest consecutive
// subsquence.
// Example 2:

// Input:
// N = 7
// a[] = {1,9,3,10,4,20,2}
// Output:
// 4
// Explanation:
// 1, 2, 3, 4 is the longest
// consecutive subsequence.

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function findLongestConseqSubseq() which takes the array arr[] and the size of the array as inputs and returns the length of the longest subsequence of consecutive integers. 


// Expected Time Complexity: O(R), where R is the maximum integer in the array.
// Expected Auxiliary Space: O(N).


// Constraints:
// 1 <= N <= 105
// 0 <= a[i] <= 105


//{ Driver Code Starts
//Initial Template for Java

import java.math.*;
import java.util.*;
import java.io.*;

class Driverclass
{
    // Driver Code
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }
    
	public static void main(String args[])
	{
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
		    out.println(new Solution().findLongestConseqSubseq(a, n));
		    t--;
		}
		out.close();
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution
{   
    static int findLongestConseqSubseq(int arr[], int N)
    {
        if (N <= 1) return N;
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }
        
        int longest = 0;

        for (int num : arr) {

            if (!numSet.contains(num - 1)) {
                
                int currentNum = num;
                int currentlen = 0;
                
                while (numSet.contains(currentNum)) {
                    currentNum++;
                    currentlen++;
                }

                longest = Math.max(longest, currentlen);
            }
        }
        
        return longest;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N)