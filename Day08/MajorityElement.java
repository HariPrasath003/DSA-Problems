// Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears strictly more than N/2 times in the array.
 

// Example 1:

// Input:
// N = 3 
// A[] = {1,2,3} 
// Output:
// -1
// Explanation:
// Since, each element in 
// {1,2,3} appears only once so there 
// is no majority element.
// Example 2:

// Input:
// N = 5 
// A[] = {3,1,3,3,2} 
// Output:
// 3
// Explanation:
// Since, 3 is present more
// than N/2 times, so it is 
// the majority element.

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
  // your code here
        int count = 0;
        int el = -1; 
        
        for (int i = 0; i < size; i++)
        {
            if (count == 0) {
                count = 1;
                el = a[i];
            } else if (a[i] == el) {
                count++;
            } else {
                count--;
            }
        }
        
        int count1 = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == el) {
                count1++;
            }
        }
        
        if (count1 > (size / 2)) {
            return el;
        }
        return -1;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)