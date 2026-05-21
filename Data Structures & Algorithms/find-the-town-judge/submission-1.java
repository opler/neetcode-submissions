class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] delta = new int[n+1];
        for (int[] t : trust) {
            int t1 = t[0];
            int t2 = t[1];
            delta[t2]++;
            delta[t1]--;
        }
        for (int i = 1; i < n+1; i++) {
            if (delta[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
}