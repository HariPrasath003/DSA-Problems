// Given an array A of n non negative numbers. The task is to find the first equilibrium point in an array. Equilibrium point in an array is an index (or position) such that the sum of all elements before that index is same as sum of elements after it.

// Note: Return equilibrium point in 1-based indexing. Return -1 if no such point exists. 

// Example 1:

// Input: 
// n = 5 
// A[] = {1,3,5,2,2} 
// Output: 
// 3 
// Explanation:  
// equilibrium point is at position 3 as sum of elements before it (1+3) = sum of elements after it (2+2). 
// Example 2:

// Input:
// n = 1
// A[] = {1}
// Output: 
// 1
// Explanation:
// Since there's only element hence its only the equilibrium point.
// Your Task:
// The task is to complete the function equilibriumPoint() which takes the array and n as input parameters and returns the point of equilibrium. 

// Expected Time Complexity: O(n)
// Expected Auxiliary Space: O(1)

// Constraints:
// 1 <= n <= 105
// 0 <= A[i] <= 109

//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    import java.util.stream.*;
    
    class Main {
    
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
            while (t-- > 0) {
                
                //taking input n
                int n = Integer.parseInt(br.readLine().trim());
                long arr[] = new long[n];
                String inputLine[] = br.readLine().trim().split(" ");
                
                //adding elements to the array
                for (int i = 0; i < n; i++) {
                    arr[i] = Long.parseLong(inputLine[i]);
                }
    
                Solution ob = new Solution();
                
                //calling equilibriumPoint() function
                System.out.println(ob.equilibriumPoint(arr, n));
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
    
        
        // a: input array
        // n: size of array
        // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long[] arr, int n) {
        
            if(n==1){
                return 1;
            }
            long sum = 0;
            
            for(int i=0;i<n;i++){
                sum +=arr[i];
            }
            long leftSum = 0;
            
            for(int i=0;i<n;i++){
                sum -=arr[i];
                if(leftSum==sum){
                    return i+1;
                }
                leftSum +=arr[i];
            }
            return -1;
    
        }
    }
    
    