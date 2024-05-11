// There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker and wage[i] is the minimum wage expectation for the ith worker.

// We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:

// Every worker in the paid group must be paid at least their minimum wage expectation.
// In the group, each worker's pay must be directly proportional to their quality. This means if a worker’s quality is double that of another worker in the group, then they must be paid twice as much as the other worker.
// Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions. Answers within 10-5 of the actual answer will be accepted.

 

// Example 1:

// Input: quality = [10,20,5], wage = [70,50,30], k = 2
// Output: 105.00000
// Explanation: We pay 70 to 0th worker and 35 to 2nd worker.
// Example 2:

// Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
// Output: 30.66667
// Explanation: We pay 4 to 0th worker, 13.33333 to 2nd and 3rd workers separately.
 

// Constraints:

// n == quality.length == wage.length
// 1 <= k <= n <= 104
// 1 <= quality[i], wage[i] <= 104

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] expWage, int k) {
        int n = expWage.length;

        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            double ratio = (double) expWage[i] / quality[i];
            workers[i] = new Worker(ratio, quality[i]);
        }

        Arrays.sort(workers, Comparator.comparingDouble(w -> w.ratio));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int sumHeap = 0;
        for (int i = 0; i < k; i++) {
            maxHeap.offer(workers[i].quality);
            sumHeap += workers[i].quality;
        }
        double captainRatio = workers[k - 1].ratio;
        double minCost = captainRatio * sumHeap;

        for (int captain = k; captain < n; captain++) {
            captainRatio = workers[captain].ratio;

            if (!maxHeap.isEmpty() && workers[captain].quality < maxHeap.peek()) {
                sumHeap -= maxHeap.poll();
                maxHeap.offer(workers[captain].quality);
                sumHeap += workers[captain].quality;
            }
            double cost = captainRatio * sumHeap;
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }
}

class Worker {
        double ratio;
        int quality;

        Worker(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }
    }

// Time Complexity: O(nlogn)
// Space Complexity: O(n)