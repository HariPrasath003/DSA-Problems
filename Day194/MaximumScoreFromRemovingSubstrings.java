package Day194;

import java.util.Stack;

// 1717. Maximum Score From Removing Substrings : https://leetcode.com/problems/maximum-score-from-removing-substrings/description/?envType=daily-question&envId=2024-07-12


// You are given a string s and two integers x and y. You can perform two types of operations any number of times.

// Remove substring "ab" and gain x points.
// For example, when removing "ab" from "cabxbae" it becomes "cxbae".
// Remove substring "ba" and gain y points.
// For example, when removing "ba" from "cabxbae" it becomes "cabxe".
// Return the maximum points you can gain after applying the above operations on s.

 
// Example 1:

// Input: s = "cdbcbbaaabab", x = 4, y = 5
// Output: 19
// Explanation:
// - Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
// - Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
// - Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
// - Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
// Total score = 5 + 4 + 5 + 5 = 19.


// Example 2:

// Input: s = "aabbaaxybbaabb", x = 5, y = 4
// Output: 20
 

// Constraints:

// 1 <= s.length <= 105
// 1 <= x, y <= 104
// s consists of lowercase English letters.


class Solution {
    public int maximumGain(String s, int x, int y) {
      
      if(x > y){
          return helper(s,'a','b',x,y);
      }
      else{
          return helper(s,'b','a',y,x);
      }
  }

  public static int helper(String s,char higherChar,char lowerChar,
                           int higherValue,int lowerValue){

      Stack<Character> stack = new Stack<>();
      int maxPoints = 0;

      for(Character ch : s.toCharArray()){

          if(!stack.isEmpty() && stack.peek() == higherChar && ch == lowerChar){
              stack.pop();
              maxPoints += higherValue;
          }
          else{
              stack.push(ch);
          }
      }

      StringBuilder remaining = new StringBuilder();
      while(!stack.isEmpty()){
          remaining.append(stack.pop());
      }
      remaining.reverse();

      for(Character ch : remaining.toString().toCharArray()){

          if(!stack.isEmpty() && stack.peek() == lowerChar && ch == higherChar){
              stack.pop();
              maxPoints += lowerValue;
          }
          else{
              stack.push(ch);
          }
      }

      return maxPoints;
  }
}