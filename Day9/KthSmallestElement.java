// Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

// Note :-  l and r denotes the starting and ending index of the array.

// Example 1:

// Input:
// N = 6
// arr[] = 7 10 4 3 20 15
// K = 3
// L=0 R=5

// Output : 7
// Explanation :
// 3rd smallest element in the given 
// array is 7.
// Example 2:

// Input:
// N = 5
// arr[] = 7 10 4 20 15
// K = 4 L=0 R=4
// Output : 15
// Explanation :
// 4th smallest element in the given 
// array is 15.


//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
       
        if (k > 0 && k <= r - l + 1) 
        {
        
            int pos = partition(arr, l, r);

       
            if (pos - l == k - 1)
            {
                return arr[pos];
            }


            if (pos - l > k - 1) 
            {
                return kthSmallest(arr, l, pos - 1, k);
            }


            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }


        return Integer.MAX_VALUE;
    }

    private static int partition(int[] arr, int l, int r) 
    {
        int pivot = arr[r];
        int i = l - 1;

        for (int j = l; j < r; j++) 
        {
            if (arr[j] <= pivot) 
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }


        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;

        return i + 1;
        
    } 
}
