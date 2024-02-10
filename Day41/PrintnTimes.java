// Problem statement
// You are given an integer ‘n’.



// Print “Coding Ninjas ” ‘n’ times, without using a loop.



// Example:
// Input: ‘n’  = 4

// Output:
// Coding Ninjas Coding Ninjas Coding Ninjas Coding Ninjas 

// Explanation: “Coding Ninjas” is printed 4 times. 


// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 3


// Sample Output 1:
// Coding Ninjas Coding Ninjas Coding Ninjas 


// Explanation of sample output 1:
// “Coding Ninjas” is printed 3 times. 

// Sample Input 2:
// 5


// Sample Output 2:
// Coding Ninjas Coding Ninjas Coding Ninjas Coding Ninjas Coding Ninjas 


// Expected Time Complexity:
// Try to solve this in O(n).


// Expected Space Complexity:
// Try to solve this in O(n).


// Constraints:
// 1 <= 'n' <= 10^4

// Time Limit: 1 sec

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> printNtimes(int n) {

        List<String> result = new ArrayList<>();
        printNtimesHelper(n, result);
        
        return result;
    }
    
    private static void printNtimesHelper(int n, List<String> result) {
        if (n <= 0) {
            return;
        }
        
        result.add("Coding Ninjas");
        printNtimesHelper(n - 1, result);
    }
}
