class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;

        boolean[][] visit = new boolean[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        // { time, x, y }
        int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        pq.offer(new int[] {grid[0][0], 0, 0});

        visit[0][0]  = true;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int t = curr[0];
            int x = curr[1];
            int y = curr[2];

            if (x == N -1 && y == N - 1) {
                return t;
            }
            
            for (int[] dir : dirs) {
                int i = x + dir[0];
                int j = y + dir[1];
                if (i < 0 || j < 0 || i >= N || j >= N || visit[i][j]) {
                    continue;
                }
                visit[i][j] = true;
                pq.offer(new int[] {Math.max(grid[i][j], t), i, j});
            }
        }
        return N * N;
    }
}
