// 726. Number of Atoms : https://leetcode.com/problems/number-of-atoms/description/?envType=daily-question&envId=2024-07-14


// Given a string formula representing a chemical formula, return the count of each atom.
// The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
// One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1, no digits will follow.
// For example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
// Two formulas are concatenated together to produce another formula.
// For example, "H2O2He3Mg4" is also a formula.
// A formula placed in parentheses, and a count (optionally added) is also a formula.
// For example, "(H2O2)" and "(H2O2)3" are formulas.
// Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
// The test cases are generated so that all the values in the output fit in a 32-bit integer.

 
// Example 1:

// Input: formula = "H2O"
// Output: "H2O"
// Explanation: The count of elements are {'H': 2, 'O': 1}.

// Example 2:

// Input: formula = "Mg(OH)2"
// Output: "H2MgO2"
// Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.

// Example 3:

// Input: formula = "K4(ON(SO3)2)2"
// Output: "K4N2O14S4"
// Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 

// Constraints:

// 1 <= formula.length <= 1000
// formula consists of English letters, digits, '(', and ')'.
// formula is always valid.


class Solution {
    public String countOfAtoms(String formula) {
        
        int n = formula.length();
        Map<String, Integer> result_counter = new HashMap<>();
        Deque<Map<String, Integer>> parenthesis_stack = new ArrayDeque<>();
        int cur_ind = 0;

        while (cur_ind < n) {
            char cur_char = formula.charAt(cur_ind);

            if (cur_char == '(') {
                cur_ind++;
                parenthesis_stack.push(new HashMap<>());
                continue;
            }

            if (cur_char == ')') {
                StringBuilder mult_str = new StringBuilder();
                cur_ind++;

                while (cur_ind < n && Character.isDigit(formula.charAt(cur_ind))) {
                    mult_str.append(formula.charAt(cur_ind));
                    cur_ind++;
                }

                int mult = mult_str.length() == 0 ? 1 : Integer.parseInt(mult_str.toString());
                Map<String, Integer> last_counter = parenthesis_stack.pop();
                Map<String, Integer> target = parenthesis_stack.isEmpty() ? result_counter : parenthesis_stack.peek();
                
                for (Map.Entry<String, Integer> entry : last_counter.entrySet()) {
                    target.put(entry.getKey(), target.getOrDefault(entry.getKey(), 0) + entry.getValue() * mult);
                }
                continue;
            }

            StringBuilder cur_elem = new StringBuilder();
            StringBuilder cur_counter_str = new StringBuilder();
            Map<String, Integer> target = parenthesis_stack.isEmpty() ? result_counter : parenthesis_stack.peek();

            while (cur_ind < n && formula.charAt(cur_ind) != '(' && formula.charAt(cur_ind) != ')') {
                if (Character.isAlphabetic(formula.charAt(cur_ind))) {
                    if (Character.isUpperCase(formula.charAt(cur_ind)) && cur_elem.length() > 0) {
                        target.put(cur_elem.toString(), target.getOrDefault(cur_elem.toString(), 0) + (cur_counter_str.length() == 0 ? 1 : Integer.parseInt(cur_counter_str.toString())));
                        cur_elem = new StringBuilder();
                        cur_counter_str = new StringBuilder();
                    }
                    cur_elem.append(formula.charAt(cur_ind));
                } else {
                    cur_counter_str.append(formula.charAt(cur_ind));
                }
                cur_ind++;
            }

            target.put(cur_elem.toString(), target.getOrDefault(cur_elem.toString(), 0) + (cur_counter_str.length() == 0 ? 1 : Integer.parseInt(cur_counter_str.toString())));
        }

        List<String> parts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : result_counter.entrySet()) {
            parts.add(entry.getKey() + (entry.getValue() == 1 ? "" : entry.getValue()));
        }
        Collections.sort(parts);

        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(part);
        }

        return result.toString();
    }
}