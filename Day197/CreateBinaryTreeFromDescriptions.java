// 2196. Create Binary Tree From Descriptions : https://leetcode.com/problems/create-binary-tree-from-descriptions/description/?envType=daily-question&envId=2024-07-15


// You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

// If isLefti == 1, then childi is the left child of parenti.
// If isLefti == 0, then childi is the right child of parenti.
// Construct the binary tree described by descriptions and return its root.

// The test cases will be generated such that the binary tree is valid.

 

// Example 1:


// Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
// Output: [50,20,80,15,17,19]
// Explanation: The root node is the node with value 50 since it has no parent.
// The resulting binary tree is shown in the diagram.
// Example 2:


// Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
// Output: [1,2,null,null,3,4]
// Explanation: The root node is the node with value 1 since it has no parent.
// The resulting binary tree is shown in the diagram.
 

// Constraints:

// 1 <= descriptions.length <= 104
// descriptions[i].length == 3
// 1 <= parenti, childi <= 105
// 0 <= isLefti <= 1
// The binary tree described by descriptions is valid.

import java.util.HashMap;
import java.util.HashSet;
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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> childrenSet = new HashSet<>();
        Map<Integer, int[]> childrenHashmap = new HashMap<>();

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2] == 1;

            childrenHashmap.putIfAbsent(parent, new int[]{-1, -1});
            childrenSet.add(child);

            if (isLeft) {
                childrenHashmap.get(parent)[0] = child;
            } else {
                childrenHashmap.get(parent)[1] = child;
            }
        }

        int headNodeVal = 0;
        for (int parent : childrenHashmap.keySet()) {
            if (!childrenSet.contains(parent)) {
                headNodeVal = parent;
                break;
            }
        }

        return constructTree(headNodeVal, childrenHashmap);
    }

    private TreeNode constructTree(int curNodeVal, Map<Integer, int[]> childrenHashmap) {
        TreeNode newNode = new TreeNode(curNodeVal);
        if (childrenHashmap.containsKey(curNodeVal)) {
            int[] children = childrenHashmap.get(curNodeVal);
            if (children[0] != -1) {
                newNode.left = constructTree(children[0], childrenHashmap);
            }
            if (children[1] != -1) {
                newNode.right = constructTree(children[1], childrenHashmap);
            }
        }
        return newNode;
    }
}


// Time Complexity: O(N)
// Space Complexity: O(N)