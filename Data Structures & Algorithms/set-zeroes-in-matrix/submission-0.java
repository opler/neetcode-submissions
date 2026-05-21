class Solution {
    public void setZeroes(int[][] matrix) {
        int nr = matrix.length;
        int nc = matrix[0].length;

        int fr = 1;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        fr = 0;
                    } else {
                        matrix[i][0] = 0;
                    }
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < nr; i++) {
            for (int j = 1; j < nc; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int i =0; i< nr;i++) {
                matrix[i][0] = 0;
            }
        }

        if (fr == 0) {
            for (int i=0; i < nc; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
