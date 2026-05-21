class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(n, 0, cache);
    }

    public int dfs(int n, int i, int[] cache) {
        if (i == n) return 1;

        if (i > n) return 0;

        if (cache[i] != -1) return cache[i];

        cache[i] = dfs(n, i+1, cache) + dfs(n, i+2, cache);
        return cache[i];
    }
}
