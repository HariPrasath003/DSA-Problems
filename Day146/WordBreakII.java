// Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

// Example 1:

// Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
// Output: ["cats and dog","cat sand dog"]
// Example 2:

// Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
// Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
// Explanation: Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: []
 
// Constraints:

// 1 <= s.length <= 20
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 10
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.
// Input is generated in a way that the length of the answer doesn't exceed 105.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> hs = new HashSet<>(wordDict);

        return wordBreakHelper(s, 0, hs);
    }

    private List<String> wordBreakHelper(String s, int start, HashSet<String> dict) {
        List<String> validSubstr = new ArrayList<>();

        if (start == s.length())
            validSubstr.add("");

        for (int end = start + 1; end <= s.length(); end++) {

            String prefix = s.substring(start, end);

            if (dict.contains(prefix)) {

                List<String> suffixes = wordBreakHelper(s, end, dict);
                for (String suffix : suffixes) {
                    
                    validSubstr.add(prefix + (suffix.equals("") ? "" : " ") + suffix);
                }
            }
        }
        return validSubstr;
    }
}


// Time Complexity: O(2^N)
// Space Complexity: O(2^N)