class Solution {
    static int count = 0;
    static int n;
    static int[] queens;

    public int solution(int n) {
        this.n = n;
        queens = new int[n];
        backtrack(0);
        return count;
    }

    static void backtrack(int x) {
        if (x == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            queens[x] = i;

            if (isPossible(x)) {
                backtrack(x + 1);
            }
        }
    }

    static boolean isPossible(int x) {
        for (int i = 0; i < x; i++) {
            if (queens[i] == queens[x] || Math.abs(x - i) == Math.abs(queens[x] - queens[i])) {
                return false;
            }
        }
        return true;
    }
}