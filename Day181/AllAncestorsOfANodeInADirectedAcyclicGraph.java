// 2192. All Ancestors of a Node in a Directed Acyclic Graph : https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/?envType=daily-question&envId=2024-06-29


// You are given a positive integer n representing the number of nodes of a Directed Acyclic Graph (DAG). The nodes are numbered from 0 to n - 1 (inclusive).
// You are also given a 2D integer array edges, where edges[i] = [fromi, toi] denotes that there is a unidirectional edge from fromi to toi in the graph.
// Return a list answer, where answer[i] is the list of ancestors of the ith node, sorted in ascending order.
// A node u is an ancestor of another node v if u can reach v via a set of edges.

 
// Example 1:


// Input: n = 8, edgeList = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]
// Output: [[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
// Explanation:
// The above diagram represents the input graph.
// - Nodes 0, 1, and 2 do not have any ancestors.
// - Node 3 has two ancestors 0 and 1.
// - Node 4 has two ancestors 0 and 2.
// - Node 5 has three ancestors 0, 1, and 3.
// - Node 6 has five ancestors 0, 1, 2, 3, and 4.
// - Node 7 has four ancestors 0, 1, 2, and 3.

// Example 2:


// Input: n = 5, edgeList = [[0,1],[0,2],[0,3],[0,4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
// Output: [[],[0],[0,1],[0,1,2],[0,1,2,3]]
// Explanation:
// The above diagram represents the input graph.
// - Node 0 does not have any ancestor.
// - Node 1 has one ancestor 0.
// - Node 2 has two ancestors 0 and 1.
// - Node 3 has three ancestors 0, 1, and 2.
// - Node 4 has four ancestors 0, 1, 2, and 3.
 

// Constraints:

// 1 <= n <= 1000
// 0 <= edges.length <= min(2000, n * (n - 1) / 2)
// edges[i].length == 2
// 0 <= fromi, toi <= n - 1
// fromi != toi
// There are no duplicate edges.
// The graph is directed and acyclic.


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        for (int i = 0; i < n; i++) {
            dfs(graph, i, i, res, new boolean[n]);
        }

        for (int i = 0; i < n; i++) {
            res.get(i).sort(Integer::compareTo);
        }

        return res;
    }

    private void dfs(ArrayList<Integer>[] graph, int parent, int curr, List<List<Integer>> res, boolean[] visit) {

        visit[curr] = true;

        for (int dest : graph[curr]) {
            if (!visit[dest]) {
                
                res.get(dest).add(parent);
                dfs(graph, parent, dest, res, visit);
            }
        }
    }
}

// Time Complexity: O(n + e)
// Space Complexity: O(n + e)