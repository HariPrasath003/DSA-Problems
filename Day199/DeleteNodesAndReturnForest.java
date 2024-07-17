// 1110. Delete Nodes And Return Forest : https://leetcode.com/problems/delete-nodes-and-return-forest/description/?envType=daily-question&envId=2024-07-17

// Given the root of a binary tree, each node in the tree has a distinct value.
// After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
// Return the roots of the trees in the remaining forest. You may return the result in any order.

 
// Example 1:


// Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
// Output: [[1,2,null,4],[6],[7]]


// Example 2:

// Input: root = [1,2,4,null,3], to_delete = [3]
// Output: [[1,2,4]]
 

// Constraints:

// The number of nodes in the given tree is at most 1000.
// Each node has a distinct value between 1 and 1000.
// to_delete.length <= 1000
// to_delete contains distinct values between 1 and 1000.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        Map<Integer, TreeNode> res = new HashMap<>();
        Set<Integer> to_delete_set = new HashSet<>();
        
        for (int val : to_delete) {
            to_delete_set.add(val);
        }
        res.put(root.val, root);

        recursion(null, root, false, res, to_delete_set);

        return new ArrayList<>(res.values());
    }

    private void recursion(TreeNode parent, TreeNode cur_node, boolean isleft, Map<Integer, TreeNode> res, Set<Integer> to_delete_set) {
        if (cur_node == null) return;

        recursion(cur_node, cur_node.left, true, res, to_delete_set);
        recursion(cur_node, cur_node.right, false, res, to_delete_set);

        if (to_delete_set.contains(cur_node.val)) {
            res.remove(cur_node.val);

            if (parent != null) {
                if (isleft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }

            if (cur_node.left != null) {
                res.put(cur_node.left.val, cur_node.left);
            }
            if (cur_node.right != null) {
                res.put(cur_node.right.val, cur_node.right);
            }
        }
    }
}


// Time Complexity: O(N)
// Space Complexity: O(N)