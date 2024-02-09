// Problem statement
// You are given an integer 'n'.

// Return 'true' if 'n' is an Armstrong number, and 'false' otherwise.

// Note:
// An Armstrong number is a number (with 'k' digits) such that the sum of its digits raised to 'kth' power is equal to the number itself. For example, 371 is an Armstrong number because 3^3 + 7^3 + 1^3 = 371.


// Example:
// Input: 'n' = 1634

// Output: true

// Explanation:
// 1634 is an Armstrong number, as 1^4 + 6^4 + 3^4 + 4^4 = 1634


// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1 :
// 1


// Sample Output 1 :
// true


// Explanation of Sample Input 1 :
// 1 is an Armstrong number as, 1^1 = 1.


// Sample Input 2 :
// 103


// Sample Output 2 :
// false


// Expected Time Complexity:
// Try to solve this in O(log(n)). 


// Constraints:
// 1 <= ‘n’ <= 10^9

// Time Limit: 1 sec

import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int sum = 0;
		int duplicateN = n;

		while(n>0){
			int ld = n % 10;
			sum = sum + (ld*ld*ld);
			n = n/10;
		}

		System.out.println(duplicateN == sum);
	}
}
