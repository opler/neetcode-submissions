class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for (int[] pre : prerequisites) {
            List<Integer> n = adj.getOrDefault(pre[0], new ArrayList<>());
            n.add(pre[1]);
            adj.put(pre[0], n);
            indegree[pre[1]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        Set<Integer> courset = new HashSet<>();

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (courset.contains(curr)) {
                return false;
            } else {
                courset.add(curr);
            }
            for (int neighbour : adj.getOrDefault(curr, new ArrayList<>())) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0){
                    q.offer(neighbour);
                }
            }
        }
        return courset.size() == numCourses;
    }
}
