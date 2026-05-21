class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int water = -1;
        int target = 0;
        int land = 2147483647;

        Deque<int[]> q = new ArrayDeque<>();

        int nr = grid.length;
        int nc = grid[0].length;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == target) {
                    q.offer(new int[] {i, j, 0});
                }
            }
        }

        if (q.isEmpty()) {
            return;
        }

        int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[2] <= grid[curr[0]][curr[1]]) {
                grid[curr[0]][curr[1]] = curr[2];

                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if ( x >= nr || x < 0 || y < 0 || y >= nc || grid[x][y] != land ) {
                        continue;
                    }
                    q.add(new int[] { x, y, curr[2] + 1 });
                }
            }
        }
        
    }
}
