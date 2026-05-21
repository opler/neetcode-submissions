class Solution {
    public int minCostConnectPoints(int[][] points) {
        int totalPoints = points.length;

        // adjList --> point : {cost, vertice}
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for( int i = 0; i < totalPoints; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < totalPoints; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }

        // create minheap, visited
        int res = 0;
        Set<Integer> visit = new HashSet<>();

        // iterate through minHeap in bfs fashion
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, 0});

        while (visit.size() < totalPoints) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];

            if (visit.contains(node)) {
                continue;
            }
            visit.add(node);
            res += cost;

            for (int[] n : adj.getOrDefault(node, new ArrayList<>())) {
                int ncost = n[0];
                int nnode = n[1];
                if (visit.contains(nnode)) {
                    continue;
                }
                pq.offer(new int[] {ncost, nnode});
            }
        }

        return res;
    }
}
