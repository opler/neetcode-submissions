class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for ( int i = 0; i < grid.length; i++) {
            for ( int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = areaOfIsland(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }

    public int areaOfIsland(int[][] grid, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;

        if ( i < 0 || i >= nr || j < 0 || j >= nc || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        return areaOfIsland(grid, i+1, j) + areaOfIsland(grid, i-1, j) + areaOfIsland(grid, i, j+1) + areaOfIsland(grid, i, j-1) + 1;

    }
}
