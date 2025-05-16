class Solution {
    private int count = 0;
    private int n;
    private int[] queens;

    public int solution(int n) {
        this.n = n;
        queens = new int[n];
        backtrack(0);
        return count;
    }

    private void backtrack(int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isPossible(row, col)) {
                queens[row] = col;
                backtrack(row + 1);
            }
        }
    }

    private boolean isPossible(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) return false;
            if (Math.abs(row - i) == Math.abs(col - queens[i])) return false;
        }
        return true;
    }
}
