// Given an unsorted array arr[] of size N. Rotate the array to the left (counter-clockwise direction) by D steps, where D is a positive integer. 

 

// Example 1:

// Input:
// N = 5, D = 2
// arr[] = {1,2,3,4,5}
// Output: 3 4 5 1 2
// Explanation: 1 2 3 4 5  when rotated
// by 2 elements, it becomes 3 4 5 1 2.
// Example 2:

// Input:
// N = 10, D = 3
// arr[] = {2,4,6,8,10,12,14,16,18,20}
// Output: 8 10 12 14 16 18 20 2 4 6
// Explanation: 2 4 6 8 10 12 14 16 18 20 
// when rotated by 3 elements, it becomes 
// 8 10 12 14 16 18 20 2 4 6.
 

// Your Task:
// You need not print or read anything. You need to complete the function rotateArr() which takes the array, D and N as input parameters and rotates the array by D elements. The array must be modified in-place without using extra space. 

 

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)

 

// Constraints:
// 1 <= N <= 106
// 1 <= D <= 106
// 0 <= arr[i] <= 105

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out=new PrintWriter(System.out);
        //taking testcases
        int t = Integer.parseInt(br.readLine()); 
    	for(int i=0;i<t;i++)
    	{
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int d= Integer.parseInt(starr[1]);
    		
            int[] arr=new int[n];
    		String str1=br.readLine();
    		String[] starr1=str1.split(" ");
    		
    		//inserting elements in the array
    		for(int j=0;j<n;j++)
    		{
    		  arr[j]= Integer.parseInt(starr1[j]);
    		}
    		
    		//calling rotateArr() function
            new Solution().rotateArr(arr, d, n);
    		StringBuffer sb=new StringBuffer();
    		
    		//printing the elements of the array
            for(int t1=0;t1<n;t1++)
                sb.append(arr[t1]+" ");
            out.println(sb);
         }
         out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    private static void reverse(int[] arr, int start, int end) {
        
        while (start < end) {
            
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
    }
    static void rotateArr(int arr[], int d, int n)
    {
        d = d % n;
        reverse(arr, 0, d - 1);
        
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }
}
