class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.putIfAbsent(time[0], new ArrayList<>());
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        // minheap [weight, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        Set<Integer> visited = new HashSet<>();
        int time = 0;
        pq.offer(new int[] {0, k});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int c1 = curr[0];
            int n1 = curr[1];

            if (visited.contains(n1)) continue;

            visited.add(n1);
            time = c1;

            for (int[] edge : adj.getOrDefault(n1, new ArrayList<>())) {
                int n2 = edge[0];
                int c2 = edge[1];

                if (visited.contains(n2)) continue;

                pq.offer(new int[]{c1 + c2, n2});
            }
        }

        return visited.size() == n ? time : -1;
    }
}
