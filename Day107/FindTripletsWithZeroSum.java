// Given an array arr[] of n integers. Check whether it contains a triplet that sums up to zero. 

// Note: Return 1, if there is at least one triplet following the condition else return 0.

// Example 1:

// Input: n = 5, arr[] = {0, -1, 2, -3, 1}
// Output: 1
// Explanation: 0, -1 and 1 forms a triplet
// with sum equal to 0.
// Example 2:

// Input: n = 3, arr[] = {1, 2, 3}
// Output: 0
// Explanation: No triplet with zero sum exists. 

// Your Task:
// You don't need to read input or print anything. Your task is to complete the boolean function findTriplets() which takes the array arr[] and the size of the array (n) as inputs and print 1 if the function returns true else print 0 if the function returns false. 

// Expected Time Complexity: O(n2)
// Expected Auxiliary Space: O(1)

// Constraints:
// 1 <= n <= 104
// -106 <= Ai <= 106

//{ Driver Code Starts

import java.util.*;
class Triplets{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            Solution g=new Solution();
            if(g.findTriplets(a,n))
                System.out.println("1");
            else
                System.out.println("0");
                
        }
    }
}
// } Driver Code Ends
    
    
/*Complete the function below*/
    
    
class Solution{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        if (n < 3) {
            return false;
        }
        Arrays.sort(arr);
            
        for (int i = 0; i < n - 2; i++) {
    
            int left = i + 1;
            int right = n - 1;
            int target = -arr[i]; 
                
            while (left < right) {
            int sum = arr[left] + arr[right];
                
                if (sum == target) {
                    return true;
                } else if (sum < target) {
                    left++;
                } else {
                    right--; 
                }
            }
        }
    return false; 
    }
}