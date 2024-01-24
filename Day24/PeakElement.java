// An element is called a peak element if its value is not smaller than the value of its adjacent elements(if they exists). Given an array arr[] of size N, Return the index of any one of its peak elements. 
// Note: The generated output will always be 1 if the index that you return is correct. Otherwise output will be 0. Also, arr[] will be in ascending order before the peak element, and in descending order after that.


// Example 1:

// Input: 
// N = 3
// arr[] = {1,2,3}
// Possible Answer: 2
// Generated Output: 1
// Explanation: index 2 is 3.
// It is the peak element as it is 
// greater than its neighbour 2.
// If 2 is returned then the generated output will be 1 else 0.
// Example 2:

// Input:
// N = 3
// arr[] = {3,4,2}
// Possible Answer: 1
// Output: 1
// Explanation: 4 (at index 1) is the 
// peak element as it is greater than 
// it's neighbor elements 3 and 2.
// If 1 is returned then the generated output will be 1 else 0.
 

// Your Task:
// You don't have to read input or print anything. Complete the function peakElement() which takes the array arr[] and its size N as input parameters and return the index of any one of its peak elements.

// Can you solve the problem in expected time complexity?

 

// Expected Time Complexity: O(log N)
// Expected Auxiliary Space: O(1)


// Constraints:
// 1 ≤ N ≤ 105
// 1 ≤ A[] ≤ 106

//{ Driver Code Starts
    import java.util.*;
    import java.io.*;
    class PeakElement{
        public static void main(String[] args)throws IOException{
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t=Integer.parseInt(in.readLine().trim());
            while(t-->0){
                int n=Integer.parseInt(in.readLine().trim());
                int[] a=new int[n];
                int[] tmp=new int[n];
                String s[]=in.readLine().trim().split(" ");
                for(int i=0;i<n;i++){
                    a[i]=Integer.parseInt(s[i]);
                    tmp[i] = a[i];
                }
                
                int f=0;
                int A=(new Solution()).peakElement(tmp,n);
                
                if(A<0 && A>=n)
                    out.println(0);
                else
                {
                    if(n==1 && A==0)
                        f=1;
                    else if(A==0 && a[0]>=a[1])
                        f=1;
                    else if(A==n-1 && a[n-1]>=a[n-2])
                        f=1;
                    else if(A >= 0 && A < n && a[A] >=a[A+1] && a[A]>= a[A-1])
                        f=1;
                    else
                        f=0;
                    out.println(f);
                }
            }
            out.close();
        }
    }
    // } Driver Code Ends
    
    
    /*Complete the function below*/
    
    class Solution
    {
        // Function to find the peak element
        // arr[]: input array
        // n: size of array a[]
        public int peakElement(int[] arr,int n)
        {
           //add code here.
            int start = 0;
            int end = n - 1;
            while (start < end)
            {
                int mid = start + (end - start) / 2;
                if (arr[mid] > arr[mid + 1])
                {
                    end = mid;
                }
                else
                {
                    start = mid + 1;
                }
            }
            return start;
        }
    }