// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]
 

// Constraints:

// 1 <= n <= 8

 HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        int count = 0; 
        
  
        for (int i = 0; i < n; i++) {
            int complement = k - arr[i];
            

            if (frequencyMap.containsKey(complement)) {
                count += frequencyMap.get(complement);
            }
            
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }
        
        return count;
    }