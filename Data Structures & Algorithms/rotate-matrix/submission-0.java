class Solution {
    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix[0].length - 1;

        while (l < r) {
            for (int i = 0; i < r - l; i++) {
                int t = l;
                int b = r;

                int topLeft = matrix[t][l+i];
                // move bottom left to top left
                matrix[t][l+i] = matrix[b - i][l];
                // move bottom right to bottom left
                matrix[b - i][l] = matrix[b][r-i];
                // move top right to bottom right
                matrix[b][r-i] = matrix[t+i][r];
                // move topleft to top right
                matrix[t+i][r] = topLeft;
            }
            l++;
            r--;
        }
    }
}
