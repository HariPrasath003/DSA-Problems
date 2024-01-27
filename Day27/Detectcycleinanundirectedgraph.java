// Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.

// Example 1:

// Input:  
// V = 5, E = 5
// adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
// Output: 1
// Explanation: 

// 1->2->3->4->1 is a cycle.
// Example 2:

// Input: 
// V = 4, E = 2
// adj = {{}, {2}, {1, 3}, {2}}
// Output: 0
// Explanation: 

// No cycle in the graph.
 

// Your Task:
// You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not, return 1 if a cycle is present else return 0.

// NOTE: The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which ith vertex is connected.

 

// Expected Time Complexity: O(V + E)
// Expected Space Complexity: O(V)


 

// Constraints:
// 1 ≤ V, E ≤ 105

//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while (T-- > 0) {
                String[] s = br.readLine().trim().split(" ");
                int V = Integer.parseInt(s[0]);
                int E = Integer.parseInt(s[1]);
                ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
                for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
                for (int i = 0; i < E; i++) {
                    String[] S = br.readLine().trim().split(" ");
                    int u = Integer.parseInt(S[0]);
                    int v = Integer.parseInt(S[1]);
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
                Solution obj = new Solution();
                boolean ans = obj.isCycle(V, adj);
                if (ans)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        // Function to detect cycle in an undirected graph.
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
           boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, adj, visited, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCyclicUtil(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        visited[v] = true;

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, adj, visited, v)) {
                    return true;
                }
            } else if (neighbor != parent) {
               
                return true;
            }
        }

        return false;
        }
    }