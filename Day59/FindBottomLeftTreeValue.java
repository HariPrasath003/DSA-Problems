// Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

// Example 1:


// Input: root = [2,1,3]
// Output: 1
// Example 2:


// Input: root = [1,2,3,4,null,5,6,null,null,7]
// Output: 7
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// -231 <= Node.val <= 231 - 1


import java.util.*;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            throw new IllegalArgumentException("Invalid input: root is null");
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode leftmost = root; 
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            leftmost = queue.peek(); 
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        
        return leftmost.val;
    }
}
