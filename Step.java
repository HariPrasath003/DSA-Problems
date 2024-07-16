// 2096. Step-By-Step Directions From a Binary Tree Node to Another : https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/?envType=daily-question&envId=2024-07-16


// You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.
// Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:
// 'L' means to go from a node to its left child node.
// 'R' means to go from a node to its right child node.
// 'U' means to go from a node to its parent node.
// Return the step-by-step directions of the shortest path from node s to node t.


// Example 1:


// Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
// Output: "UURL"
// Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.


// Example 2:


// Input: root = [2,1], startValue = 2, destValue = 1
// Output: "L"
// Explanation: The shortest path is: 2 → 1.
 

// Constraints:

// The number of nodes in the tree is n.
// 2 <= n <= 105
// 1 <= Node.val <= n
// All the values in the tree are unique.
// 1 <= startValue, destValue <= n
// startValue != destValue



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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode startNode = null;

        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();

            if (curNode.val == startValue) {
                startNode = curNode;
                break;
            }

            if (curNode.left != null) {
                q.offer(curNode.left);
            }
            if (curNode.right != null) {
                q.offer(curNode.right);
            }
        }

        Map<Integer, TreeNode> nodesParents = new HashMap<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();

            if (curNode.left != null) {
                nodesParents.put(curNode.left.val, curNode);
                q.offer(curNode.left);
            }
            if (curNode.right != null) {
                nodesParents.put(curNode.right.val, curNode);
                q.offer(curNode.right);
            }
        }

        Set<TreeNode> visited = new HashSet<>();
        q.offer(startNode);
        Map<TreeNode, Pair<TreeNode, String>> trackedPath = new HashMap<>();
        TreeNode destinationNode = null;

        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();
            visited.add(curNode);

            if (curNode.val == destValue) {
                destinationNode = curNode;
                break;
            }

            if (nodesParents.containsKey(curNode.val) && !visited.contains(nodesParents.get(curNode.val))) {
                TreeNode parent = nodesParents.get(curNode.val);
                q.offer(parent);
                trackedPath.put(parent, new Pair<>(curNode, "U"));
            }

            if (curNode.left != null && !visited.contains(curNode.left)) {
                q.offer(curNode.left);
                trackedPath.put(curNode.left, new Pair<>(curNode, "L"));
            }

            if (curNode.right != null && !visited.contains(curNode.right)) {
                q.offer(curNode.right);
                trackedPath.put(curNode.right, new Pair<>(curNode, "R"));
            }
        }

        List<String> resultPath = new ArrayList<>();
        TreeNode curNode = destinationNode;

        while (curNode != startNode) {
            Pair<TreeNode, String> sourceAndDirection = trackedPath.get(curNode);
            resultPath.add(sourceAndDirection.getValue());
            curNode = sourceAndDirection.getKey();
        }

        Collections.reverse(resultPath);
        return String.join("", resultPath);
    }
}


// Time Complexity: O(N) where N is the number of nodes in the tree.
// Space complexity: O(N) where N is the number of