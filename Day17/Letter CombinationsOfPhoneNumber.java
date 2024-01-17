// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]
 

// Constraints:

// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].

class Solution {
    private List<String> combos = new ArrayList<>();
    private HashMap<Character, String> phone = new HashMap<>();

    public List<String> letterCombinations(String digits) {
       if(digits == null || digits.length() == 0){
           return combos;
       }
       phone.put('2', "abc");
       phone.put('3', "def");
       phone.put('4', "ghi");
       phone.put('5', "jkl");
       phone.put('6', "mno");
       phone.put('7', "pqrs");
       phone.put('8', "tuv");
       phone.put('9', "wxyz");

       generateCombinations(digits, 0, new StringBuilder());

       return combos;
    }

    private void generateCombinations(String digits, int current, StringBuilder currentCombo){
        if (current == digits.length()) {
            combos.add(currentCombo.toString());
            return;
        }

        char currentDigit = digits.charAt(current);
        String letterOptions = phone.get(currentDigit);

        if(letterOptions != null){
            for(int i = 0; i < letterOptions.length(); i++){

                char letter = letterOptions.charAt(i);
                currentCombo.append(letter);
                
                generateCombinations(digits, current + 1, currentCombo);
                currentCombo.deleteCharAt(currentCombo.length()-1);
            }
        }
    }
}