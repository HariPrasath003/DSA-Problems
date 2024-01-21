// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false
 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

class Solution {
public:
    bool isValid(string s) {

        Stack<Character> stack = new Stack<>();

            for(int i = 0; i < x.length(); i++){

                char c = x.charAt(i);
                if(c == '(' || c == '{' || c == '['){
                    stack.push(c);

                }else if(c == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }

                }else if(c == '}'){
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                    
                }else if(c == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        
    }
};