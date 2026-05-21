class Solution {
    public void solve(char[][] board) {
        int NR = board.length;
        int NC = board[0].length;

        for (int i = 0 ; i < NR; i++) {
            if (board[i][0] == 'O') {
                capture(board, i, 0, NR, NC);
            }
            if (board[i][NC - 1] == 'O') {
                capture(board, i, NC - 1, NR, NC);
            }
        }
        for (int i = 0 ; i < NC; i++) {
            if (board[0][i] == 'O') {
                capture(board, 0, i, NR, NC);
            }
            if (board[NR - 1][i] == 'O') {
                capture(board, NR - 1, i, NR, NC);
            }
        }

        for (int i = 0; i < NR; i++) {
            for (int j = 0; j < NC; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void capture(char[][] board, int i, int j, int NR, int NC) {
        if (i < 0 || j < 0 || i >= NR || j >= NC || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        capture(board, i+1, j, NR, NC);
        capture(board, i-1, j, NR, NC);
        capture(board, i, j+1, NR, NC);
        capture(board, i, j-1, NR, NC);
    }
}
